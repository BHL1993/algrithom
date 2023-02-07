package treenode;

/**
 * 二叉搜索树的最近公共祖先
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/18 4:32 下午
 */
public class LowestCommonAncestor1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.min(p.val, q.val);
        if (min <= root.val && root.val <= max) {
            return root;
        }

        if (root.val < min) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}
