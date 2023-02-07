package treenode;

import java.util.Stack;

/**
 * 恢复二叉树
 * 
 * 给你二叉搜索树的根节点 root ，该树中的两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/20 6:27 下午
 */
public class RecoverTree {
    TreeNode first = null, second = null, pre = null;

    public void recoverTree1(TreeNode root) {
        inOrder(root);

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        if (pre != null && pre.val >= root.val) {
            second = root;
            if(first == null){
                first = pre;
            }
        }

        pre = root;

        inOrder(root.right);
    }


    public void recoverTree(TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || null != root) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode n = stack.pop();
                if (pre != null && pre.val >= n.val) {
                    second = n;
                    if(first == null){
                        first = pre;
                    }
                }
                pre = n;
                root = n.right;
            }
        }

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
