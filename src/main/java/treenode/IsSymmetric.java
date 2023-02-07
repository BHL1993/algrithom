package treenode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 对称树
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/12 8:35 下午
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (right == null || left == null) {
            return false;
        }

        if (left.val == right.val) {
            return symmetric(left.left, right.right) && symmetric(left.right, right.left);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode h = new TreeNode(1);
        TreeNode hl = new TreeNode(2);
        TreeNode hr = new TreeNode(2);
        TreeNode hll = null;
        TreeNode hlr = new TreeNode(3);
        TreeNode hrl = null;
        TreeNode hrr = new TreeNode(3);

        h.left = hl;
        h.right = hr;
        hl.left = hll;
        hl.right = hlr;
        hr.left = hrl;
        hr.right = hrr;

        System.out.println(isSymmetric1(h));

    }

    public static boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int m = size / 2;
            Stack<TreeNode> stack = new Stack<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }

                if (i < m) {
                    stack.push(node);
                } else {
                    TreeNode n = stack.pop();
                    if (n != null && node == null) {
                        return false;
                    }

                    if (n == null && node != null) {
                        return false;
                    }

                    if (n != null) {
                        if (n.val != node.val) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
