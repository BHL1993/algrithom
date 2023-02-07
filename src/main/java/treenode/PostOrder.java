package treenode;

import java.util.*;

/**
 * 后续遍历  左 -> 右 -> 中
 *
 * 1、中 -> 右 -> 左，然后反向排序输出
 * 2、addFirst，中 -> 右 -> 左
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/9 2:28 下午
 */
public class PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
            if (root != null) {
                ret.add(root.val);
                if (root.left != null) {
                    stack.push(root.left);
                }
                root = root.right;
            } else {
                root = stack.pop();
            }
        }

        Collections.reverse(ret);

        return ret;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
            if (root != null) {
                ret.addFirst(root.val);
                if (root.left != null) {
                    stack.push(root.left);
                }
                root = root.right;
            } else {
                root = stack.pop();
            }
        }

        return ret;
    }
}
