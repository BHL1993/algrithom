package treenode;

/**
 * 翻转二叉树
 * 
 * 翻转一棵二叉树。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/15 2:25 下午
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);

        return root;
    }

    public void invert(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invert(root.left);
        invert(root.right);
    }
}
