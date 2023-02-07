package microsoft;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/2/4 8:34 下午
 */
public class Rotate1 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        new Rotate1().rotate(matrix);
        System.out.println("");
    }


    public void rotate(int[][] matrix) {
        rotateImage(matrix, 0, 0, matrix.length - 1, matrix.length - 1);
    }

    private void rotateImage(int[][] matrix, int top, int left, int bottom, int right) {
        if (top > bottom || left > right) {
            return;
        }

        int diff = right - left;
        for (int i = 0; i < diff; i++) {
            int tmp = matrix[top][left + i];
            matrix[top][left + i] = matrix[bottom - i][left];
            matrix[bottom - i][left] = matrix[bottom][right - i];
            matrix[bottom][right - i] = matrix[top + i][right];
            matrix[top + i][right] = tmp;
        }

        rotateImage(matrix, top + 1, left + 1, bottom - 1, right - 1);
    }
}
