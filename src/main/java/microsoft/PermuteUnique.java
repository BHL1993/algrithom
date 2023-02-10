package microsoft;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 
 * 
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 
 * 示例 2：
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 提示：
 * 
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/2 10:57 上午
 */
public class PermuteUnique {
    public static void main(String[] args) {
        System.out.println(new PermuteUnique().permuteUnique(new int[]{1, 1, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> list = new ArrayDeque<>();

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        dfs(res, list, nums, used, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> list, int[] nums, boolean[] used, int depth) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            used[i] = true;

            dfs(res, list, nums, used, depth + 1);

            list.pollLast();
            used[i] = false;
        }
    }
}
