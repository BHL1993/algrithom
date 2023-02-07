package microsoft;

import listnode.ListNode;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/1/17 1:46 下午
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode ahead = head;

        while (n > 0) {
            ahead = ahead.next;
            n--;
        }

        if (ahead == null) {
            return head.next;
        }

        while (ahead != null) {
            ahead = ahead.next;
            pre = cur;
            cur = cur.next;
        }

        pre.next = cur.next;
        return head;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(new RemoveNthFromEnd().removeNthFromEnd(head, 2));
    }
}
