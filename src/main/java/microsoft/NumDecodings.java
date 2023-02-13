package microsoft;

import java.util.HashSet;
import java.util.Set;

/**
 * 解码方法
 * <p>
 * 一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 * <p>
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 * <p>
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/12 12:43 下午
 */
public class NumDecodings {
    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("12"));
    }


    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        Set<String> legalStr = new HashSet<>();
        for (int i = 1; i <= 26; i++) {
            legalStr.add(i + "");
        }

        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 1; i < s.length(); i++) {
            String cur = s.substring(i, i + 1);
            String pre = s.substring(i - 1, i + 1);

            if (legalStr.contains(cur)) {
                if (legalStr.contains(pre)) {
                    if (i >= 2) {
                        dp[i] = dp[i - 1] + dp[i - 2];
                    } else {
                        dp[i] = 2;
                    }
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                if (legalStr.contains(pre)) {
                    if (i >= 2) {
                        dp[i] = dp[i - 2];
                    } else {
                        dp[i] = 1;
                    }
                }
            }
        }

        return dp[s.length() - 1];
    }
}
