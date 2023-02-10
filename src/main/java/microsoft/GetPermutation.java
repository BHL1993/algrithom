package microsoft;

/**
 * 排列序列
 * 
 * 给出集合[1,2,3,...,n]，其所有元素共有n! 种排列。
 * 
 * 按大小顺序列出所有排列情况，并一一标记，当n = 3 时, 所有排列如下：
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定n 和k，返回第k个排列。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：n = 3, k = 3
 * 输出："213"
 * 
 * 示例 2：
 * 
 * 输入：n = 4, k = 9
 * 输出："2314"
 * 示例 3：
 * 
 * 输入：n = 3, k = 1
 * 输出："123"
 * 
 * 
 * 提示：
 * 
 * 1 <= n <= 9
 * 1 <= k <= n!
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/6 7:34 下午
 */
public class GetPermutation {
    public static void main(String[] args) {
        System.out.println(new GetPermutation().getPermutation(4, 1));
    }

    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n];
        StringBuilder sb = new StringBuilder();
        MyInteger myInteger = new MyInteger(0);
        return dfs(used, 0, n, k, sb, myInteger);
    }

    private String dfs(boolean[] used, int depth, int n, int k, StringBuilder sb, MyInteger myInteger) {
        if (depth == n) {
            myInteger.setCnt(myInteger.getCnt() + 1);
            if (myInteger.getCnt() == k) {
                return sb.toString();
            } else {
                return "-1";
            }
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                sb.append(i + 1);

                String re = dfs(used, depth + 1, n, k, sb, myInteger);
                if (!"-1".equals(re)) {
                    return re;
                }

                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return "-1";
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
}
