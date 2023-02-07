package treenode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的堂兄弟节点
 * 
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/18 2:36 下午
 */
public class IsCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            int firstIndex = -1, secondIndex = -1;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodeQueue.poll();
                if (treeNode != null) {
                    if (treeNode.val == x || treeNode.val == y) {
                        if (firstIndex == -1) {
                            firstIndex = i;
                        } else {
                            secondIndex = i;
                            break;
                        }
                    }

                    treeNodeQueue.add(treeNode.left);
                    treeNodeQueue.add(treeNode.right);
                }
            }

            if (secondIndex - firstIndex > 1 || secondIndex % 2 == 0){
                return true;
            }
        }

        return false;
    }
}
