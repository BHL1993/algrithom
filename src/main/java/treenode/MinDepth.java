package treenode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度
 * 
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 * 说明：叶子节点是指没有子节点的节点。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/12 10:25 上午
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }

        int leftMin = root.left == null ? Integer.MAX_VALUE : minDepth(root.left);
        int rightMin = root.right == null ? Integer.MAX_VALUE : minDepth(root.right);

        return Math.min(leftMin, rightMin) + 1;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minDepth = 0;


        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root.left == null && root.right == null) {
                    return minDepth + 1;
                }
                if (root.left != null) {
                    queue.add(root.left);
                }

                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            minDepth++;
        }

        return minDepth;
    }
}
