package treenode;

/**
 * 二叉树中第二小的节点
 * 
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * 
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/17 1:36 下午
 */
public class FindSecondMinimumValue {

    int min;
    int secondMin = -1;

    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;

        dfs(root);

        return secondMin;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if(root.val > min){
            if(secondMin == -1 || secondMin > root.val){
                secondMin = root.val;
            }
        }

        dfs(root.left);
        dfs(root.right);
    }
}
