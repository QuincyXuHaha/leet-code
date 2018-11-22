package com.quincy.leetcode;

/**
 * <a href='https://leetcode-cn.com/problems/binary-subarrays-with-sum/'>Binary SubArrays With Sum</a>
 *
 * @author quinc
 * @date 2018/11/16 星期五
 */
public class SubArrays {

    /**
     * 在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。
     * 思路:   当sum=0时，遍历数组，从第一个0开始，然后加上后面有几个0，这样一直累加。
     * 当sum>0时，遍历数组，从第一个1开始，计算出第sum个1的位置，然后加上后面有几个0，这样一直累加。
     * 不需要考虑数组是一样的，你可以认为包含index
     *
     * @param A 数组
     * @param S 和
     * @return 子数组个数
     */
    public static int numSubArraysWithSum(int[] A, int S) {

        //todo
        int i = 0, j = 0, num = 0, curSum = 0;
        int len = A.length;
        while (i < len) {
            curSum += A[j];
            if (curSum == S) {
                num++;
            }
            j++;
            if (j == len) {
                j = ++i;
                curSum = 0;
            }
        }
        return num;
    }

    public static int numSubArraysWithSum2(int[] A, int S) {
        int psum = 0, res = 0, count[] = new int[A.length + 1];
        count[0] = 1;
        for (int i : A) {
            psum += i;
             if (psum >= S) {
                res += count[psum - S];
            }
            count[psum]++;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(numSubArraysWithSum2(new int[]{0, 0, 0, 0}, 0));
        System.out.println(numSubArraysWithSum2(new int[]{1, 0, 1, 0, 1}, 2));
    }

}
