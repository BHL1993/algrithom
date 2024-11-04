package microsoft;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 乘积最大子数组
 * <p>
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * 子数组 是数组的连续子序列。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数\
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/3/13 4:13 下午
 */
public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct1(new int[]{1, 2, 3}));
        System.out.println(new MaxProduct().maxProduct(new int[]{1, -2, 3}));
    }

    public List<List<Integer>> maxProduct3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> list = new LinkedList<>();
        dfs(nums, res, list, 0);
        return res;
    }
    public List<List<Integer>> maxProduct1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, res, list, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> list, int level) {
        list.add(nums[level]);
        res.add(new ArrayList<>(list));


    }
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, int level) {
        if (level == nums.length) {
            return;
        }

        List<Integer> tmp = new ArrayList<>(list);
        dfs(nums, res, tmp, level + 1);

        tmp.add(nums[level]);
        res.add(tmp);

        dfs(nums, res, tmp, level + 1);
    }

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 1;
            for (int j = i; j < nums.length; j++) {
                tmp = tmp * nums[j];
                res = Math.max(tmp, res);
            }
        }

        return res;
    }

    public int maxProduct2(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }


}
