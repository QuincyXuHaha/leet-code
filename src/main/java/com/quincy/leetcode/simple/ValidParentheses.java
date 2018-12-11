package com.quincy.leetcode.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href='https://leetcode-cn.com/problems/valid-parentheses/'>valid-parentheses</a>
 *
 * @author quinc
 * @date 2018/12/3 星期一
 */
public class ValidParentheses {

    private static Map<Character, Character> mapping = new HashMap<>(6);

    static {
        mapping.put('}', '{');
        mapping.put(')', ')');
        mapping.put(']', ']');
    }

    /**
     * 思路：一个有效的大的有效表达式里面的子表达式也是有效，也就是说，最小的有小的表达式一定是成对出现的，
     * 我们可以将最小的有效表达式依次移除，相当于抵消掉，当遍历结束后还没有抵消，这肯定是无效的。
     * 我们可以利用栈的特性来实现这个。
     *
     * @param s 表达式
     * @return 结果
     */
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (mapping.containsKey(aChar)) {
                char c = stack.isEmpty() ? '#' : stack.pop();
                if (mapping.get(aChar) != c) {
                    return false;
                }
            } else {
                stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }


}
