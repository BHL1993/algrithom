package microsoft;

import treenode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder和inorder均 无重复 元素
 * inorder均出现在preorder
 * preorder保证 为二叉树的前序遍历序列
 * inorder保证 为二叉树的中序遍历序列
 */
public class BuildTree {
    private Map<Integer, Integer> positionMap = new HashMap<>();

    /**
     * 前序数组：[根节点, [左子树的前序数组], [右子树的前序数组]]
     * 中序数组：[[左子树的中序数组], 根节点, [右子树的中序数组]]
     *
     * 1、前序数组 中的第一个元素即为 根节点
     * 2、找到 根节点 在 中序数组 中的位置
     * 3、确定 左子树的前序数组 以及 左子树的中序数组 分别在 前序数组 以及 中序数组 中的位置范围，即可递归构造出当前根节点的左子树
     *      由于 根节点 在 中序数组 中的位置已知为 i，则，左子树的中序数组 在 中序数组 中的位置范围为[inorder_left, i - 1]；
     *      而 左子树的前序数组 和 左子树的中序数组 的数组长度一致，所以 左子树的前序数组 在 前序数组 中的位置范围为[preorder_left + 1, preorder_left + (i - inorder_left)]；
     * 4、右子树步骤 同3
     * 5、递归终止条件：preOrder_left > preOrder_right || inorder_left > inorder_right
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            positionMap.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preOrder_left, int preOrder_right, int inorder_left, int inorder_right) {

        if (preOrder_left > preOrder_right || inorder_left > inorder_right) {
            return null;
        }

        int val = preorder[preOrder_left];
        TreeNode root = new TreeNode(val);


        int inOrderPosition = positionMap.get(val);
        int count_left = inOrderPosition - inorder_left;

        TreeNode left = build(preorder, inorder, preOrder_left + 1, preOrder_left + count_left, inorder_left, inOrderPosition - 1);
        TreeNode right = build(preorder, inorder, preOrder_left + count_left + 1, preOrder_right, inOrderPosition + 1, inorder_right);

        root.left = left;
        root.right = right;

        return root;
    }
}
