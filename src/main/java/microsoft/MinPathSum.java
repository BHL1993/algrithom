package microsoft;

/**
 * 最小路径和
 * <p>
 * <p>
 * <p>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/7 12:52 下午
 */
public class MinPathSum {
    public static void main(String[] args) {
        int i = new MinPathSum().minPathSum1(new int[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println(i);
    }

    public int minPathSum(int[][] grid) {
        MyInteger myInteger = new MyInteger(Integer.MAX_VALUE);

        dfs(grid, 0, 0, grid.length, grid[0].length, 0, myInteger);
        return myInteger.getCnt();
    }

    private void dfs(int[][] grid, int x, int y, int lenX, int lenY, int sum, MyInteger myInteger) {
        if (x == lenX || y == lenY) {
            return;
        }

        if (x == lenX - 1 && y == lenY - 1) {
            myInteger.setCnt(Math.min(myInteger.getCnt(), sum + grid[x][y]));
            return;
        }

        dfs(grid, x + 1, y, lenX, lenY, sum + grid[x][y], myInteger);
        dfs(grid, x, y + 1, lenX, lenY, sum + grid[x][y], myInteger);
    }

    public static class MyInteger {
        int cnt;

        public MyInteger(int cnt) {
            this.cnt = cnt;
        }

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }

    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[i][j] = grid[i][j];
                    } else {
                        dp[i][j] = grid[i][j] + dp[i][j - 1];
                    }
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
