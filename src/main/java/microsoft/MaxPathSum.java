package microsoft;

import treenode.TreeNode;

/**
 * 二叉树中的最大路径和
 * <p>
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/3/2 9:38 下午
 */
public class MaxPathSum {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    /**
     * 1、递归计算当前节点 左、右节点的贡献值
     * 2、如果左、右节点的贡献值小于0，则贡献值赋为0，即小于0的节点没有贡献值
     * 3、获得 临时最大路径和 = 当前节点值 + 左节点贡献值 + 右节点贡献值
     * 4、更新最终 最大路径和
     * 5、计算 当前节点的最大贡献值 = 当前节点值 + max(左节点贡献值, 右节点贡献值)，
     *      即将当前节点作为其父节点路径的一部分时，该路径不可能同时包含当前节点的左、右节点，获得当前节点的最大贡献值后，回溯计算其父节点 临时最大路径和。
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        int cur = root.val + left + right;
        res = Math.max(res, cur);

        return root.val + Math.max(left, right);
    }
}
