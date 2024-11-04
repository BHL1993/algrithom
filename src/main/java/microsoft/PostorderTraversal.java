package microsoft;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 后续遍历
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/3/7 3:03 下午
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        postOrder(res, root);

        return res;

    }

    private void postOrder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(res, root.left);
        postOrder(res, root.right);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            if (root == null) {
                root = stack.pop();
                root = root.left;
            } else {
                res.addFirst(root.val);
                stack.push(root);
                root = root.right;
            }
        }

        return res;

    }
}
