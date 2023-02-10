package microsoft;

import javax.swing.*;
import java.util.*;

/**
 * 组合
 * 
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 
 * 你可以按 任何顺序 返回答案。
 * 
 * 
 * 示例 1：
 * 输入：n = 4, k = 2
 * 
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * 
 * 
 * 提示：
 * 
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/8 5:16 下午
 */
public class Combine {
    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        Deque<Integer> list = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, list, n, k, 1);
        return res;
    }

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
