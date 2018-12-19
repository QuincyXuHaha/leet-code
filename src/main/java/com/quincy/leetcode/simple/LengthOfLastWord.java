package com.quincy.leetcode.simple;

/**
 * <a href='https://leetcode-cn.com/problems/length-of-last-word/'>length-of-last-word</a>
 * <p>
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 *
 * @author quinc
 * @date 2018/12/19 星期三
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        String trim = s.trim();
        if ("".equals(trim)) {
            return 0;
        }
        int idx = trim.length() - 1;
        int count = 0;
        while (idx >= 0) {
            if (' ' == trim.charAt(idx--)) {
                return count;
            }
            count++;
        }
        return count;
        // 充分利用api。。。
//        s = s.trim();
//
//        // Creates a substring from the last space to the end of the word and finds length
//        if (s.lastIndexOf(" ") != -1)
//            return (s.substring(s.lastIndexOf(" ")+1)).length();
//
//        return s.length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("Hello World "));
        System.out.println(lengthOfLastWord(" dsdae"));
    }

}
