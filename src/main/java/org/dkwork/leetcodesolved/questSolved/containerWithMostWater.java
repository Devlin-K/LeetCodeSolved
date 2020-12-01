package org.dkwork.leetcodesolved.questSolved;

/**
 * @author jin
 * @date 2020/12/1
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProject javatemplate
 * @BelongPackage org.dkwork.leetcodesolved.questSolved
 * @Describe: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 */
public class containerWithMostWater {
    public int maxArea(int[] height) {
        int count = 0;
        for (int i = 1; i <= height.length; i++) {
            for (int j = i + 1; j <= height.length; j++) {
                count=Math.max(count,(j-i)*(Math.min(height[i - 1], height[j - 1])));
            }
        }
        return count;
    }
}
