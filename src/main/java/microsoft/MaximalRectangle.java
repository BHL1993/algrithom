package microsoft;

/**
 * 最大矩形
 * <p>
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 输入：matrix = [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]]
 * 输出：6
 * <p>
 * 示例 2：
 * 输入：matrix = []
 * 输出：0
 * <p>
 * <p>
 * 示例 3：
 * 输入：matrix = [["0"]]
 * 输出：0
 * <p>
 * <p>
 * 示例 4：
 * 输入：matrix = [["1"]]
 * 输出：1
 * <p>
 * <p>
 * 示例 5：
 * 输入：matrix = [["0","0"]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * rows == matrix.length
 * cols == matrix[0].length
 * 1 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/10 3:36 下午
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        System.out.println(new MaximalRectangle().maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }

    /**
     * 套用 LargestRectangleArea 最大矩形面积求解思路
     *
     * 以matrix每一行为底，每一列上存在连续的1，则该高度为连续1的和。如果matrix[i][j] == '0'，则代表该列柱子高度0
     * 依次将新的二位数组中的每一行，作为 LargestRectangleArea 的入参，得到题解。
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] arr = new int[m][n];
        for (int i = 0; i < n; i++) {
            arr[0][i] = matrix[0][i] - '0';
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    arr[i][j] = arr[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int tmp = largestRectangleArea(arr[i]);
            res = Math.max(tmp,res);
        }

        return res;
    }


    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int n = heights.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        leftMin[0] = -1;
        rightMin[n - 1] = n;

        for (int i = 1; i < n; i++) {
            int tmp = i - 1;
            while (tmp >= 0 && heights[tmp] >= heights[i]) {
                tmp = leftMin[tmp];
            }
            leftMin[i] = tmp;
        }

        for (int i = n - 2; i >= 0; i--) {
            int tmp = i + 1;
            while (tmp < n && heights[tmp] >= heights[i]) {
                tmp = rightMin[tmp];
            }
            rightMin[i] = tmp;
        }

        for (int i = 0; i < n; i++) {
            res = Math.max(res, (rightMin[i] - leftMin[i] - 1) * heights[i]);
        }
        return res;
    }
}
