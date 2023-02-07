package treenode;

/**
 * 不同的二叉搜索树
 * 
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/20 3:25 下午
 */
public class NumTrees {
    /**
     * 题解为：1为根时的二叉搜索树数目 + 2为根时的二叉搜索树数目 + ... + n为根时的二叉搜索树数目
     *
     * 定义：
     * 1.G(n): 长度为 n 的序列能构成的不同二叉搜索树的个数。
     * 2.F(i,n): 以 i 为根、序列长度为 n 的不同二叉搜索树个数 (1≤i≤n)。
     * 则 G(n) = F(1,n) + F(2,n) + ... + F(n,n);
     * 而 F(i,n) = G(i-1) * G(n-i)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += (dp[j - 1] * dp[i - j]);
            }
            dp[i] = sum;
        }

        return dp[n];
    }



    public int numTrees1(int n) {
        return num(1, n);
    }

    private int num(int start, int end) {
        if (start >= end) {
            return 1;
        }

        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += (num(start, i - 1) * num(i + 1, end));
        }
        return sum;
    }
}
