package microsoft;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/13 3:40 下午
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || root != null) {
            if (root == null) {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }

        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        dfs(root, res);

        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        dfs(root.left, res);

        res.add(root.val);

        dfs(root.right, res);
    }
}
