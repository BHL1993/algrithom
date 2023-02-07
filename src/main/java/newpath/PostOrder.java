package newpath;

import treenode.TreeNode;

import java.util.*;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/1/4 10:07 下午
 */
public class PostOrder {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || root != null) {
            if (root != null) {
                if (root.left != null) {
                    stack.push(root.left);
                }
                ret.add(root.val);
                root = root.right;
            } else {
                root = stack.pop();
            }
        }

        Collections.reverse(ret);
        return ret;
    }

    public static List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || root != null) {
            if (root != null) {
                if (root.left != null) {
                    stack.push(root.left);
                }
                ret.addFirst(root.val);
                root = root.right;
            } else {
                root = stack.pop();
            }
        }

        return ret;
    }
}
