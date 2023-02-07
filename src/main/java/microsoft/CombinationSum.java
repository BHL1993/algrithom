package microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 * 
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * 
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 * 
 * 
 * 
 * 示例1：
 * 
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 
 * 
 * 示例2：
 * 
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 
 * 
 * 示例 3：
 * 
 * 输入: candidates = [2], target = 1
 * 输出: []
 * 
 * 
 * 提示：
 * 
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/30 3:09 下午
 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    /**
     * 回溯法
     *
     * target依次减去candidates中的每个数
     * 当差值=0时，保存结果
     * 当差值<0时，终止搜索
     * 当差值>0时，重复执行以上操作，target变为target - candidates[i]
     *
     * 重复结果的原因：
     *      每次遍历candidates的时候，都是从第1个数开始，导致存在重复解
     * 重复结果的处理：
     *      记录当前搜索的位置，下一轮搜索的时候，需要从当前位置开始，而不是从0开始
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        combine(res, 0,candidates, target, list);
        return res;
    }

    private void combine(List<List<Integer>> res, int begin,int[] candidates, int target, List<Integer> list) {
        for (int i = begin; i < candidates.length; i++) {
            if (target == candidates[i]) {
                List<Integer> list1 = new ArrayList<>(list);
                list1.add(candidates[i]);
                res.add(list1);
                break;
            } else if (target > candidates[i]) {
                List<Integer> list1 = new ArrayList<>(list);
                list1.add(candidates[i]);
                combine(res, i,candidates, target - candidates[i], new ArrayList<>(list1));
            } else {
                break;
            }
        }
    }
}
