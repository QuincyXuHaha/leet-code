package com.quincy.leetcode;

/**
 * <a href='https://leetcode-cn.com/problems/remove-k-digits/'>Remove K Digits</a>
 * <p>
 * k算法：对给定的数字，删除k个数字，保证删除后的数最小
 * 思路：对于一个数字来说，位数比大小重要，即数字从高位到低位应该是一个相邻从小到大排列的。
 * 所以比较高位和次高位数字大小，如果次高位大于高位，则删除。
 * 比如数字26485950，删除1位的话比较流程为：2<6，不动；6>4,删除。结果为2485950
 *
 * @author quinc
 * @date 2018/11/12 星期一
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class KAlgorithm {

    public String removeKDigits(String num, int k) {
        if (k == 0) {
            return num;
        }
        if (k == num.length()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        int indexOfZero = sb.indexOf("0");
        //remove all the numbers before "0" when indexOfZero<=k
        char zero = '0';
        while (indexOfZero != -1 && indexOfZero <= k) {
            k -= indexOfZero;
            sb.delete(0, indexOfZero + 1);
            //remove leading zero
            while (sb.length() > 0 && sb.charAt(0) == zero) {
                sb.deleteCharAt(0);
            }
            indexOfZero = sb.indexOf("0");
        }
        while (k > 0) {
            int len = sb.length(), i = 0;
            while (i + 1 < len && sb.charAt(i) <= sb.charAt(i + 1)) {
                i += 1;
            }
            sb.deleteCharAt(i);
            k--;
        }
        while (sb.length() > 0 && sb.charAt(0) == zero) {
            sb.deleteCharAt(0);
        }
        num = sb.toString();
        return "".equals(num) ? "0" : num;
    }

    public static void main(String[] args) {
        KAlgorithm k = new KAlgorithm();
        System.out.println(k.removeKDigits("10", 1));
    }

}
