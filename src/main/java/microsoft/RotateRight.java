package microsoft;

import listnode.ListNode;

/**
 * 旋转链表
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/6 8:09 下午
 */
public class RotateRight {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode1 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode = new RotateRight().rotateRight(listNode1, 2);
        System.out.println("");

    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        int len = 1;
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            len++;
        }

        tmp.next = head;

        int n = k % len;

        int i = len - n - 1;
        tmp = head;
        while (i > 0) {
            tmp = tmp.next;
            i--;
        }

        ListNode newHead = tmp.next;
        tmp.next = null;
        return newHead;
    }
}
