package treenode;

/**
 * 二叉搜索树的范围和
 * 
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/18 2:18 下午
 */
public class RangeSumBST {
    public int sum = 0;

    public int rangeSumBST1(TreeNode root, int low, int high) {
        dfs(root, low, high);

        return sum;
    }

    private void dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        dfs(root.left, low, high);

        if (low <= root.val && root.val <= high) {
            sum += root.val;
        }

        dfs(root.right, low, high);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
    }
}
