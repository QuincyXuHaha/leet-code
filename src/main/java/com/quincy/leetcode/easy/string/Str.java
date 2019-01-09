package com.quincy.leetcode.easy.string;

/**
 * <a href = 'https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/32/'></a>
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 *
 * @author quinc
 * @date 2019/1/10 星期四
 */
public class Str {

    public static String reverseString(String s) {
        char[] ch = new char[s.length()];
        int idx = s.length() - 1;
        for (char c : s.toCharArray()) {
            ch[idx--] = c;
        }
        return new String(ch);
    }

    /**
     * <a href = 'https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/33/'></a>
     * <p>
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     * 示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * @param x 整数
     * @return 结果
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * <a href = 'https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/34/'></a>
     * <p>
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * <p>
     * 案例:
     * <p>
     * s = "leetcode"
     * 返回 0.
     * <p>
     * s = "loveleetcode",
     * 返回 2.
     * <p>
     * 注意事项：您可以假定该字符串只包含小写字母。
     *
     * @param s 字符
     * @return 结果
     */
    public static int firstUniqChar(String s) {
        // 思路：只包含小写字母，那么可以用小写字母作为数组下标(97-122)，值为出现的次数;优化空间每个字符减去a
        // 或者使用hashMap
//        int[] count = new int[128];
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a'] += 1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
