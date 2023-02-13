package microsoft;

import listnode.ListNode;

/**
 * 反转链表 II
 * <p>
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * 提示：
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * https://leetcode.cn/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
 */
public class ReverseBetween {
    ListNode successor = null;

    /**
     * reverseBetween 将head为头结点的链表，第[m, n]个位置的节点 进行翻转，并返回头节点。
     * 整体思路：
     *  1、找到第一个需要翻转的节点
     *  2、将问题转换为翻转链表的前k个节点，并返回头结点
     *
     * 实现：
     *  1、终止条件：m == 1。
     *      m==1时，代表当前节点为需要翻转的第一个节点，将问题转化为翻转链表的前 k 个节点问题后，返回翻转后的头节点
     *  2、继续递归条件：m > 1
     *      m > 1时，由于还未到达第一个需要翻转的节点，递归调用 reverseBetween，返回的新的头结点与当前节点不需要翻转，因此 当前节点的next指针 继续指向 返回的新的头结点
     *  3、边界值情况
     *      head.next为第一个需要翻转的节点，reverseBetween 返回值代表 翻转前k个节点后 的新的头结点，因此 当前节点的next指针 需要指向 翻转后的头结点。
     */
    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseFirstK(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

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

}
