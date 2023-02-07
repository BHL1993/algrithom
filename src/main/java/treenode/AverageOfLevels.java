package treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层平均值
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/16 9:08 下午
 */
public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> retList = new ArrayList<>();

        if (root == null) {
            return retList;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                sum += n.val;

                if (n.left != null) {
                    queue.add(n.left);
                }

                if (n.right != null) {
                    queue.add(n.right);
                }
            }

            retList.add( sum / size);
        }

        return retList;
    }
}
