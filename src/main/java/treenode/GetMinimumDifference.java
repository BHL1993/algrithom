package treenode;

/**
 * 二叉搜索树的最小绝对差
 * 
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 
 * 差值是一个正数，其数值等于两值之差的绝对值
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/16 3:38 下午
 */
public class GetMinimumDifference {

    public static void main(String[] args) {
        TreeNode h = new TreeNode(1);
        TreeNode hl = new TreeNode(0);
        TreeNode hr = new TreeNode(48);
        TreeNode hrl = new TreeNode(12);
        TreeNode hrr = new TreeNode(49);

        h.left = hl;
        h.right = hr;

        hr.left = hrl;
        hr.right = hrr;

        System.out.println(getMinimumDifference(h));
    }

    private static int min = Integer.MAX_VALUE;
    private static int pre = -1;

    public static int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (pre == -1) {
            pre = root.val;
        } else {
            min = Math.min(min, root.val - pre);
            pre = root.val;
        }

        dfs(root.right);
    }
}
