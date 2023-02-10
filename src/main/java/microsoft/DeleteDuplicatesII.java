package microsoft;

import listnode.ListNode;

/**
 * 删除排序链表中的重复元素 II
 * <p>
 * <p>
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/9 1:58 下午
 */
public class DeleteDuplicatesII {
    public static void main(String[] args) {
        ListNode listNode7 = new ListNode(5);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode head = new ListNode(1);
        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        new DeleteDuplicatesII().deleteDuplicates(head);
    }

    /**
     * 使用dummyHead作为辅助头结点，完成初始化
     * max记录当前已遍历的最大值
     * pre维护上一有效节点，一遍实现删除操作
     * 当前节点需要删除的条件：
     * 1、当前节点值 = max，且max不需要更新
     * 2、当前节点值 != max，但是当前节点值等于下一个节点值（下一节点不为null），此时删除当前节点，且更新max
     * 如当前节点不需要删除，则更新tmp，并右移
     * 
     * @param head 
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode cur = head;
        int max = pre.val;

        while (cur != null) {
            if (cur.val == max) {
                pre.next = cur.next;
            } else if (cur.next != null && cur.val == cur.next.val) {
                max = cur.val;
                pre.next = cur.next;
            } else {
                max = cur.val;
                pre = cur;
            }
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
