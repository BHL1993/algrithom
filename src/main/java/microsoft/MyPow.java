package microsoft;

/**
 * Pow(x, n)
 * 实现pow(x, n)，即计算 x 的整数n 次幂函数（即，xn ）。
 * 
 * 示例 1：
 * 
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 
 * 
 * 示例 2：
 * 
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 
 * 
 * 
 * 
 * 示例 3：
 * 
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * 
 * 
 * 提示：
 * 
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n是一个整数
 * -104 <= xn <= 104
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/4 3:05 下午
 */
public class MyPow {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        boolean negative = false;
        if (n < 0) {
            negative = true;
            n = -1 * n;
        }

        double res = quickPow(x, n);
        return negative ? 1 / res : res;
    }

    private double quickPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double y = quickPow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
