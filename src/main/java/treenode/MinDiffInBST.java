package treenode;

/**
 * 二叉搜索树节点最小距离
 * 
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/17 2:11 下午
 */
public class MinDiffInBST {
    int min = Integer.MAX_VALUE, pre = -1;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);

        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        if (pre != -1) {
            min = Math.min(min, Math.abs(root.val - pre));
        }
        pre = root.val;
        dfs(root.right);
    }

}
