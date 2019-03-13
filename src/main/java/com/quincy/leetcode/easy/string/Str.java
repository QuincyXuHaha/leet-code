package com.quincy.leetcode.easy.string;

/**
 * @author quinc
 * @date 2019/1/10 星期四
 */
public class Str {
    /**
     * <a href = 'https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/32/'></a>
     * * 编写一个函数，其作用是将输入的字符串反转过来。
     * * <p>
     * * 示例 1:
     * * <p>
     * * 输入: "hello"
     * * 输出: "olleh"
     * * 示例 2:
     * * <p>
     * * 输入: "A man, a plan, a canal: Panama"
     * * 输出: "amanaP :lanac a ,nalp a ,nam A"
     * *
     *
     * @param s
     * @return
     */
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

    /**
     * <a href='https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/35/'></a>
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     * <p>
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     * 对于这种通用解法可以用hashmap解决，key为字符，value为出现的次数，然后对比2个map就可以了
     *
     * @param s source
     * @param t target
     * @return match result
     */
    public static boolean isAnagram(String s, String t) {
        int[] sStatistics = new int[26];
        int[] tStatistics = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (char c : sChars) {
            sStatistics[c - 'a'] += 1;
        }
        for (char c : tChars) {
            tStatistics[c - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (sStatistics[i] != tStatistics[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * <a href='https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/36/'></a>
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * <p>
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "race a car"
     * 输出: false
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char ch = s.charAt(i);
            char ch1 = s.charAt(j);
            if (!Character.isLetterOrDigit(ch)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(ch1)) {
                j--;
                continue;
            }
            if (ch != ch1) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * <a href='https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/37/'></a>
     * <p>
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * <p>
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * <p>
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * <p>
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     * <p>
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     * <p>
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     * <p>
     * 说明：
     * <p>
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "42"
     * 输出: 42
     * 示例 2:
     * <p>
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * 示例 3:
     * <p>
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * 示例 4:
     * <p>
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     * 因此无法执行有效的转换。
     * 示例 5:
     * <p>
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     * 因此返回 INT_MIN (−231) 。
     * <p>
     * 思路：无非就是按照正常思维来
     * 1、字符串判空，去掉前面的空格
     * 2、看看第一个字符是数字还是正负号，然后得到第一个数字的下标
     * 3、数字字符转换为数字，要注意溢出的情况
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
//        if (str == null || "".equals(str)) {
//            return 0;
//        }
//
//        int start = 0;
//        int len = str.length();
//        // 先去除前面的空格
//        while (start < len) {
//            if (str.charAt(start) != ' ') {
//                break;
//            }
//            start++;
//        }
//        boolean isPositive = true;
//        // 判断第一个字符串是啥
//        if (str.charAt(start) == '-') {
//            start++;
//            isPositive = false;
//        } else if (str.charAt(start) == '+') {
//            start++;
//        } else if (str.charAt(start) > '9' || str.charAt(start) < '0') {
//            return 0;
//        }
//
//        // 抽取出正确的字符串数字
//        int end = start;
//        while (end < len) {
//            if (str.charAt(end) > '9' || str.charAt(end) < '0') {
//                break;
//            }
//            end++;
//        }
//        int ret = Integer.parseInt(str.substring(start, end));// 会溢出，见下面的方法
//        if (!isPositive && ret == Integer.MAX_VALUE) {
//            return 0;
//        }
//        return isPositive ? ret : -ret;

//        int index = 0, sign = 1, total = 0;
//        //1. Empty string
//        if (str == null || str.length() == 0) {
//            return 0;
//        }
//
//        //2. Remove Spaces
//        while (index < str.length() && str.charAt(index) == ' ') {
//            index++;
//        }
//
//        //3. Handle signs
//        if (index < str.length() && str.charAt(index) == '+' || str.charAt(index) == '-') {
//            sign = str.charAt(index) == '+' ? 1 : -1;
//            index++;
//        }
//
//        //4. Convert number and avoid overflow
//        while (index < str.length()) {
//            int digit = str.charAt(index) - '0';
//            if (digit < 0 || digit > 9) {
//                break;
//            }
//
//            //check if total will be overflow after 10 times and add digit
//            if (Integer.MAX_VALUE / 10 <= total && Integer.MAX_VALUE % 10 < digit) {
//                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//            }
//            total = 10 * total + digit;
//            index++;
//        }
//        return total * sign;
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        if ("".equals(str)) {
            return 0;
        }
        char firstChar = str.charAt(0);
        int sign = 1, start = 0, len = str.length();
        long sum = 0;
        if (firstChar == '+') {
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) sum * sign;
            }
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) sum * sign;
    }


    /**
     * <a href='https://leetcode-cn.com/problems/implement-strstr/'></a>
     * <p>
     * 实现 strStr() 函数。
     * <p>
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     * <p>
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * <p>
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     * <p>
     * todo ：参照KMP字符串匹配算法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     * <p>
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     * <p>
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
     * <p>
     * 注意：整数顺序将表示为一个字符串。
     * 示例 1:
     * <p>
     * 输入: 1
     * 输出: "1"
     * 示例 2:
     * <p>
     * 输入: 4
     * 输出: "1211"
     * <p>
     * 思路：其实就是将一个字符串按照相同数字分成各个子串，然后按照顺序拼接nv，n表示子串长度，v表示数字的值
     * //todo
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {

        int count = 1;
        String ret = "1";
        while (count <= n) {


        }
        return null;

    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * <p>
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * <p>
     * 所有输入只包含小写字母 a-z 。
     * <p>
     * 思路：以第一个字符串为参照，调用startWith()方法，不存在则截取0-length-1的字符串，依次比较
     *
     * @param strs
     * @return
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
//        isAnagram("a", "b");
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(isPalindrome("race a car"));
//        System.out.println(myAtoi("  42"));
//        System.out.println(myAtoi(" -42"));
//        System.out.println(myAtoi(" words and 987"));
//        System.out.println(myAtoi(" 4193 with words"));
//        System.out.println(myAtoi(" -91283472332"));
//
//        String idCard = "362502199411106817";
//
//        String year = idCard.substring(8, 9);
//        System.out.println(year + "0后");
        int x = 1,y=2,z=3;
        System.out.println(y+=z--/++x);

    }

}
