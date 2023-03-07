package microsoft;

import java.util.*;

/**
 * 分割回文串 II
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * <p>
 * 返回符合要求的 最少分割次数 。
 * <p>
 * 示例 1：
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * <p>
 * 示例 2：
 * 输入：s = "a"
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：s = "ab"
 * 输出：1
 * <p>
 * 提示：
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/3/6 5:03 下午
 */
public class MinCut {

    public static void main(String[] args) {
        System.out.println(new MinCut().minCut("aaabaa"));
    }

    public int minCut2(String s) {
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

        int[] f = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[s.length() - 1];
    }

    public int minCut(String s) {
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

        int n = s.length();
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);

        //f[m]代表S[0]到S[m]字符串切割成回文串所需最小切割次数
        //如果dp[i][m] 为true，f[m]为f[i - 1] + 1 与 f[m]最小值
        for (int i = 0; i < n; ++i) {
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (dp[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n - 1];
    }

    public int minCut1(String s) {
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

        int resMin = Integer.MAX_VALUE;
        for (List<String> tmp : res) {
            resMin = Math.min(resMin, tmp.size());
        }

        return resMin - 1;
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
}
