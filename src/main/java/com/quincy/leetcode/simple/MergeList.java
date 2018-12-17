package com.quincy.leetcode.simple;

/**
 * <a href='https://leetcode-cn.com/problems/merge-two-sorted-lists/'>merge-two-sorted-lists</a>
 *
 * @author quinc
 * @date 2018/12/3 星期一
 */
public class MergeList {

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode ret = new ListNode(0);
        //double pointer
        ListNode p = l1, q = l2, cur = ret;
        while (p != null || q != null) {
            if (p == null) {
                // 此时q肯定不为null
                cur.next = new ListNode(q.val);
                q = q.next;
                cur = cur.next;
            } else if (q == null) {
                // 此时p肯定不为null
                cur.next = new ListNode(p.val);
                p = p.next;
                cur = cur.next;
            } else {
                // 2个均不为null
                if (p.val < q.val) {
                    cur.next = new ListNode(p.val);
                    p = p.next;
                    cur = cur.next;
                } else {
                    cur.next = new ListNode(q.val);
                    q = q.next;
                    cur = cur.next;
                }
            }

        }
        return ret.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println();
    }

}
