package microsoft;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 * 
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * 
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * 
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * 
 * 输入：x = 0
 * 输出：0
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/11 3:52 下午
 */
public class ReverseInt {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        if (x > 0) {
            return reversePositive(x);
        } else {
            return reverseNegative(x);
        }
    }

    public static void main(String[] args) {
        ReverseInt reverseInt = new ReverseInt();
        System.out.println(reverseInt.reverse(432));
    }

    private int reverseNegative(int x) {
        String minString = Integer.toString(Integer.MIN_VALUE);
        StringBuilder sb = new StringBuilder();
        int a;

        while (x < 0) {
            a = -1 * (x % 10);
            x = x / 10;
            sb.append(a);

            if (sb.length() >= 10) {
                if (over(sb, minString.substring(1))) {
                    return 0;
                }
            }
        }
        return Integer.parseInt(sb.toString()) * -1;
    }

    private int reversePositive(int x) {
        String maxString = Integer.toString(Integer.MAX_VALUE);
        StringBuilder sb = new StringBuilder();
        int a;
        while (x > 0) {
            a = x % 10;
            x = x / 10;
            sb.append(a);
            if (sb.length() >= 10) {
                if (over(sb, maxString)) {
                    return 0;
                }
            }
        }
        return Integer.parseInt(sb.toString());
    }

    private boolean over(StringBuilder sb, String maxString) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) > maxString.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
