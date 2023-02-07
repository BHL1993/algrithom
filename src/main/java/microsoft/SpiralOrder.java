package microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * <p>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/4 6:29 下午
 */
public class SpiralOrder {
    public static void main(String[] args) {
        System.out.println(new SpiralOrder().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        spiral(matrix, res, 0, 0, matrix.length - 1, matrix[0].length - 1);
        return res;
    }

    private void spiral(int[][] matrix, List<Integer> res, int top, int left, int bottom, int right) {
        if (top > bottom || left > right) {
            return;
        }

        int tmp = left;
        while (tmp <= right) {
            res.add(matrix[top][tmp++]);
        }

        tmp = top + 1;
        while (tmp <= bottom) {
            res.add(matrix[tmp++][right]);
        }

        tmp = right - 1;
        while (bottom>= top + 1 && tmp >= left) {
            res.add(matrix[bottom][tmp--]);
        }

        tmp = bottom - 1;
        while (left <= right -1 && tmp > top ) {
            res.add(matrix[tmp--][left]);
        }

        spiral(matrix, res, top + 1, left + 1, bottom - 1, right - 1);
    }
}
