package newpath;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/4 9:34 下午
 */
public class PreOrder {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || root != null) {
            if (root != null) {
                if (root.right != null) {
                    stack.add(root.right);
                }
                ret.add(root.val);
                root = root.left;
            } else {
                root = stack.pop();
            }
        }

        return ret;
    }

    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || root != null) {
            if (root.right != null) {
                stack.add(root.right);
            }
            ret.add(root.val);
            root = root.left;
            if (root == null) {
                if (stack.empty()) {
                    break;
                }
                root = stack.pop();
            }
        }

        return ret;
    }


    public static List<Integer> preorderRecurse(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        preorderRecurse(root, ret);
        return ret;
    }

    public static void preorderRecurse(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }

        ret.add(root.val);
        preorderRecurse(root.left, ret);
        preorderRecurse(root.right, ret);
    }
}
