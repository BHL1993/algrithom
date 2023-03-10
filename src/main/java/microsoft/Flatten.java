package microsoft;

import treenode.TreeNode;

/**
 * 二叉树展开为链表
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/25 12:37 下午
 */
public class Flatten {

    /**
     *
     * 分别将左右子树拓展
     * 然后找到root左子树最后边的节点，将root右子树追加至该节点
     * 将root左子树作为root新的右子树
     *
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        if (root.left != null) {
            TreeNode tmp = root.left;
            while (tmp.right != null){
                tmp = tmp.right;
            }

            tmp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}
