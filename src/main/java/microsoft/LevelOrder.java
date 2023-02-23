package microsoft;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层序遍历
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * <p>
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * <p>
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/14 1:30 下午
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();

        if (root == null) {
            return res;
        }

        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = list.poll();
                tmp.add(pop.val);
                if (pop.left != null) {
                    list.add(pop.left);
                }
                if (pop.right != null) {
                    list.add(pop.right);
                }
            }
            res.add(tmp);
        }
        return res;

    }

}
