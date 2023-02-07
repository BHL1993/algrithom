package treenode;

/**
 * 二叉搜索树的第k大节点
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/18 4:07 下午
 */
public class KthLargest {

    public int count;
    public int ans;

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode root, int k) {
        if(root == null || count==k){
            return;
        }

        dfs(root.right, k);

        if (++count == k) {
            ans = root.val;
            return;
        }

        dfs(root.left, k);
    }
}
