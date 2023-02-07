package microsoft;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/1/29 6:12 下午
 */
public class LongestValidParentheses2 {
    public static void main(String[] args) {
        new LongestValidParentheses2().longestValidParentheses("dsa");
    }

    public int longestValidParentheses(String s) {
        int res = 0;

        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i >= 2) {
                        dp[i] = dp[i - 2] + dp[i];
                    }
                } else if (dp[i - 1] > 0) {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }

            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
