package microsoft;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 求根节点到叶节点数字之和
 * <p>
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 * <p>
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 9
 * 树的深度不超过 10
 */
public class SumNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode(6);
        root.right = new TreeNode(7);

        root.left.right = new TreeNode(8);
        root.left.left = new TreeNode(9);
        System.out.println(new SumNumbers().sumNumbers(root));
    }

    public int sumNumbers1(TreeNode root) {
        List<String> resList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(root, resList, sb);
        System.out.println(resList);
        return 0;
    }

    private void dfs(TreeNode root, List<String> resList, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append(root.val);

        if (root.left == null && root.right == null) {
            resList.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        dfs(root.left, resList, sb);
        dfs(root.right, resList, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    private int res = 0;

    public int sumNumbers(TreeNode root) {
        dfs1(root, 0);
        return res;
    }

    private void dfs1(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum = (sum * 10 + root.val);
        if (root.left == null && root.right == null) {
            res+= sum;
            return;
        }

        dfs1(root.left, sum);
        dfs1(root.right, sum);
    }


}
