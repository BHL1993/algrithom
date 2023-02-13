package microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
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
public class Permute1 {
    public static void main(String[] args) {
        System.out.println(new Permute1().permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, res, list, 0, used);
        return res;

    }

    /**
     * 构造抽象树，模拟回溯递归过程
     * level代表当前递归层数，当level等于nums.length时，代表所有元素都已经被遍历过，则将临时结果集list加入最终结果集res。
     * 通过维护used数组，记录nums数组中第i个元素有没有在当前路径中使用过，如果使用过，则跳过该元素。
     */
    private void dfs(int[] nums, List<List<Integer>> res, LinkedList<Integer> list, int level, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            dfs(nums, res, list, level + 1, used);

            used[i] = false;
            list.pollLast();
        }
    }


}
