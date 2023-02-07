package treenode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * 
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/21 10:19 上午
 */
public class BuildTree {
    public Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //获取中序遍历中每个根节点对应的索引，用于获取该根节点对应的左子树节点数目与右子树节点数目
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }

    /**
     * 从先序遍历数组 preOrder[]、preStart、preStart 与 中序遍历数组 inorder[]、inStart、inEnd 中 构建二叉树
     *
     * @param preorder
     * @param inorder
     * @param inStart
     * @param inEnd
     * @param preStart
     * @param preEnd
     * @return
     */
    private TreeNode build(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int inRoot = map.get(preorder[preStart]);
        int leftNodeSize = inRoot - inStart;

        TreeNode node = new TreeNode(preorder[preStart]);

        node.left = build(preorder, inorder, inStart, inRoot - 1, preStart + 1, preStart + leftNodeSize);
        node.right = build(preorder, inorder, inRoot + 1, inEnd, preStart + leftNodeSize + 1, preEnd);

        return node;
    }


}
