package microsoft;

/**
 * 平方根
 * 
 * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
 * 
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/29 2:33 下午
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println(new Sqrt().sqrt(3));
    }

    public int sqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int low = 1;
        int high = x;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (x / mid == mid) {
                return mid;
            } else if (x / mid > mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low - 1;
    }
}
