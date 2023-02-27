package microsoft;

import treenode.TreeNode;

/**
 * 二叉树最小深度
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/25 12:10 下午
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
