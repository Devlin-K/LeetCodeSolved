package org.dkwork.leetcodesolved.questSolved;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jin
 * @date 2020/12/1
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProject javatemplate
 * @BelongPackage org.dkwork.leetcodesolved.questSolved
 * @Describe: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class PalindromeNumberQuest {
    public boolean isPalindrome(int x) {
        if (x >= 10) {
            List<Integer> arrayList = new ArrayList<>();
            int y = x;
            while (y > 0) {
                int i = y % 10;
                y = y / 10;
                arrayList.add(i);
            }
            double reverse=0;
            for (int i = 0; i < arrayList.size(); i++) {
                double r=Math.pow(10,(arrayList.size()-i));
                reverse+=arrayList.get(i)*r;
            }
            return reverse/10==x;
        } else return x >= 0;
    }
}
