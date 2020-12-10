package org.dkwork.leetcodesolved.questSolved;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jin
 * @date 2020/12/8
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProject LeetCodeSolved
 * @BelongPackage org.dkwork.leetcodesolved.questSolved
 * @Describe: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png" style="height: 161px; width: 412px;" />
 */
public class TrapRain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(sumTrapRain(Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray()));
    }

    private static Integer sumTrapRain(int[] height) {
        if (0 == height.length) return 0;
        List<Integer> list = Arrays.stream(height).boxed().collect(Collectors.toList());
        int max = Collections.max(list);
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == max) {
                list1.add(i);
            }
        }
        int sumTrap = 0;
        int leftBlock = list.get(0);
        int rightBlock = list.get(list.size() - 1);
        for (int i = 0; i < list1.get(0); i++) {
            if (leftBlock < list.get(i)) {
                leftBlock = list.get(i);
            } else {
                sumTrap += leftBlock - list.get(i);
            }
        }
        for (int i = list.size() - 1; i > list1.get(list1.size() - 1); i--) {
            if (rightBlock < list.get(i)) {
                rightBlock = list.get(i);
            } else {
                sumTrap += rightBlock - list.get(i);
            }
        }

        if (list1.size() > 1) {
            int sum = 0;
            for (int i =list1.get(0)+1; i < list1.get(list1.size()-1); i++) {
                sum += list.get(i);
            }
            sumTrap += (list1.get(list1.size() - 1) - list1.get(0) - 1) * max - sum;
        }
        return sumTrap;
    }
}
