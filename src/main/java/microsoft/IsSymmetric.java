package microsoft;

import treenode.TreeNode;

/**
 * 对称二叉树
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/14 11:32 上午
 */
public class IsSymmetric {
    /**
     * 转换为类似相同树的问题
     * 对称树理解为：根节点相同的两棵树，其各自 左子树 与 另一棵的右子树 应该是对称树，右子树 与 另一棵的左子树 也应该是对称树。
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null && left.val == right.val) {
            return symmetric(left.left, right.right) && symmetric(left.right, right.left);
        }
        return false;
    }
}
