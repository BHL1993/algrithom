package treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * 从根到叶的二进制数之和
 * 
 * 给出一棵二叉树，其上每个结点的值都是0或1。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数01101，也就是13。
 * 
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/18 2:52 下午
 */
public class SumRootToLeaf {
    public int sumRootToLeaf(TreeNode root) {
        return getSum(root, 0);

    }

    private int getSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        sum = sum * 2 + root.val;
        return getSum(root.left, sum) + getSum(root.right, sum);
    }

    public static int sumRootToLeaf1(TreeNode root) {
        List<String> retList = new ArrayList<>();
        dfs(root, new StringBuilder(), retList);

        int sum = 0;
        for (String s : retList) {
            sum += getInt(s);
        }

        return sum;
    }

    private static int getInt(String s) {
        return Integer.valueOf(s, 2);
    }

    private static void dfs(TreeNode root, StringBuilder stringBuilder, List<String> retList) {
        if (root == null) {
            return;
        }

        StringBuilder sb = new StringBuilder(stringBuilder).append(root.val);
        if (root.left == null && root.right == null) {
            retList.add(sb.toString());
        }
        if (root.left != null) {
            dfs(root.left, new StringBuilder(sb), retList);
        }
        if (root.right != null) {
            dfs(root.right, new StringBuilder(sb), retList);
        }
    }

    public static void main(String[] args) {
        TreeNode h = new TreeNode(1);
        TreeNode hl = new TreeNode(0);
        TreeNode hr = new TreeNode(1);
        TreeNode hll = new TreeNode(0);
        TreeNode hlr = new TreeNode(1);
        TreeNode hrl = new TreeNode(0);
        TreeNode hrr = new TreeNode(1);

        h.left = hl;
        h.right = hr;

        hl.left = hll;
        hl.right = hlr;

        hr.left = hrl;
        hr.right = hrr;

        sumRootToLeaf1(h);
    }
}
