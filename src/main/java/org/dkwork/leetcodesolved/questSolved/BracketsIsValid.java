package org.dkwork.leetcodesolved.questSolved;

import java.util.Scanner;

/**
 * @author jin
 * @date 2020/12/7
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProject LeetCodeSolved
 * @BelongPackage org.dkwork.leetcodesolved.questSolved
 * @Describe: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class BracketsIsValid {

    public static void main(String[] args) {
        System.out.println(isValid(new Scanner(System.in).nextLine()));
    }

    private static Boolean isValid(String s) {
        String[] strings = new String[s.length()];
        int top = -1;
        if (s.isEmpty()) return true;
        if (s.length() % 2 != 0) return false;
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            switch (str) {
                case "(":
                    strings[++top] = ")";
                    break;
                case "[":
                    strings[++top] = "]";
                    break;
                case "{":
                    strings[++top] = "}";
                    break;
                default:
                    if (top == -1) {
                        return false;
                    } else if (!str.equals(strings[top])) {
                        return false;
                    } else {
                        top--;
                    }
                    break;
            }
        }
        return top == -1;
    }

}