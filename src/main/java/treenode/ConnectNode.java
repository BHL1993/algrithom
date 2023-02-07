package treenode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/12/23 9:41 上午
 */
public class ConnectNode {
    public Node connect(Node root) {
        if (null == root) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }
}
