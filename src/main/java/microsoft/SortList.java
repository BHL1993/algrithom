package microsoft;

import listnode.ListNode;

/**
 * 排序链表
 * <p>
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 * <p>
 * <p>
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/3/10 10:53 上午
 */
public class SortList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = new SortList().sortList(node1);
        System.out.println();
    }

    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }

        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode h1 = sort(head, slow);
        ListNode h2 = sort(slow, tail);

        return merge(h1, h2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        ListNode tmp1 = head1;
        ListNode tmp2 = head2;

        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val <= tmp2.val) {
                cur.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                cur.next = tmp2;
                tmp2 = tmp2.next;
            }
            cur = cur.next;
        }

        if(tmp1 != null){
            cur.next = tmp1;
        }else if(tmp2 != null){
            cur.next = tmp2;
        }

        return dummyHead.next;
    }

    private ListNode merge1(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head1;
        ListNode pre = dummyHead;
        ListNode cur1 = head1;
        ListNode cur2 = head2;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                ListNode tmp = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                cur1 = cur1.next;
                cur2 = tmp;
            }
        }

        if (cur2 != null) {
            pre.next = cur2;
        }

        return dummyHead.next;

    }
}
