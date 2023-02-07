package newpath;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/9 11:32 上午
 */
public class InOrder {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                ret.add(root.val);
                root = root.right;
            }
        }

        return ret;
    }


    public static void inorderRecurse(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }

        inorderRecurse(root.left, ret);
        ret.add(root.val);
        inorderRecurse(root.right, ret);
    }
}
