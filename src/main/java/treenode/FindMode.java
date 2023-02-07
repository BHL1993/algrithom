package treenode;

import java.util.*;

/**
 * 二叉搜索树中的众数
 * 
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 
 * 假定 BST 有如下定义：
 * 
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/15 8:19 下午
 */
public class FindMode {
    private List<Integer> retList = new ArrayList<>();

    int cur = Integer.MIN_VALUE, count, maxCount;

    public int[] findMode(TreeNode root) {
        dfs(root);

        int[] arr = new int[retList.size()];

        for (int i = 0; i < retList.size(); i++) {
            arr[i] = retList.get(i);
        }

        return arr;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);

        update(root.val);

        dfs(root.right);
    }

    private void update(int val) {
        if (val == cur) {
            count++;
        } else if (val > cur) {
            count = 1;
            cur = val;
        }

        if (count > maxCount) {
            retList.clear();
            retList.add(val);
            maxCount = count;
        } else if (count == maxCount) {
            retList.add(val);
        }
    }
}
