package treenode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 路径总和
 * 
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 
 * 叶子节点 是指没有子节点的节点。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/14 8:40 下午
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.val == targetSum) {
            return true;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();

        treeNodeQueue.add(root);
        valueQueue.add(0);

        while (!treeNodeQueue.isEmpty()) {
            TreeNode node = treeNodeQueue.poll();
            Integer value = valueQueue.poll();

            if (node.right == null && node.left == null && value + node.val == targetSum) {
                return true;
            }

            if (node.left != null) {
                treeNodeQueue.add(node.left);
                valueQueue.add(node.val + value);
            }

            if (node.right != null) {
                treeNodeQueue.add(node.right);
                valueQueue.add(node.val + value);
            }
        }

        return false;
    }
}
