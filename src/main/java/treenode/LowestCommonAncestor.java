package treenode;

/**
 * 二叉搜索树的最近公共祖先
 * 
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 例如，给定如下二叉搜索树: root =[6,2,8,0,4,7,9,null,null,3,5]
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/15 6:07 下午
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        return getAncestor(root, Math.min(p.val, q.val), Math.max(p.val, q.val));
    }

    TreeNode getAncestor(TreeNode root, int min, int max) {
        if (min <= root.val && root.val <= max) {
            return root;
        }

        if (root.val < min) {
            return getAncestor(root.right, min, max);
        } else {
            return getAncestor(root.left, min, max);
        }
    }
}
