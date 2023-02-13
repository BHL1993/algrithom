package microsoft;

import listnode.ListNode;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/2/13 9:14 上午
 */
public class ReverseList1 {
    /**
     * reverse 方法返回翻转后的链表的头节点
     * 使用递归思想，首先翻转head.next为头结点的链表，得到的结果就是最终要返回的头结点。
     * 但是要将head的next与原来head.next的next指针进行调整。
     * 同时要将head.next置为null，避免原head与head.next形成循环链表
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }



    public ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
