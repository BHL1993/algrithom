package treenode;

/**
 * .二叉树的镜像
 * 
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/18 3:24 下午
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp;

        tmp = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = tmp;

        return root;
    }
}
