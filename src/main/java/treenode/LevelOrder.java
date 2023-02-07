package treenode;

import java.util.*;

/**
 * 层次遍历
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/12 10:49 上午
 */
public class LevelOrder {
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();

        if (root == null) {
            return null;
        }

        treeNodeQueue.add(root);
        while (treeNodeQueue.size() != 0) {
            int size = treeNodeQueue.size();
            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                root = treeNodeQueue.poll();
                ans.add(root.val);
                if (root.left != null) {
                    treeNodeQueue.add(root.left);
                }
                if (root.right != null) {
                    treeNodeQueue.add(root.right);
                }
            }
            ret.add(ans);
        }

        return ret;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();

        while (root != null || treeNodeQueue.size() != 0) {
            if (root != null) {
                ret.add(root.val);
                if (root.left != null) {
                    treeNodeQueue.add(root.left);
                }
                if (root.right != null) {
                    treeNodeQueue.add(root.right);
                }
            }
            root = treeNodeQueue.poll();
        }

        return ret;
    }

    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();

        if (root == null) {
            return null;
        }

        treeNodeQueue.add(root);

        while (treeNodeQueue.size() != 0) {
            root = treeNodeQueue.poll();
            if (root != null) {
                ret.add(root.val);

                if (root.left != null) {
                    treeNodeQueue.add(root.left);
                }
                if (root.right != null) {
                    treeNodeQueue.add(root.right);
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        TreeNode h = new TreeNode(3);
        h.left = new TreeNode(9);
        TreeNode l = new TreeNode(20);
        h.right = l;
        l.right = new TreeNode(7);
        l.left = new TreeNode(15);
        System.out.println(postorderTraversal1(h));
    }
}
