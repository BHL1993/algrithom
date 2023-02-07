package treenode;

/**
 * 将有序数组转换为二叉搜索树
 * 
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/14 2:21 下午
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        TreeNode root = new TreeNode();
        getSpecifiedNode(root, nums, l, r);
        return root;
    }

    private void getSpecifiedNode(TreeNode root, int[] nums, int l, int r) {
        int m = (l + r) / 2;
        root.val = nums[m];
        if (l <= m - 1) {
            root.left = new TreeNode();
            getSpecifiedNode(root.left, nums, l, m - 1);
        }
        if (m + 1 <= r) {
            root.right = new TreeNode();
            getSpecifiedNode(root.right, nums, m + 1, r);
        }
    }

    private TreeNode getRoot(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int m = (l + r) / 2;
        TreeNode treeNode = new TreeNode(nums[m]);
        treeNode.left = getRoot(nums, l, m - 1);
        treeNode.right = getRoot(nums, m + 1, r);
        return treeNode;
    }
}
