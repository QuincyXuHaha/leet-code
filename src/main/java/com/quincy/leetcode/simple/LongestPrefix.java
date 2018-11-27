package com.quincy.leetcode.simple;

/**
 * <a href='https://leetcode-cn.com/problems/longest-common-prefix/'>roman-to-integer</a>
 *
 * @author quinc
 * @date 2018/11/27 星期二
 */
public class LongestPrefix {

    /**
     * 查询数组中最长的公共前缀子串
     * 思路：以第一个字符串为基准和第二个字符串比较获得公共子串，然后以这个公共子串和第三个比较或者公共子串...
     * 依次类推直到没有公共子串或者最后一个字符串比较完毕为止。
     *
     * @param strs 数组
     * @return 结果
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // 第i个字符串不以res开头，则修改res，直至以其开头或者res为空
            while (!strs[i].startsWith(res)) {
                res = res.substring(0, res.length() - 1);
                if (res.length() == 0) {
                    return "";
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aa", "b"}));
        System.out.println(longestCommonPrefix(new String[]{"aa", "a"}));
        System.out.println(longestCommonPrefix(new String[]{"a", "aa"}));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{}));
        System.out.println(longestCommonPrefix(new String[]{"dsds"}));
    }
}
