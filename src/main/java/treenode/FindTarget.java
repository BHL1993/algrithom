package treenode;

import java.util.HashSet;

/**
 * 两数之和 IV - 输入 BST
 * 
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/17 11:33 上午
 */
public class FindTarget {
    HashSet<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        if (set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);

        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
