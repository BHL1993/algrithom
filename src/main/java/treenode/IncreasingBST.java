package treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递增顺序搜索树
 * 
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/18 11:10 上午
 */
public class IncreasingBST {
    public TreeNode increasingBST1(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();

        dfs(root, ansList);

        TreeNode dummyHead = new TreeNode(-1);
        TreeNode tmp = dummyHead;
        for (Integer i : ansList) {
            tmp.right = new TreeNode(i);
            tmp = tmp.right;
        }

        return dummyHead.right;
    }

    private void dfs(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return;
        }

        dfs(root.left, ansList);
        ansList.add(root.val);
        dfs(root.right, ansList);
    }

    public TreeNode curNode;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyHead = new TreeNode(-1);

        curNode = dummyHead;

        dfs(root);

        return dummyHead.right;

    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        curNode.right = root;
        root.left = null;
        curNode = root;
    }
}
