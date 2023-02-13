package microsoft;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * <p>
 * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/8 7:29 下午
 */
public class Subsets1 {

    public static void main(String[] args) {
        System.out.println(new Subsets1().subsetsInorder(new int[]{1, 2, 3}));
        System.out.println(new Subsets1().subsetsPreOrder(new int[]{1, 2, 3}));
        System.out.println(new Subsets1().subsetsPostOrder(new int[]{1, 2, 3}));
        System.out.println(new Subsets1().subsets(new int[]{1, 2, 3}));
    }

    /**
     * https://programmercarl.com/0078.%E5%AD%90%E9%9B%86.html#%E5%9B%9E%E6%BA%AF%E4%B8%89%E9%83%A8%E6%9B%B2
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> list = new LinkedList<>();
        dfs(res, list, nums, 0);
        return res;
    }

    /**
     * nums中每个元素都不相等
     *
     * 将遍历过程抽象成一颗树，每个父节点的子节点为 父节点表示的数组元素后的每一个元素。该子集问题就是找树的所有节点。
     * 使用list维护临时结果集，循环初始首先将list加入结果集。
     * 再使用for循环，从start位置开始，依次将start位置后的每个元素 i 加入临时结果集，再执行递归调用。
     * 递归调用执行结束后，需要将 i 从结果集中移除，以执行下一次for循环，即将 i + 1 元素加入结果集，并继续递归执行
     *
     * 从第i个元素，依次向后遍历，将i后的每个元素加入结果集。每将一个元素加入结果集后，递归调用
     */
    private void dfs(List<List<Integer>> res, Deque<Integer> list, int[] nums, int start) {
        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(res, list, nums, i + 1);
            list.pollLast();
        }
    }


    /**
     * 遍历每个元素，每个元素有 选中、不选中 两种选择
     * 可以构建成一颗满二叉树，左节点为选中，右节点为不选中
     * 通过二叉树的遍历，获得最终结果
     * 前序、中序、后序
     */
    public List<List<Integer>> subsetsPostOrder(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        postOrder(res, list, nums, 0);
        return res;
    }

    public List<List<Integer>> subsetsInorder(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        List<Integer> list = new ArrayList<>();
        inOrder(res, list, nums, 0);
        return res;
    }

    public List<List<Integer>> subsetsPreOrder(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        preOrder(res, list, nums, 0);
        return res;
    }

    private void preOrder(List<List<Integer>> res, List<Integer> list, int[] nums, int k) {
        if (k == nums.length) {
            return;
        }

        list = new ArrayList<>(list);

        res.add(list);

        preOrder(res, list, nums, k + 1);

        list.add(nums[k]);

        preOrder(res, list, nums, k + 1);
    }

    private void inOrder(List<List<Integer>> res, List<Integer> list, int[] nums, int k) {
        if (k == nums.length) {
            return;
        }

        list = new ArrayList<>(list);

        inOrder(res, list, nums, k + 1);

        res.add(list);

        list.add(nums[k]);
        inOrder(res, list, nums, k + 1);
    }

    private void postOrder(List<List<Integer>> res, List<Integer> list, int[] nums, int k) {
        if (k == nums.length) {
            return;
        }

        list = new ArrayList<>(list);

        postOrder(res, list, nums, k + 1);

        list.add(nums[k]);

        postOrder(res, list, nums, k + 1);

        res.add(list);
    }

}
