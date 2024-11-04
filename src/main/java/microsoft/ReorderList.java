package microsoft;

import listnode.ListNode;

/**
 * 重排链表
 * <p>
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * <p>
 * <p>
 * 示例 2：
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * <p>
 * <p>
 * 提示：
 * 链表的长度范围为 [1, 5 * 104]
 * 1 <= node.val <= 1000
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/3/7 2:22 下午
 */
public class ReorderList {
    /**
     * 1、使用快慢指针 找到中间节点
     * 2、翻转后部分链表
     * 3、交错拼接两部分链表
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head1 = head;
        ListNode head2 = reverse(slow.next);
        slow.next = null;

        while (head1 != null && head2 != null) {
            ListNode tmp1 = head1.next;
            ListNode tmp2 = head2.next;
            head1.next = head2;
            head1.next.next = tmp1;
            head2 = tmp2;
            head1 = tmp1;
        }

    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
