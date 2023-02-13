package microsoft;

import java.util.*;

/**
 * 组合
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * 示例 1：
 * 输入：n = 4, k = 2
 * <p>
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/8 5:16 下午
 */
public class Combine1 {
    public static void main(String[] args) {
        System.out.println(new Combine1().combine(3, 3));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> list = new LinkedList<>();
        dfs(res, list, n, k, 1);
        return res;
    }

    /**
     * 区别于 Permute，元素相同的 子集/排列 为同一个组合
     * 因此for循环的初始位置从start开始，而非0开始，达到去重的效果
     * 同时也就无需使用used数组记录当前元素是否使用过
     */
    private void dfs(List<List<Integer>> res, Deque<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);

            dfs(res, list, n, k, i + 1);

            list.pollLast();
        }
    }


}
