package microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 复原 IP 地址
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入'.' 来形成。你 不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * s 仅由数字组成
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/13 3:13 下午
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("101023"));
    }

    public List<String> restoreIpAddresses(String s) {
        Set<String> validSet = new HashSet<>();
        for (int i = 0; i <= 255; i++) {
            validSet.add(i + "");
        }


        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, validSet, 0, 0, s);

        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, Set<String> validSet, int start, int level, String s) {
        if (level > 4) {
            return;
        }

        if (level == 4 && start == s.length()) {
            String s1 = sb.toString();
            res.add(s1.substring(0, s1.length() - 1));
            return;
        } else if (level == 4 && start < s.length()) {
            return;
        }

        int max = Math.min(start + 3, s.length());

        for (int i = start + 1; i <= max; i++) {
            String tmp = s.substring(start, i);
            if (validSet.contains(tmp)) {
                sb.append(tmp);
                sb.append(".");
                dfs(res, sb, validSet, i, level + 1, s);
                sb.delete(sb.length() - (i - start + 1), sb.length());
            } else {
                break;
            }
        }
    }
}
