package microsoft;

import treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/14 2:21 下午
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth1(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            res++;
        }
        return res;
    }
}
