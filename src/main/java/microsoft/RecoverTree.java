package microsoft;

import treenode.TreeNode;

/**
 * 恢复二叉搜索树
 * <p>
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * <p>
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 * <p>
 * 提示：
 * 树上节点的数目在范围 [2, 1000] 内
 * -231 <= Node.val <= 231 - 1
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/13 10:27 下午
 */
public class RecoverTree {
    TreeNode first, second, pre;

    /**
     * 利用搜索二叉树的特性，在中序遍历二叉树的过程中，分别使用 first、second 记录 第一个位置错误的节点 与 第二个位置错误的节点
     * 遍历结束后，交换两个错误节点的值即可
     *
     * 正常的升序数组： 1、3、4、5、6、7、11、12
     *
     * 出现异常顺序的情况：pre.val >= root.val
     * 错误的节点可能是pre，也可能是root，也可能pre、root都是错误节点
     *
     * pre.val >= root.val时
     *  如果 first == null，则 pre 为第一个错误节点
     *  否则，root 为第二个错误节点
     *  边界场景：pre、root两个都为错误节点，且位置相邻。
     *  因此 无论 first 是否为null，只要pre.val >= root.val，都需要将 second 指向 root，以兼容边界情况。
     */
    public void recoverTree(TreeNode root) {
        inOrder(root);

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        if (pre == null) {
            pre = root;
        } else {
            if (pre.val > root.val) {
                if (first == null) {
                    first = pre;
                }
                second = root;
            }
            pre = root;
        }

        inOrder(root.right);
    }
}
