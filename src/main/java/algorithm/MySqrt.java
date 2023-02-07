package algorithm;

/**
 * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
 * 
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * @author ：BaiHailong
 * @date ：Created in 2022/9/5 8:17 下午
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }

        int low = 0;
        int high = x;
        while (low < high - 1) {
            int mid = (high + low) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid > mid) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
