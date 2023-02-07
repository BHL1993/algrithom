package treenode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最大深度
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/12 9:06 下午
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode m = queue.poll();
                if (m.left != null) {
                    queue.add(m.left);
                }

                if (m.right != null) {
                    queue.add(m.right);
                }
            }

            max++;
        }

        return max;
    }
}
