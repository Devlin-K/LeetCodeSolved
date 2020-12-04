package org.dkwork.leetcodesolved.questSolved;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jin
 * @date 2020/12/3
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProject LeetCodeSolved
 * @BelongPackage org.dkwork.leetcodesolved.questSolved
 * @Describe: 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
public class RomanToIntQuest {

    private static final Map<String, Integer> map = new HashMap<>();

    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }

    private static Integer convertR2I(String romanNum) {
        return map.get(romanNum);
    }

    public static int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 <= s.length()) {
                int front = convertR2I(s.substring(i, i + 1));
                int back = convertR2I(s.substring(i + 1, i + 2));
                if (front < back) {
                    sum += -front;
                } else {
                    sum += front;
                }
            } else {
                sum += convertR2I(s.charAt(i));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
/** 程序运行 processRun();*/
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToIntV2("MCMXCIV"));
/** 获取当前的系统时间，与初始时间相减就是程序运行的毫秒数，除以1000就是秒数*/
        long endTime = System.currentTimeMillis();
        long usedTime = (endTime - startTime) / 10000;
        System.out.println(usedTime);
    }

    private static Integer convertR2I(char romanNum) {
        switch (romanNum) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case 'a':
                return 4;
            case 'b':
                return 9;
            case 'c':
                return 40;
            case 'd':
                return 90;
            case 'e':
                return 400;
            case 'f':
                return 900;
            default:
                return 0;
        }
    }

    public static int romanToIntV2(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");

        int result = 0;
        for (int i=0; i<s.length(); i++) {
            result += convertR2I(s.charAt(i));
        }
        return result;
    }
}

