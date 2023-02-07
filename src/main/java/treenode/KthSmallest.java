package treenode;

import java.util.Stack;

/**
 * 二叉搜索树中第K小的数
 * 
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/29 1:46 下午
 */
public class KthSmallest {
    int count = 1;
    int ans = 0;

    public int kthSmallest1(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        dfs(root.left, k);

        if (count++ == k) {
            ans = root.val;
            return;
        }

        dfs(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        int count = 1;
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                if (count++ == k) {
                    return node.val;
                }
                root = node.right;
            }
        }

        return 0;
    }
}
