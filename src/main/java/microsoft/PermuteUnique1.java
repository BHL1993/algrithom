package microsoft;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/2 10:57 上午
 */
public class PermuteUnique1 {
    public static void main(String[] args) {
        System.out.println(new PermuteUnique1().permuteUnique(new int[]{1, 1, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> list = new ArrayDeque<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(res, list, nums, used, 0);
        return res;
    }

    /**
     * 排列与子集的区别
     *
     * 排列的结果集需要将每个元素都加入结果集中，即对应树中的完整链路
     * 而子集的结果集是从根节点到每个子节点的链路
     *
     * 因此子集的dfs中，需要每一次的遍历都将临时结果加入最终结果集中
     * 而排列的dfs中，只有当所有元素都遍历后，才将临时结果加入最终结果集中
     *
     */
    private void dfs(List<List<Integer>> res, Deque<Integer> list, int[] nums, boolean[] used, int level) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
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

            dfs(res, list, nums, used, level + 1);

            list.pollLast();
            used[i] = false;
        }
    }
}
