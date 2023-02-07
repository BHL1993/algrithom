package treenode;

import java.util.Stack;

/**
 * 验证二叉搜索树
 * 
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 
 * 有效 二叉搜索树定义如下：
 * 
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/20 5:53 下午
 */
public class IsValidBST {
    long pre = Long.MIN_VALUE;
    boolean ans = true;

    public boolean isValidBST(TreeNode root) {
        valid(root);
        return ans;
    }

    private void valid(TreeNode root) {
        if (root == null) {
            return;
        }

        valid(root.left);

        if (root.val <= pre) {
            ans = false;
        } else {
            pre = root.val;
        }

        valid(root.right);
    }

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }

        long pre = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode n = stack.pop();
                if (n.val <= pre) {
                    return false;
                } else {
                    pre = n.val;
                }
                root = n.right;
            }
        }

        return true;
    }
}
