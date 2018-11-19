package com.quincy.leetcode;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <a href='https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/'>Minimum Index Sum of Two Lists</a>
 *
 * @author quinc
 * @date 2018/11/19 星期一
 */
public class MinIndex {

    public static String[] findRestaurant(String[] list1, String[] list2) {
        // 时间复杂度O(n*m)
//        int minIndex = list1.length +list2.length;
//        List<String> res = new LinkedList<>();
//        for (int i = 0; i < list1.length; i++) {
//            for (int j = 0; j < list2.length; j++) {
//                if (list1[i].equals(list2[j]) && minIndex >= i + j) {
//                    minIndex = i + j;
//                    res.add(list1[i]);
//                    break;
//                }
//            }
//        }
//        return res.toArray(new String[res.size()]);
        // 优化，利用hashMap查询时O(1)的复杂度
        int minIndex = 2000;
        List<String> res = new LinkedList<>();
        // k为值，v为索引
        Map<String, Integer> map = new HashMap<>(list1.length);
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            Integer idx = map.get(list2[i]);
            if (idx != null && minIndex >= idx + i) {
                if (minIndex > idx + i) {
                    res.clear();
                    minIndex = idx + i;
                }
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {

        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println(findRestaurant(list1, list2));
        System.out.println(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"}));
    }

}
