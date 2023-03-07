package microsoft;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 分割回文串
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/3/6 3:47 下午
 */
public class PartitionI {
    public static void main(String[] args) {
        System.out.println(new PartitionI().partition1("aab"));
    }


    public List<List<String>> partition1(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = true;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        Deque<String> list = new LinkedList<>();
        dfs1(res, list, s, dp, 0);
        return res;
    }

    private void dfs1(List<List<String>> res, Deque<String> list, String s, boolean[][] dp, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                list.add(s.substring(start, i + 1));
                dfs1(res, list, s, dp, i + 1);
                list.pollLast();
            }
        }
    }

    /**
     * 回溯 + 回文串判断
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Deque<String> list = new LinkedList<>();
        dfs(res, list, s, 0);
        return res;
    }

    private void dfs(List<List<String>> res, Deque<String> list, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isHuiWen(s, start, i)) {
                list.add(s.substring(start, i + 1));
                dfs(res, list, s, i + 1);
                list.pollLast();
            }
        }
    }

    private boolean isHuiWen(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
