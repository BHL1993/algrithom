package treenode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径总和 II
 * 
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 
 * 叶子节点 是指没有子节点的节点。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/22 8:16 下午
 */
public class PathSum {
    public List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        if (null == root) {
            return ret;
        }

        build(new ArrayList<>(), root, targetSum);

        return ret;
    }

    private void build(List<Integer> list, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            ret.add(list);
            return;
        }

        if (root.left != null) {
            build(new ArrayList<>(list), root.left, targetSum - root.val);
        }

        if (root.right != null) {
            build(new ArrayList<>(list), root.right, targetSum - root.val);
        }
    }



    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast();
    }

}
