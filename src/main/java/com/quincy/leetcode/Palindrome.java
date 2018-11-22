package com.quincy.leetcode;

/**
 * <a href='https://leetcode-cn.com/problems/palindrome-number/'>palindrome-number</a>
 * <p>
 * 回文数
 *
 * @author quinc
 * @date 2018/11/22 星期四
 */
public class Palindrome {


    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int res = 0;
        int original = x;
        while (x != 0) {
            int tail = x % 10;
            int temp = res * 10 + tail;
            if ((temp - tail) / 10 != res) {
                return false;
            }
            res = temp;
            x = x / 10;
        }
        return res == original;
    }

    /**
     * 优化思路：其实只需要拿到一半的数字，然后比较即可；
     * 什么时候拿到呢，就是正序/10<倒序*10的时候就拿到了.
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {

        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(120));
    }
}
