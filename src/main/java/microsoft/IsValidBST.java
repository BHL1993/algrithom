package microsoft;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证二叉搜索树
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/13 9:42 下午
 */
public class IsValidBST {
    private int pre = Integer.MIN_VALUE;

    /**
     * 利用二叉搜索树特性，中序遍历后的数列应为升序数列
     * 使用pre维护先前遍历的节点值，如果当前节点值小于pre，直接返回false，无需继续往下遍历
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }

        if (pre <= root.val) {
            pre = root.val;
        } else {
            return false;
        }

        return isValidBST(root.right);
    }


    public boolean isValidBST3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int pre = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Integer cur = list.get(i);
            if (cur <= pre) {
                return false;
            } else {
                pre = cur;
            }
        }
        return true;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean re = isSmall(root.left, root.val) && isBig(root.right, root.val);
        if (!re) {
            return false;
        }

        return isValidBST2(root.left) && isValidBST2(root.right);
    }

    private boolean isBig(TreeNode right, int val) {
        if (right == null) {
            return true;
        }
        if (right.val <= val) {
            return false;
        }

        return isBig(right.left, val) && isBig(right.right, val);
    }

    private boolean isSmall(TreeNode left, int val) {
        if (left == null) {
            return true;
        }
        if (left.val >= val) {
            return false;
        }

        return isSmall(left.left, val) && isSmall(left.right, val);
    }


    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean validLeft = isValidBST1(root.left);
        if (!validLeft) {
            return false;
        }
        boolean validRight = isValidBST1(root.right);
        if (!validRight) {
            return false;
        }

        if (root.left != null && root.right != null) {
            return root.left.val < root.val && root.val < root.right.val;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left == null) {
            return root.val < root.right.val;
        } else {
            return root.left.val < root.val;
        }
    }
}
