package treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * 
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/15 6:31 下午
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        StringBuilder sb = new StringBuilder();
        path(ret, root, sb);
        return ret;
    }

    private void path(List<String> ret, TreeNode root, StringBuilder sb) {
        StringBuilder tmp = new StringBuilder(sb);
        if (root.left == null && root.right == null) {
            tmp.append(root.val);
            ret.add(tmp.toString());
        } else {
            tmp.append(root.val).append("->");
            if (null != root.left) {
                path(ret, root.left, new StringBuilder(tmp));
            }
            if (null != root.right) {
                path(ret, root.right, new StringBuilder(tmp));
            }
        }
    }
}
