package microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num1.length, num2.length <= 200
 * num1和 num2只能由数字组成。
 * num1和 num2都不包含任何前导零，除了数字0本身。
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/1 1:57 下午
 */
public class Multiply {
    public static void main(String[] args) {
        System.out.println(new Multiply().multiply("999", "0"));
    }


    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            String str = getStr(num2.charAt(i) - '0', num1);

            int j = num2.length() - 1;
            while (j > i) {
                str = str + "0";
                j--;
            }

            res = add(res, str);
        }

        return res;
    }

    private String add(String res, String str) {
        StringBuilder sb = new StringBuilder();
        int curry = 0;

        int i = res.length() - 1;
        int j = str.length() - 1;

        while (i >= 0 && j >= 0) {
            int tmp = (res.charAt(i--) - '0') + (str.charAt(j--) - '0') + curry;
            sb.append(tmp % 10);
            curry = tmp / 10;
        }

        while (i >= 0) {
            int tmp = (res.charAt(i--) - '0') + curry;
            sb.append(tmp % 10);
            curry = tmp / 10;
        }

        while (j >= 0) {
            int tmp = (str.charAt(j--) - '0') + curry;
            sb.append(tmp % 10);
            curry = tmp / 10;
        }

        if (curry > 0) {
            sb.append(curry);
        }

        return sb.reverse().toString();
    }


    public String getStr(int n, String num1) {
        StringBuilder sb = new StringBuilder();
        int curry = 0;

        for (int i = num1.length() - 1; i >= 0; i--) {
            int tmp = (num1.charAt(i) - '0') * n + curry;

            sb.append(tmp % 10);
            curry = tmp / 10;
        }

        if (curry > 0) {
            sb.append(curry);
        }

        return sb.reverse().toString();
    }
}
