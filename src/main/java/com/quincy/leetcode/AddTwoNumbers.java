package com.quincy.leetcode;

/**
 * <a href='https://leetcode-cn.com/problems/add-two-numbers/'>Add Two Numbers</a>
 * <p>
 * 思路：1、长度不一致；
 * 2、进位，比如2+9 = 11，此时位的值应为1，然后下一个值多加一个1。
 *
 * @author quinc
 * @date 2018/11/13 星期二
 */
public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1, q = l2, cur = result;
        // 进位
        int carry = 0;
        while (p != null || q != null) {
            int x = (p == null) ? 0 : p.val;
            int y = (q == null) ? 0 : q.val;
            // 相加
            int sum = x + y + carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
            p = (p == null) ? null : p.next;
            q = (q == null) ? null : q.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return result.next;
    }


    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode listNode = addTwoNumbers(l1, null);
        System.out.println();
    }


}



