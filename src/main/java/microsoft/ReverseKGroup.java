package microsoft;

import listnode.ListNode;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 
 * 
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/28 6:25 下午
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pt = head;
        int count = 0;
        while (pt != null && count != k) {
            pt = pt.next;
            count++;
        }

        if (count == k) {
            ListNode next = reverseKGroup(pt, k);
            //翻转当前部分链表
            while (count != 0) {
                count--;
                ListNode tmp = head.next;
                head.next = next;
                next = head;
                head = tmp;
            }

            head = next;
        }
        return head;
    }


    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }

        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count != 0) {
                count--;
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }
}
