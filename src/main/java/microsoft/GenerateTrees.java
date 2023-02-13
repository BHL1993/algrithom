package microsoft;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 不同的二叉搜索树 II
 * <p>
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * <p>
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/13 4:14 下午
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    /**
     * generate 方法生成 节点值从[start, end]的不同搜索二叉树
     * 递归逻辑：
     *      遍历[start, end]中的每个元素，分别以该元素i为根节点，构造不同的二叉搜索树。
     *      i为二叉搜索树的根节点时，i的左子树中的所有节点值都比i小，右子树中所有的节点值都比i大。
     *      因此递归调用 generate，使用[start, i-1]内的所有数字构造左子树集合S1，使用[i+1, end]构造右子树集合S2。
     *      S1集合数 m * S2集合数 n 代表以i为根节点的二叉搜索树的总个数，遍历S1与S2，构造i为根节点的树。
     *
     * 终止条件：
     *      start > end 时，没有元素可以构建二叉树，返回null。
     *      Tips：不能直接返回null。返回的是包含null的集合数组。用以表示没有左子树或右子树的情况，能够使得在循环遍历S1和S2的时候可以不用考虑边界情况
     *
     *      start == end 时，只有一个元素需要构建二叉搜索树，该二叉树即为该节点本身。
     */
    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = generate(start, i - 1);
            List<TreeNode> rightNodes = generate(i + 1, end);

            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public List<TreeNode> generateTrees1(int n) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (n == 0) {
            return ans;
        }
        return getAns(1, n);

    }

    private List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        //此时没有数字，将 null 加入结果中
        if (start > end) {
            ans.add(null);
            return ans;
        }
        //只有一个数字，当前数字作为一棵树加入结果中
        if (start == end) {
            TreeNode tree = new TreeNode(start);
            ans.add(tree);
            return ans;
        }
        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            //得到所有可能的左子树
            List<TreeNode> leftTrees = getAns(start, i - 1);
            //得到所有可能的右子树
            List<TreeNode> rightTrees = getAns(i + 1, end);
            //左子树右子树两两组合
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    //加入到最终结果中
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
