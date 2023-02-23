package microsoft;

import treenode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/23 8:04 下午
 */
public class BuildTree1 {
    private Map<Integer, Integer> positionMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            positionMap.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int inOrder_left, int inOrder_right, int postOrder_left, int postOrder_right) {
        if (inOrder_left > inOrder_right || postOrder_left > postOrder_right) {
            return null;
        }
        int val = postorder[postOrder_right];
        TreeNode root = new TreeNode(val);

        int inOrderPosition = positionMap.get(val);
        int count_left = inOrderPosition - inOrder_left;

        TreeNode left = build(inorder, postorder, inOrder_left, inOrderPosition - 1, postOrder_left, postOrder_left + count_left - 1);
        TreeNode right = build(inorder, postorder, inOrderPosition + 1, inOrder_right, postOrder_left + count_left, postOrder_right - 1);

        root.left = left;
        root.right = right;

        return root;
    }
}
