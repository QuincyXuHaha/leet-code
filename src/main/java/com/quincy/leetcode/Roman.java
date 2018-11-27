package com.quincy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href='https://leetcode-cn.com/problems/roman-to-integer/'>roman-to-integer</a>
 * <p>
 * 思路：正常的是大的排在前面，小的排在后面，然后出去不正常的就可以了
 *
 * @author quinc
 * @date 2018/11/23 星期五
 */
public class Roman {

    private static Map<Character, Integer> map = new HashMap<>(16);

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            // 正常顺序
            Integer cur = map.get(chars[i]);
            if (cur >= map.get(chars[i + 1])) {
                res += cur;
            } else {
                res -= cur;
            }
        }
        return res + map.get(chars[chars.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
