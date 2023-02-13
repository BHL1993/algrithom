package microsoft;

import listnode.ListNode;

/**
 * 翻转链表的前K个节点
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/13 10:26 上午
 */
public class ReverseFirstK {
    ListNode successor = null;

    /**
     * 维护 successor 记录不需要翻转的头结点
     * 终止递归的条件为 k==1
     * 当 k==1 时，代表当前节点为最后一个需要翻转的节点
     * 此时 successor 赋值 node.next，并返回node作为新链表的头结点
     * 递归调用reverseFirstK后，返回的node为需要翻转的最后一个节点，即新链表的头结点
     * 此时需要将head.next与head进行翻转，即head.next.next = head
     * 同时，将head.next赋值 successor，这样可以处理边界情况，即将原head的next指向 不需要翻转的头结点
     */
    public ListNode reverseFirstK(ListNode head, int k) {
        if (k == 1) {
            successor = head.next;
            return head;
        }

        ListNode next = reverseFirstK(head.next, k - 1);
        head.next.next = head;
        head.next = successor;
        return next;
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
