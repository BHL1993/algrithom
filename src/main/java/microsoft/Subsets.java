package microsoft;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
public class Subsets {
    public static void main(String[] args) {
        System.out.println(new Subsets().subsets1(new int[]{1, 2, 3}, 2));
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
        System.out.println(new Subsets().subsets2(new int[]{1, 2, 3}));
    }

    /**
     * bfs
     * 每遍历一个元素，在原有结果集中的每个结果基础之上，追加上当前元素，再并入最终结果集
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }

        return res;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        res.add(list);
        dfs(nums, res, 0, list);

        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int i, List<Integer> list) {
        if (i == nums.length) {
            return;
        }
        list = new ArrayList<>(list);

        dfs(nums, res, i + 1, list);

        list.add(nums[i]);

        res.add(list);

        dfs(nums, res, i + 1, list);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int k = 0;
        while (k <= nums.length) {
            Deque<Integer> list = new ArrayDeque<>();
            dfs(nums, res, list, 0, k);
            k++;
        }
        return res;

    }

    public List<List<Integer>> subsets1(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> list = new ArrayDeque<>();
        dfs(nums, res, list, 0, k);


        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> list, int start, int k) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, res, list, i + 1, k);
            list.pollLast();
        }
    }
}
