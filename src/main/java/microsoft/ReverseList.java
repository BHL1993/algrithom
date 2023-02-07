package microsoft;

import listnode.ListNode;

import java.util.List;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/1/28 10:26 下午
 */
public class ReverseList {
    public ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;

        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }

        return pre;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
