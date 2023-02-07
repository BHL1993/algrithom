package treenode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最底层最左边的值
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/18 4:58 下午
 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = 0;

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    ans = node.val;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return ans;

    }
}
