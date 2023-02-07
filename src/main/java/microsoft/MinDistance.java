package microsoft;

/**
 * 编辑距离
 * <p>
 * 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 示例1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * 示例2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 提示：
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/7 1:51 下午
 */
public class MinDistance {
    public static void main(String[] args) {
        System.out.println(new MinDistance().minDistance("horse", "ros"));
        System.out.println(new MinDistance().minDistance1("horse", "ros"));
    }

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];
    }

    /**
     * dp[i][j]表示从S1的(0,i)的子串转换为S2的(0,j)的子串需要的最少操作数
     * dp[i][j] 怎么来？
     *
     * 1、dp[i-1][j-1]：
     * 2、dp[i-1][j]
     * 3、dp[i][j-1]
     *
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance1(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        int tmp = 1;
        while (tmp < n) {
            dp[0][tmp] = tmp;
            tmp++;
        }

        tmp = 1;
        while (tmp < m) {
            dp[tmp][0] = tmp;
            tmp++;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j-1]) + 1;
            }
        }

        return dp[m][n];

    }
}
