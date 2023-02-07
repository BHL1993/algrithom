package treenode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/22 1:25 下午
 */
public class BuildTree1 {
    public Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int inOrderLeft, int inOrderRight, int postOrderLeft, int postOrderRight) {
        if (inOrderLeft > inOrderRight) {
            return null;
        }

        TreeNode treeNode = new TreeNode(postorder[postOrderRight]);
        int rootIndex = map.get(postorder[postOrderRight]);

        int leftNodeSize = rootIndex - inOrderLeft;


        treeNode.left = build(inorder, postorder, inOrderLeft, rootIndex - 1, postOrderLeft, postOrderLeft + leftNodeSize - 1);
        treeNode.right = build(inorder, postorder, rootIndex + 1, inOrderRight, postOrderLeft + leftNodeSize, postOrderRight - 1);
        return treeNode;
    }
}