package microsoft;

/**
 * 被围绕的区域
 * <p>
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 */
public class Solve {

    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        char[][] arr1 = new char[][]{
                {'X', 'O', 'X', 'X'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'}};
        char[][] arr2 = new char[][]{
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}};

        char[][] arr3 = new char[][]{
                {'X', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X'},
                {'O', 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'X', 'O'},
                {'X', 'X', 'O', 'X', 'X', 'O', 'X', 'O', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O'},
                {'X', 'X', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O'}
        };
        new Solve().solve(arr3);
        System.out.println("");
    }

    /**
     * 依次从每个边的字符O开始遍历，使用dfs，将相连的O置为-
     * 再次遍历全数组，将O变为X，将-变为O
     */
    public void solve(char[][] board) {
        int rowNum = board.length;
        int colNum = board[0].length;

        for (int i = 0; i < rowNum; i++) {
            dfs(board, i, 0, rowNum, colNum);
            dfs(board, i, colNum - 1, rowNum, colNum);
        }

        for (int i = 1; i < colNum - 1; i++) {
            dfs(board, 0, i, rowNum, colNum);
            dfs(board, rowNum - 1, i, rowNum, colNum);
        }

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int rowNum, int colNum) {
        if (i < 0 || i >= rowNum || j < 0 || j >= colNum) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '-';

            dfs(board, i + 1, j, rowNum, colNum);
            dfs(board, i - 1, j, rowNum, colNum);
            dfs(board, i, j - 1, rowNum, colNum);
            dfs(board, i, j + 1, rowNum, colNum);
        }
    }

    public void solve1(char[][] board) {
        boolean[][] solved1 = new boolean[board.length][board[0].length];
        boolean[][] solved2 = new boolean[board.length][board[0].length];

        fill1(solved1, board);
        fill2(solved2, board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !solved1[i][j] && !solved2[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

        System.out.println("");
    }

    private void fill2(boolean[][] solved1, char[][] board) {
        for (int i = board.length - 1; i >= 0; i--) {
            solved1[i][board[0].length - 1] = board[i][board[0].length - 1] == 'O';
        }

        for (int i = board[0].length - 1; i >= 0; i--) {
            solved1[board.length - 1][i] = board[board.length - 1][i] == 'O';
        }

        for (int i = board.length - 2; i >= 0; i--) {
            for (int j = board[0].length - 2; j >= 0; j--) {
                solved1[i][j] = (solved1[i + 1][j] && board[i + 1][j] == 'O') || (solved1[i][j + 1] && board[i][j + 1] == 'O');
            }
        }
    }

    private void fill1(boolean[][] solved1, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            solved1[i][0] = board[i][0] == 'O';
        }

        for (int i = 0; i < board[0].length; i++) {
            solved1[0][i] = board[0][i] == 'O';
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                solved1[i][j] = (solved1[i - 1][j] && board[i - 1][j] == 'O') || (solved1[i][j - 1] && board[i][j - 1] == 'O');
            }
        }
    }

    private boolean solved(int i, int j, char[][] board) {
        int index = 0;
        boolean solved = false;
        while (index < j) {
            if (board[i][index++] != 'O') {
                solved = true;
                break;
            }
        }

        if (!solved) {
            return false;
        }

        solved = false;
        index = 0;
        while (index < i) {
            if (board[index++][j] != 'O') {
                solved = true;
                break;
            }
        }

        if (!solved) {
            return false;
        }

        solved = false;
        index = i + 1;
        while (index < board.length) {
            if (board[index++][j] != 'O') {
                solved = true;
                break;
            }
        }

        if (!solved) {
            return false;
        }

        solved = false;
        index = j + 1;
        while (index < board[0].length) {
            if (board[i][index++] != 'O') {
                solved = true;
                break;
            }
        }

        return solved;
    }
}
