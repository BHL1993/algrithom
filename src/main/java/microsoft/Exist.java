package microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词搜索
 * <p>
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/8 9:09 下午
 */
public class Exist {
    public static void main(String[] args) {
        System.out.println(new Exist().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(new Exist().exist(new char[][]{{'a'}}, "a"));
        System.out.println(new Exist().exist(new char[][]{{'A', 'B', 'A'}, {'L', 'F', 'L'}, {'X', 'L', 'Z'}}, "FBA"));
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];

        int m = board.length;
        int n = board[0].length;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean f = dfs(board, used, i, j, word, res, m, n, sb);
                    if (f) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] used, int i, int j, String word, List<String> res, int m, int n, StringBuilder sb) {
        if (sb.length() == word.length()) {
            return true;
        }

        if (i == m || j == n || i < 0 || j < 0 || used[i][j]) {
            return false;
        }

        if (word.charAt(sb.length()) == board[i][j] && !used[i][j]) {
            sb.append(board[i][j]);
            used[i][j] = true;


            if (dfs(board, used, i + 1, j, word, res, m, n, sb)) return true;
            if (dfs(board, used, i - 1, j, word, res, m, n, sb)) return true;
            if (dfs(board, used, i, j + 1, word, res, m, n, sb)) return true;
            if (dfs(board, used, i, j - 1, word, res, m, n, sb)) return true;

            used[i][j] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
        return false;
    }


    private void dfs1(char[][] board, boolean[][] used, int i, int j, String word, List<String> res, int m, int n, StringBuilder sb) {
        if (i == m || j == n || i < 0 || j < 0) {
            return;
        }

        if (sb.length() == word.length()) {
            res.add(sb.toString());
            return;
        }

        if (!used[i][j]) {
            sb.append(board[i][j]);
            used[i][j] = true;

            dfs1(board, used, i + 1, j, word, res, m, n, sb);
            dfs1(board, used, i - 1, j, word, res, m, n, sb);
            dfs1(board, used, i, j + 1, word, res, m, n, sb);
            dfs1(board, used, i, j - 1, word, res, m, n, sb);

            used[i][j] = false;
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
