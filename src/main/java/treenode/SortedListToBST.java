package treenode;

import listnode.ListNode;

/**
 * 有序链表转换二叉搜索树
 * 
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/22 1:26 下午
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (null == head) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head, fast = head, pre = null;
        while (null != fast && null != fast.next) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        pre.next = null;

        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);

        return node;
    }
}
