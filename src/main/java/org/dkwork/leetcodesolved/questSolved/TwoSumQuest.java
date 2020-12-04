package org.dkwork.leetcodesolved.questSolved;

/**
 * @author jin
 * @date 2020/12/1
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProject javatemplate
 * @BelongPackage org.dkwork.leetcodesolved.questSolved
 * @Describe: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class TwoSumQuest {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0 ;i<nums.length-1;i++){
            for(int j=i+1 ;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
