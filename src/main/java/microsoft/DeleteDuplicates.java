package microsoft;

import listnode.ListNode;

/**
 * 删除排序链表中的重复元素
 * <p>
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * <p>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * <p>
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/9 2:57 下午
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return dummyHead.next;

    }
}
