package treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的锯齿形层序遍历
 * 
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/21 9:33 上午
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean preOrder = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp;
            if (preOrder) {
                tmp = new ArrayList<>();
            } else {
                tmp = new LinkedList<>();
            }

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (preOrder) {
                    tmp.add(node.val);
                } else {
                    ((LinkedList) tmp).addFirst(node.val);
                }

                if (null != node.left) {
                    queue.add(node.left);
                }

                if (null != node.right) {
                    queue.add(node.right);
                }
            }
            ans.add(tmp);
            preOrder = !preOrder;
        }

        return ans;
    }
}
