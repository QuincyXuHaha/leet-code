package com.quincy.leetcode.easy.array;

/**
 * <a href='https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/28/'>merge-two-sorted-lists</a>
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author quinc
 * @date 2019/1/1 星期二
 */
public class MoveZero {

    /**
     * 思路：双指针
     *
     * @param nums 数组
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // i为遍历下标，j为移动后的下一个非零数位置
//        int i = 0, j = 0, count = 0;
//        while (i < nums.length) {
//            if (nums[i] != 0) {
//                nums[j++] = nums[i];
//            } else {
//                count++;
//            }
//            i++;
//        }
//        // 得到非零数字的顺序的数组和数组包含0的个数，下面倒序填充0就可以了
//        if (count > 0) {
//            for (int k = nums.length - 1; k >= 0; k--) {
//                nums[k] = 0;
//                if (--count == 0) {
//                    break;
//                }
//            }
//        }
        //2,i为遍历下标，j为遍历时最近交换时非零的位置
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
        System.out.println(new int[]{});
    }

}
