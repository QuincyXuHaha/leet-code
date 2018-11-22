package com.quincy.leetcode;

/**
 * <a href='https://leetcode-cn.com/problems/reverse-integer/'>reverse-integer</a>
 *
 * @author quinc
 * @date 2018/11/21 星期三
 */
public class IntegerReverse {

    private static final int INT_BITS = 32;


    public static int reverse(int x) {
        // 数字反转溢出是会报错
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        //反转
        sb.reverse();
        String res = sb.toString();
        if (res.contains("-")) {
            //有负号
            sb.replace(sb.length() - 1, sb.length(), "");
            sb.insert(0, '-');
            return Integer.valueOf(sb.toString());
        }
        return Integer.valueOf(sb.toString());
    }


    public static int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            // 若数字溢出了newResult则不会是预期的值，即上述的表达式不能转化为下面的
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse2(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(-120));
        System.out.println(reverse2(1534236469));
    }

}
