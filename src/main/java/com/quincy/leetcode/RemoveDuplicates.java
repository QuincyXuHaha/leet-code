package com.quincy.leetcode;

/**
 * <a href='https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/'>Remove Duplicates from sorted array</a>
 * <p>
 * 删除重复排序数组的重复数字，保证空间复杂度为O(1)
 *
 * @author quinc
 * @date 2018/11/12 星期一
 */
public class RemoveDuplicates {

    /**
     * Remove Duplicates from sorted array
     * 思路：这是一个排序数组，所以肯定是相同的数字是连续的
     *  在遍历过程中只需要记录当前遍历的位置以及最新的存放的位置
     *
     * @param nums sorted array
     * @return new array size
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }

}
