package microsoft;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * N皇后
 *
 * 回溯法
 *
 * 构建n * n矩阵，当遍历到第depth层时，将可用的num[depth][i]添加到路径中（num[depth][i] == 0），并更新不可用的元素（nums数值+1），继续递归。
 * 递归结束后，恢复num[depth][i]状态（nums数值-1）.
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/4 3:16 下午
 */
public class SolveNQueens {
    public static void main(String[] args) {
        System.out.println(new SolveNQueens().solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        Deque<String> list = new LinkedList<>();

        int[][] nums = new int[n][n];

        dfs(res, list, n, 0, nums);

        List<List<String>> ans = assemble(res, n);
        return ans;
    }

    private List<List<String>> assemble(List<List<String>> res, int n) {
        List<List<String>> ans = new ArrayList<>();
        for (List<String> list : res) {
            List<String> r = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                String t = list.get(i);
                for (int j = 0; j < n; j++) {
                    if (t.equals(j + "")) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                r.add(sb.toString());
            }
            ans.add(r);
        }
        return ans;
    }

    private void dfs(List<List<String>> res, Deque<String> list, int n, int depth, int[][] nums) {
        if (depth == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (nums[depth][i] == 0) {
                list.add(i + "");
                List<Pairs> pairsList = getPairsList(depth, i, n);
                fillNums(pairsList, 1, nums);

                dfs(res, list, n, depth + 1, nums);

                fillNums(pairsList, -1, nums);
                list.pollLast();
            }
        }
    }

    private void fillNums(List<Pairs> pairsList, int i, int[][] nums) {
        for (Pairs pairs : pairsList) {
            nums[pairs.getX()][pairs.getY()] += i;
        }
    }

    private List<Pairs> getPairsList(int x, int y, int n) {
        List<Pairs> res = new ArrayList<>();
        for (int i = x; i < n; i++) {
            res.add(new Pairs(i, y));
        }

        for (int i = y + 1; i < n; i++) {
            res.add(new Pairs(x, i));
        }

        int i = x + 1;
        int j = y + 1;
        while (i < n && j < n) {
            res.add(new Pairs(i++, j++));
        }

        i = x + 1;
        j = y - 1;
        while (i < n && j >= 0) {
            res.add(new Pairs(i++, j--));
        }
        return res;
    }

    static class Pairs {
        private int x;
        private int y;

        public Pairs(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }
}
