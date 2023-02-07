package treenode;

/**
 * 最小高度树
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/18 8:35 下午
 */
public class SortedArrayToBST1 {
    public int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        int low = 0, high = nums.length;
        this.nums = nums;

        TreeNode head = new TreeNode();
        to(head, low, high);

        return head;
    }

    private void to(TreeNode head, int low, int high) {
        if (low > high) {
            return;
        }

        int m = low + (high - low) / 2;
        head.val = this.nums[m];

        if (low <= m - 1) {
            TreeNode left = new TreeNode();
            head.left = left;
            to(left, low, m - 1);
        }

        if (m + 1 <= high) {
            TreeNode right = new TreeNode();
            head.right = right;
            to(right, m + 1, high);
        }
    }

    public static void main(String[] args) {
        SortedArrayToBST1 sortedArrayToBST1 = new SortedArrayToBST1();
        sortedArrayToBST1.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
