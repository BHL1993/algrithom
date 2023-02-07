package treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * 不同的二叉搜索树 II
 * 
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/18 8:58 下午
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> treeNodeList = new ArrayList<>();

        if (start > end) {
            treeNodeList.add(null);
            return treeNodeList;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftGenerate = generate(start, i - 1);
            List<TreeNode> rightGenerate = generate(i + 1, end);


            for (TreeNode node : leftGenerate) {
                for (TreeNode value : rightGenerate) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = node;
                    treeNode.right = value;
                    treeNodeList.add(treeNode);
                }
            }
        }

        return treeNodeList;
    }


}
