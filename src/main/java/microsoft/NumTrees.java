package microsoft;

/**
 * 不同的二叉搜索树
 * <p>
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/13 9:19 下午
 */
public class NumTrees {
    public static void main(String[] args) {
        System.out.println(new NumTrees().numTrees(3));
    }


    /**
     * f(0) = 1
     * f(1) = 1
     * f(2) = f(0)*f(1) + f(1)* f(0)
     * f(3) = f(0)*f(2) + f(1)*f(1) + f(2)*f(0)
     * f(4) = f(0)*f(3) + f(1)*f(2) +  f(2)*f(1) + f(3)*f(0)
     * ...
     * f(n) = f(0)*f(n-1) + f(1)*f(n-2) + ... + f(n-1)*f(0)
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        return dp[n];
    }

    public int numTrees1(int n) {
        return nums(1, n);
    }

    private int nums(int start, int end) {
        int res = 0;

        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }

        for (int i = start; i <= end; i++) {
            int leftNum = nums(start, i - 1);
            int rightNum = nums(i + 1, end);

            if (leftNum == 0) {
                res += rightNum;
            } else if (rightNum == 0) {
                res += leftNum;
            } else {
                res += leftNum * rightNum;
            }
        }

        return res;
    }
}
