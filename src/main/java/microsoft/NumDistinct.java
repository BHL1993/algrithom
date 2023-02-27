package microsoft;

/**
 * 不同的子序列
 * <p>
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * <p>
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * <p>
 * 题目数据保证答案符合 32 位带符号整数范围。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 * 示例 2：
 * <p>
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/25 1:23 下午
 */
public class NumDistinct {
    public static void main(String[] args) {
        System.out.println(new NumDistinct().numDistinct("babgbag","bag"));

    }

    /**
     *
     * 动态规划
     * dp[i][j] 代表 S(0,i) 的子序列在 T(0,j) 中出现的个数
     *
     * 状态转移
     *      如果S(i) == T(j)，则 dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]；
     *          其中，dp[i - 1][j - 1] 代表S、T中分别去除最后一个元素的题解个数，因为S(i) == T(j)，所以S(0, i-1)、T(0, j-1)分别加上最后一个元素后，题解个数不变；
     *           dp[i - 1][j]代表不考虑S(0,i-1)的子序列中包含的T(0,j)的个数。
     *      如果S(i) != T(j)，则dp[i][j] = dp[i-1][j]。即S(0,i-1)的子序列中包含的T(0,j)的个数 就是 S(0,i)的子序列中包含的T(0,j)的个数
     * 遍历方向
     *      因为dp[i][j] 由 dp[i - 1][j - 1] 与 dp[i - 1][j]决定，所以遍历方向为从左往右，从上往下
     * 初始化
     *      dp[i][0]列由于j - 1可能小于0，所以 dp[i][0] 需要单独初始化
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0 || tLen == 0) {
            return 0;
        }

        int[][] dp = new int[sLen][tLen];

        int tmp = 0;
        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) == t.charAt(0)) {
                tmp++;
            }
            dp[i][0] = tmp;
        }


        for (int i = 1; i < sLen; i++) {
            for (int j = 1; j <= i && j < tLen; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[sLen - 1][tLen - 1];
    }
}
