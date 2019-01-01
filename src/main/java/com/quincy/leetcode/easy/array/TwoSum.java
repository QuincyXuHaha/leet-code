package com.quincy.leetcode.easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href='https://leetcode-cn.com/problems/two-sum/'>Remove Duplicates from sorted array</a>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author quinc
 * @date 2018/11/12 星期一
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
//        int[] twoSum = new int[2];
////        for (int i = 0; i < nums.length - 1; i++) {
////            for (int j = i + 1; j < nums.length; j++) {
////                if (nums[i] + nums[j] == target) {
////                    twoSum[0] = i;
////                    twoSum[1] = j;
////                    System.out.println(twoSum[0] + ", " + twoSum[1]);
////                }
////            }
////        }
////
////        return twoSum;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    public static void main(String[] args) {
        int[] nums = {-3, 4, 3, 90};
        twoSum(nums, 0);
    }

}
