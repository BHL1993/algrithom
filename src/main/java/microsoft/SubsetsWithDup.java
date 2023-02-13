package microsoft;

import java.util.*;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/11 6:07 下午
 */
public class SubsetsWithDup {
    public static void main(String[] args) {
        System.out.println(new SubsetsWithDup().subsetsWithDup(new int[]{1, 2, 2}));
    }

    //https://programmercarl.com/0078.%E5%AD%90%E9%9B%86.html#%E5%9B%9E%E6%BA%AF%E4%B8%89%E9%83%A8%E6%9B%B2

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> list = new LinkedList<>();
        boolean[] onPath = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(res, list, onPath, nums, 0);
        return res;
    }

    /**
     * 与 【子集】Subsets 问题类似，区别是输入集nums中存在重复元素
     * 使用used数组，标识第i个元素有没有在当前路径中使用过。
     * 在树的同一层级的遍历过程中，如果nums[i]与nums[i-1]相等，且num[i - 1]没有被使用过，则代表在该层级的遍历过程中，num[i - 1]已经被使用过，本次待加入临时结果集的num[i]则无需再次处理。
     * 由于回溯递归调用结束后，需要进行状态回撤，如果nums[i]与nums[i-1]相等，且num[i - 1]被使用过，即num[i - 1]为true，那么代表当前nums[i]与nums[i - 1]属于同一个路径的不同层级，需要继续处理num[i]。
     * Tips：首先需要将nums排序，才可以在遍历过程中通过nums[i]与nums[i-1]是否相等，过滤重复结果。
     */
    private void dfs(List<List<Integer>> res, Deque<Integer> list, boolean[] onPath, int[] nums, int start) {
        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !onPath[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            onPath[i] = true;

            dfs(res, list, onPath, nums, i + 1);

            list.pollLast();
            onPath[i] = false;
        }
    }


}
