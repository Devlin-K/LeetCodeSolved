package org.dkwork.leetcodesolved.questSolved;

import java.util.*;

/**
 * @author jin
 * @date 2020/12/22
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProject LeetCodeSolved
 * @BelongPackage org.dkwork.leetcodesolved.questSolved
 * @Describe: 基本计算器 v1,v2,v3
 */
public class CalculateQuest {
    public static int calculate(String s) {
        int point = 0;
        int top = 0;
        List<Integer> nums = new ArrayList<>(s.length() / 2 + 1);
        int[] symbols = new int[s.length() / 2 + 1];
        for (int i = 0; i < s.length(); i++) {
            switch (s.substring(i, i + 1)) {
                case " ":
                    point++;
                    break;
                case "+":
                    if (point < i) {
                        nums.add(checkNum(symbols, Integer.parseInt(s.substring(point, i))));
                    }
                    symbols[top] = 0;
                    point = i + 1;
                    break;
                case "-":
                    if (point < i) {
                        nums.add(checkNum(symbols, Integer.parseInt(s.substring(point, i))));
                    }
                    symbols[top] = -1;
                    point = i + 1;
                    break;
                case "(":
                    symbols[++top] = 0;
                    point = i + 1;
                    break;
                case ")":
                    if (point < i) {
                        nums.add(checkNum(symbols, Integer.parseInt(s.substring(point, i))));
                    }
                    symbols[top] = 0;
                    --top;
                    point = i + 1;
                    break;
                default:
                    break;
            }
        }
        if (point == 0) {
            return Integer.parseInt(s);
        }
        if (point != s.length()) {
            return nums.stream().mapToInt(Integer::intValue).sum() + Integer.parseInt(s.substring(point - 1, s.length()));
        } else {
            return nums.stream().mapToInt(Integer::intValue).sum();
        }
    }

    private static int checkNum(int[] symbols, int num) {
        int result = 0;
        for (int symbol : symbols) {
            result += symbol;
        }
        if (result % 2 == 0) {
            return num;
        } else {
            return Integer.parseInt("-" + num);
        }
    }

    public static void main(String[] args) {
        System.out.println("Start: " + System.currentTimeMillis());
        System.out.println(calculate(new Scanner(System.in).nextLine()));
        System.out.println("End: " + System.currentTimeMillis());

    }

    public Integer calculateVersion2(String s) {
        Queue<Object> s1 = new LinkedList<Object>();
        for (int i = 0; i < s.length(); i++) {
            s1.offer(s.charAt(i));
        }
        return helper(s1);

    }

    public int helper(Queue<Object> s) {
        Stack<Integer> number = new Stack<>();
        char c;
        int n = 0;
        char sign = '+';
        while (!s.isEmpty()) {
            c = (char) s.poll();
            if (Character.isDigit(c)) {
                n = 10 * n + c - '0';
            }
            if (c == '(') {

                n = helper(s);
            }
            if ((!Character.isDigit(c) && c != ' ') || s.isEmpty()) {
                int pre;
                switch (sign) {
                    case '+':
                        number.push(n);
                        break;
                    case '-':
                        number.push(-n);
                        break;
                    case '*':
                        pre = number.pop();
                        pre = pre * n;
                        number.push(pre);
                        break;
                    case '/':
                        pre = number.pop();
                        number.push(pre / n);
                        break;
                    default:
                        break;

                }
                sign = c;
                n = 0;
            }
            if (c == ')')
                return sum(number);
        }
        return sum(number);

    }

    private int sum(Stack number) {
        int res = 0;
        while (!number.isEmpty()) {
            res += (int) number.pop();
        }
        return res;
    }
}
