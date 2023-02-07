package microsoft;

import treenode.TreeNode;

import java.util.*;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/1 11:05 上午
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> list = new ArrayDeque<>();
        dfs(root, targetSum, list, res);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, Deque<Integer> list, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        if (root.val == targetSum && root.left == null && root.right == null) {
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.pollLast();
        }


        list.add(root.val);
        dfs(root.left, targetSum - root.val, list, res);
        dfs(root.right, targetSum - root.val, list, res);
        list.pollLast();
    }
}
