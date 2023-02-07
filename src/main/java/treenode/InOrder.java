package treenode;

import java.util.*;

/**
 * 中序遍历
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/9 11:32 上午
 */
public class InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
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

    public List<Integer> inorder(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        traverse(root, ret);
        return ret;
    }

    public void traverse(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        traverse(root.left, ret);
        ret.add(root.val);
        traverse(root.right, ret);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
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

    public List<Integer> preOrderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
            if (root != null) {
                ret.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }

        return ret;
    }

    public List<Integer> postOrderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
            if (root != null) {
                ret.add(root.val);
                stack.push(root.left);
                root = root.right;
            } else {
                root = stack.pop();
            }
        }

        Collections.reverse(ret);

        return ret;
    }

    public static void main(String[] args) {
        TreeNode h = new TreeNode(3);
        h.left = new TreeNode(9);
        TreeNode l = new TreeNode(20);
        h.right = l;
        l.right = new TreeNode(7);
        l.left = new TreeNode(15);
        System.out.println(levelOrderTraversal3(h));
    }

    public static List<Integer> levelOrderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (root != null || !queue.isEmpty()) {
            root = queue.poll();

            if (root != null) {
                ret.add(root.val);
                queue.add(root.left);
                queue.add(root.right);
            } else {
                root = queue.poll();
            }
        }
        return ret;
    }

    public static List<List<Integer>> levelOrderTraversal3(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (root != null || !queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();

                if (root != null) {
                    tmp.add(root.val);
                    queue.add(root.left);
                    queue.add(root.right);
                } else {
                    root = queue.poll();
                }
            }
            if (tmp.size() > 0) {
                ret.add(tmp);
            }
        }
        return ret;
    }
}
