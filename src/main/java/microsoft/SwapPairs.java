package microsoft;

import listnode.ListNode;

/**
 * 两两交换链表中的节点
 * 
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 
 * 
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 
 * 
 * 示例 2：
 * 
 * 输入：head = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 输入：head = [1]
 * 输出：[1]
 * 
 * 
 * 提示：
 * 
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/28 5:40 下午
 */
public class SwapPairs {
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs1(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode tmp = dummyHead;

        while (tmp.next != null && tmp.next.next != null) {
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;

            node1.next = node2.next;
            tmp.next = node2;
            node2.next = node1;
            tmp = node1;
        }

        return dummyHead.next;


    }

    public ListNode swap(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode next = head.next.next;
        head.next.next = head;
        ListNode tmp = head.next;
        head.next = next;
        return tmp;
    }
}
