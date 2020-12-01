package org.dkwork.leetcodesolved.questSolved;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jin
 * @date 2020/12/1
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProject javatemplate
 * @BelongPackage org.dkwork.leetcodesolved.questSolved
 * @Describe: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class longestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        List<String> strList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (strList.size() != 0 && strList.contains(s.substring(i, i + 1))) {
                count = Math.max(count, strList.size());
                strList=strList.subList(strList.indexOf(s.substring(i, i + 1))+1,strList.size());
                strList.add(s.substring(i, i + 1));
            }else{
                strList.add(s.substring(i, i + 1));
                count= Math.max(count, strList.size());
            }
        }
        return count;
    }
}
