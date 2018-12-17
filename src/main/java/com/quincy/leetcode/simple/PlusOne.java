package com.quincy.leetcode.simple;

/**
 * <a href='https://leetcode-cn.com/problems/plus-one/'>merge-two-sorted-lists</a>
 * 注意进位
 *
 * @author quinc
 * @date 2018/12/18 星期二
 */
public class PlusOne {

    /**
     * 代码优化思路：
     *  先考虑大部分情况，就是不是9999这样的数字，这样的话原数组就可以满足；
     *  注意：对于基本类型的数组，在创建时会初始化，int[]则全部会初始化为0，因此对于9999的情况计算起来就很简单，也不需要进行copy。
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {

        int inx = digits.length - 1;

        // 进位
        int carry = 0;
        while (inx < digits.length && inx >= 0) {
            int curV = digits[inx] + 1;
            digits[inx] = curV % 10;
            carry = curV / 10;
            // 表示此次不会进位
            if (carry == 0) {
                break;
            }
            inx--;
        }
        while (inx > 0) {
            digits[inx] = digits[inx];
            inx--;
        }
        if (carry == 1) {
            int[] ret = new int[digits.length + 1];
            ret[0] = carry;
            return ret;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] ints = plusOne(new int[]{9, 9, 9, 9});
        int[] ints1 = plusOne(new int[]{9, 9, 9, 0});
        int[] ints2 = plusOne(new int[]{9, 9, 0, 9});
        int[] ints3 = plusOne(new int[]{1, 9});
        System.out.println();
    }

}
