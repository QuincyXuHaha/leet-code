package com.quincy.leetcode.easy.array;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * <a href='https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/'></a>
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author quinc
 * @date 2018/12/26 星期三
 */
public class SingleNumber {

    /**
     * 思路1：用hashMap
     * 思路2：异或的思想：2个相同的数字异或肯定为0
     *
     * @param nums 原数据
     * @return 结果
     */
    public static int singleNumber(int[] nums) {
        // 思路1
//        int[] ret = new int[1];
//        Map<Integer, Integer> map = new HashMap<>(nums.length);
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                map.put(num, map.get(num) + 1);
//            } else {
//                map.put(num, 1);
//            }
//        }
//        map.forEach((k, v) -> {
//            if (v == 1) {
//                ret[0] = k;
//            }
//        });
//        return ret[0];
        // 思路2
        OptionalInt ret = Arrays.stream(nums).reduce((acc, it) -> {
            acc ^= it;
            return acc;
        });
        return ret.orElse(0);

    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

}
