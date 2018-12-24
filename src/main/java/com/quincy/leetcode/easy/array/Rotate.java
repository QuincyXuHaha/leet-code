package com.quincy.leetcode.easy.array;

import java.util.StringJoiner;

/**
 * <a href='https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/'></a>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 *
 * @author quinc
 * @date 2018/12/24 星期一
 */
public class Rotate {

    /**
     * 思路1：一步步移动每一个数字。
     * 思路2：观察可以发现，其实移动k步就是以下标length-k-1的位置为轴（该轴包含在左边的子数组中）进行拆分2个子数组，然后交换位置即为新的数组
     * 这里代码可以利用反转的思想----先进行整体的反转，这时候2个子数组都是反序的，所以接下来分别对2个子数组反转即可
     *
     * @param nums 数组
     * @param k    移动步数
     */
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        k %= nums.length;
        // 思路1
//        for (int i = 0; i < k; i++) {
//            int next = nums[0];
//            for (int j = 0; j < nums.length; j++) {
//                int index = (j + 1) % nums.length;
//                int temp = next;
//                next = nums[index];
//                nums[index] = temp;
//            }
//        }
        // 思路2
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void print(int[] nums, int k) {
        rotate(nums, k);
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (int x : nums) {
            sj.add(Integer.toString(x));
        }
        System.out.println(sj.toString());
    }


    public static void main(String[] args) {
        print(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        print(new int[]{-1, -100, 3, 99}, 2);
        print(new int[]{1, 2, 3, 4, 5, 6}, 2);
    }
}
