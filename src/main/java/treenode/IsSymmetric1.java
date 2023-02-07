package treenode;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/12/18 3:30 下午
 */
public class IsSymmetric1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null && root2 != null) {
            if (root1.val != root2.val) {
                return false;
            } else {
                return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
            }
        } else {
            return false;
        }
    }
}
