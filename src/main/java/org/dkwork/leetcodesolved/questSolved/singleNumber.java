package org.dkwork.leetcodesolved.questSolved;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jin
 * @date 2020/12/1
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProject javatemplate
 * @BelongPackage org.dkwork.leetcodesolved.questSolved
 * @Describe:
 */
public class singleNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(getNumv2(new int[]{1,2,3,3,2,1,4}));

    }

    public static String getNum(String[] nums) {
        List<String> list = Stream.of(nums).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            if (!list.subList(i+1,list.size()).contains(list.get(i))){
                return list.get(i);
            }
        }
        return null;
    }
    public static int getNumv2(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}
