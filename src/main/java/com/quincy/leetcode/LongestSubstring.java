package com.quincy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href='https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/'>
 * longest-substring-without-repeating-characters
 * </a>
 * 思路：从第一个字符开始遍历，计算其后面的连续不同字符
 *
 * @author quinc
 * @date 2018/11/14 星期三
 */
public class LongestSubstring {


    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        // 最大子串长度
        int max = 0;
        // 遍历字符串
        for (int i = 0; i < length; i++) {
            // 检查下一个字符是否在前面子串中
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            for (int j = i + 1; j < length; j++) {
                // 不存在子串中
                char next = s.charAt(j);
                if (sb.indexOf(String.valueOf(next)) == -1) {
                    sb.append(next);
                } else {
                    break;
                }
            }
            max = Math.max(max, sb.length());
        }
        return max;
    }

    /**
     * 优化滑动窗口：
     * 当j+1存在[i,j]当中时，不需要重i+1开始判断;
     * 假设是未知k与j+1的字符相同，则下一次只需要从k+1开始判断即可，且可以从j+1那里开始判重。
     *
     * @param s 字符串
     * @return 最初子串长度
     */
    public static int lengthOfLongestSubstring2(String s) {
        int length = s.length();
        int max = 0;
        // key为字符，value为当前字符的下一个的位置
        // 如果是ASCII的话可以直接用数组int[128]数组代替
        Map<Character, Integer> map = new HashMap<Character, Integer>(128);
        for (int i = 0, j = 0; j < length; j++) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                i = Math.max(map.get(ch), i);
            }
            max = Math.max(max, j - i + 1);
            map.put(ch, j + 1);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("bbbbbbb"));
        System.out.println(lengthOfLongestSubstring("au"));
    }
}
