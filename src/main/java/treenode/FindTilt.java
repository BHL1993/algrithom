package treenode;

/**
 * 二叉树的坡度
 * 
 * 给你一个二叉树的根节点 root ，计算并返回 整个树 的坡度 。
 * 
 * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 * 
 * 整个树 的坡度就是其所有节点的坡度之和。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/16 5:26 下午
 */
public class FindTilt {
    int tiltSum = 0;

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getSum(root);
        return tiltSum;
    }



    private int getSum(TreeNode node) {
        if (null == node) {
            return 0;
        }

        int leftSum = getSum(node.left);
        int rightSum = getSum(node.right);

        tiltSum += Math.abs(leftSum - rightSum);

        return node.val + getSum(node.right) + getSum(node.left);
    }
}
