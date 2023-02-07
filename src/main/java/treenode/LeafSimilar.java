package treenode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 叶子相似的树
 * 
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/17 2:18 下午
 */
public class LeafSimilar {

    Queue<Integer> queue = new LinkedList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs1(root1);

        dfs2(root2);

        return queue.isEmpty();
    }

    private void dfs2(TreeNode root2) {
        if (root2 == null) {
            return;
        }

        dfs2(root2.left);

        if (root2.left == null && root2.right == null) {
            if (queue.size() == 0 || queue.peek() != root2.val) {
                queue.add(root2.val);
            } else {
                queue.poll();
            }
        }

        dfs2(root2.right);
    }

    private void dfs1(TreeNode root1) {
        if (root1 == null) {
            return;
        }
        dfs1(root1.left);

        if (root1.left == null && root1.right == null) {
            queue.add(root1.val);
        }

        dfs1(root1.right);
    }


}
