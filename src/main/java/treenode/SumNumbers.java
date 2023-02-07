package treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * 求根节点到叶节点数字之和
 * 
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 
 * 叶节点 是指没有子节点的节点。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/23 10:12 上午
 */
public class SumNumbers {

    public int ans = 0;

    public int sumNumbers(TreeNode root) {
        buildSum(root, 0);
        return ans;
    }

    private void buildSum(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        int tmp = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            ans += tmp;
            return;
        }

        buildSum(root.left, tmp);
        buildSum(root.right, tmp);
    }

    public int sumNumbers1(TreeNode root) {
        List<String> retList = new ArrayList<>();

        build(root, retList, new StringBuilder());

        int ans = 0;
        for (int i = 0; i < retList.size(); i++) {
            ans += Integer.parseInt(retList.get(i));
        }
        return ans;
    }

    private void build(TreeNode root, List<String> retList, StringBuilder stringBuilder) {
        if (root == null) {
            return;
        }

        stringBuilder.append(root.val);
        if (root.left == null && root.right == null) {
            retList.add(stringBuilder.toString());
            return;
        }

        build(root.left, retList, new StringBuilder(stringBuilder));
        build(root.right, retList, new StringBuilder(stringBuilder));
    }
}
