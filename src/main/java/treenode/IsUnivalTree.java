package treenode;

/**
 * 单值二叉树
 * 
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/18 2:27 下午
 */
public class IsUnivalTree {

    public boolean isUnivalTree1(TreeNode root) {
        return getUnival(root, root.val) > 0;
    }

    private int getUnival(TreeNode root, int val) {
        if (root == null) {
            return 1;
        }

        if (root.val != val) {
            return -1;
        }

        int left = getUnival(root.left, val);
        if (left < 0) {
            return -1;
        }

        int right = getUnival(root.right, val);
        if (right < 0) {
            return -1;
        }

        return 1;
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if(root.left == null){
            return root.val == root.right.val && isUnivalTree1(root.right);
        }

        if(root.right == null){
            return root.val == root.left.val && isUnivalTree1(root.left);
        }

        return (root.val == root.right.val && isUnivalTree1(root.right)) && (root.val == root.left.val && isUnivalTree1(root.left));
    }
}
