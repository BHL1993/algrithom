package microsoft;

import java.util.Arrays;

/**
 * 旋转图像
 * 
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 
 * 
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * 
 * 提示：
 * 
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/2 7:51 下午
 */
public class Rotate {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        new Rotate().rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        int low = 0;
        int high = matrix.length - 1;


        while (low < high) {
            int p1 = low;
            int p2 = high;

            while (p1 < high) {
                int tmp = matrix[low][p1];

                matrix[low][p1] = matrix[p2][low];
                matrix[p2][low] = matrix[high][p2];
                matrix[high][p2] = matrix[p1][high];
                matrix[p1][high] = tmp;

                p1++;
                p2--;
            }
            low++;
            high--;
        }
    }

    private void rotateLevel(int[][] matrix, int level, int len) {
        for (int j = level; j < len - level - 1; j++) {
            int tmp = matrix[j][len - 1];
            matrix[j][len - 1] = matrix[j][j];


        }
    }
}
