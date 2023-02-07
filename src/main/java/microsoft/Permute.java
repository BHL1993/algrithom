package microsoft;

import java.util.*;

/**
 * 全排列
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/1 8:06 下午
 */
public class Permute {
    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();

        boolean[] used = new boolean[nums.length];
        //dfs(nums, res, list, 0, used);
        dfs2(nums, res, list, 0);
        return res;

    }

    private void dfs(int[] nums, List<List<Integer>> res, LinkedList<Integer> list, int n, boolean[] used) {
        if (n == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                dfs(nums, res, list, n + 1, used);
                list.pollLast();
                used[i] = false;
            }
        }
    }

    private void dfs1(int[] nums, List<List<Integer>> res, LinkedList<Integer> list, int depth) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs1(nums, res, list, depth + 1);
                list.pollLast();
            }
        }
    }

    private void dfs2(int[] nums, List<List<Integer>> res, LinkedList<Integer> list, int depth) {
        if (depth == nums.length -1) {
            for (int i = 0; i < nums.length; i++) {
                if (!list.contains(nums[i])) {
                    ArrayList<Integer> tmp = new ArrayList<>(list);
                    tmp.add(nums[i]);
                    res.add(tmp);
                }
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs2(nums, res, list, depth + 1);
                list.pollLast();
            }
        }
    }
}
