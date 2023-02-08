package microsoft;

/**
 * 搜索二维矩阵
 * <p>
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/7 8:43 下午
 */
public class SearchMatrix {
    public static void main(String[] args) {
        System.out.println(new SearchMatrix().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},3));
        System.out.println(new SearchMatrix().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},13));
        System.out.println(new SearchMatrix().searchMatrix(new int[][]{{1}}, 2));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0]) {
            return false;
        }

        int row = -1;
        int pre = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            if (pre <= target && target < matrix[i][0]) {
                row = i - 1;
                break;
            } else {
                pre = matrix[i][0];
            }
        }

        if (row == -1) {
            row = matrix.length - 1;
        }

        int low = 0;
        int high = matrix[0].length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;

    }
}
