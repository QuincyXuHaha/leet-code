package com.quincy.leetcode;

/**
 * <a href='https://leetcode-cn.com/problems/two-sum/'>Remove Duplicates from sorted array</a>
 *
 * @author quinc
 * @date 2018/11/12 星期一
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] twoSum = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    twoSum[0] = i;
                    twoSum[1] = j;
                    System.out.println(twoSum[0] + ", " + twoSum[1]);
                }
            }
        }

        return twoSum;
    }

    public static void main(String[] args) {
        int[] nums = {-3,4,3,90};
        twoSum(nums, 0);
    }

}
