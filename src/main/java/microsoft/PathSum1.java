package microsoft;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径总和 II
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/25 12:27 下午
 */
public class PathSum1 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> list = new LinkedList<>();

        dfs(res, list, root, targetSum);

        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> list, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            res.add(new ArrayList<>(list));
            list.pollLast();
            return;
        }

        dfs(res, list, root.left, targetSum - root.val);
        dfs(res, list, root.right, targetSum - root.val);
        list.pollLast();
    }
}
