package org.dkwork.leetcodesolved.questSolved;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jin
 * @date 2020/12/1
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProject javatemplate
 * @BelongPackage org.dkwork.leetcodesolved.questSolved
 * @Describe:
 */
public class SingleNumberQuest {
    private static final Logger log = LoggerFactory.getLogger(SingleNumberQuest.class);

    public static void main(String[] args) {
        System.out.println(getNum(new int[]{1,2,3,4,1,2,3}));

    }

    public static int getNum(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        log.info("info");
        log.warn("warn");
        log.error("error");
        return ans;
    }
}
