package microsoft;

import listnode.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/9 8:47 下午
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tmp = dummyHead;

        int ta = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + ta;
            int val = sum % 10;
            ta = sum / 10;

            tmp.next = new ListNode(val);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            while (l2 != null) {
                int sum = l2.val + ta;
                int val = sum % 10;
                ta = sum / 10;

                tmp.next = new ListNode(val);
                tmp = tmp.next;

                l2 = l2.next;
            }
        } else {
            while (l1 != null) {
                int sum = l1.val + ta;
                int val = sum % 10;
                ta = sum / 10;

                tmp.next = new ListNode(val);
                tmp = tmp.next;

                l1 = l1.next;
            }
        }

        if (ta == 1) {
            tmp.next = new ListNode(1);
        }

        return dummyHead.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tmp = dummyHead;

        int ta = 0;
        while (l1 != null || l2 != null) {
            int x1 = l1 == null ? 0 : l1.val;
            int x2 = l2 == null ? 0 : l2.val;
            int sum = x1 + x2 + ta;

            int val = sum % 10;
            ta = sum / 10;

            tmp.next = new ListNode(val);
            tmp = tmp.next;
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (ta == 1) {
            tmp.next = new ListNode(1);
        }
        return dummyHead.next;
    }
}
