package microsoft;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/2/6 4:07 下午
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        new GenerateMatrix().generateMatrix(3);
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        dfs(res, 1, 0, 0, n - 1, n - 1);
        return res;
    }

    private void dfs(int[][] res, int start, int top, int left, int bottom, int right) {
        if (top > bottom || left > right) {
            return;
        }

        int tmp = left;

        while (tmp <= right) {
            res[top][tmp++] = start++;
        }

        tmp = top + 1;
        while (tmp <= bottom) {
            res[tmp++][right] = start++;
        }

        tmp = right - 1;
        while (right >= left + 1 && tmp >= left) {
            res[bottom][tmp--] = start++;
        }

        tmp = bottom - 1;
        while (bottom >= top + 1 && tmp > top) {
            res[tmp--][left] = start++;
        }

        dfs(res, start, top + 1, left + 1, bottom - 1, right - 1);
    }
}
