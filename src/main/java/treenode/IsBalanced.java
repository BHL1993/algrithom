package treenode;

/**
 * 平衡二叉树
 * 
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 
 * 本题中，一棵高度平衡二叉树定义为：
 * 
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/14 3:45 下午
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.right), getDepth(node.left)) + 1;
    }

    public boolean isBalanced1(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        return Math.abs(leftHeight - rightHeight) <= 1 ? Math.max(leftHeight, rightHeight) : -1;
    }

}
