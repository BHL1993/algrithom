package treenode;

import java.util.*;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/30 12:58 下午
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return getString(root, "");
    }

    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        StringBuilder ret = new StringBuilder();
        Stack<TreeNode> queue = new Stack<>();


        while (root != null || !queue.isEmpty()) {
            if (root != null) {
                queue.push(root);
                ret.append(root.val).append(",");
                root = root.left;
            } else {
                ret.append("*").append(",");
                root = queue.pop();
                root = root.right;
            }
        }

        return ret.deleteCharAt(ret.length() - 1).toString();
    }

    public String getString(TreeNode root, String s) {
        if (root == null) {
            return s + "*,";
        }

        s = s + root.val + ",";
        getString(root.left, s);
        getString(root.right, s);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] srr = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(srr));

        return build(list);
    }

    private TreeNode build(List<String> list) {
        if (list.get(0).equals("*")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = build(list);
        root.right = build(list);
        return root;
    }
}
