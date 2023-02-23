package microsoft;

import listnode.ListNode;
import treenode.TreeNode;

/**
 * 有序链表转换二叉搜索树
 * <p>
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/23 9:37 下午
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        return build(head, null);
    }

    /**
     * 确定链表中间节点后，递归形成左子树及右子树
     *
     * @param left 链表开始位置
     * @param right 链表结束位置  只做标记使用，不参与当前递归及后续递归的结果集
     * @return
     */
    private TreeNode build(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }

        ListNode slow = left;
        ListNode fast = left;

        while (fast.next != right && fast.next.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = build(left, slow);
        root.right = build(slow.next, right);

        return root;
    }
}
