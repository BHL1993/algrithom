package microsoft;

import treenode.TreeNode;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/23 8:14 下午
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                list.add(root.val);
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            stack.push(list);
        }

        while (!stack.empty()) {
            ret.add(stack.pop());
        }

        return ret;
    }
}
