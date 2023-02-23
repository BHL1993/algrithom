package microsoft;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的锯齿形层序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/14 2:12 下午
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }

        queue.add(root);
        boolean forward = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (forward) {
                    list.add(root.val);
                } else {
                    list.addFirst(root.val);
                }

                if (root.left != null) {
                    queue.add(root.left);
                }

                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            res.add(list);
            forward = !forward;
        }

        return res;
    }
}
