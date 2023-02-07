package microsoft;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * 
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * 
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 * 
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）
 * 
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s 只包含从 a-z 的小写字母。
 * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/    12 10:24 上午
 */
public class IsMatch {

    public static void main(String[] args) {
        System.out.println(new IsMatch().isMatch("adceb", "*a*b"));
    }

    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;

        char preS = s.charAt(0);
        char preP = p.charAt(0);
        while (i < s.length() && j < p.length()) {
            if (isChar(p.charAt(j))) {
                if (s.charAt(i) != p.charAt(j)) {
                    return false;
                }
                preS = s.charAt(i++);
                preP = p.charAt(j++);
            } else if ('.' == p.charAt(j)) {
                preS = s.charAt(i++);
                preP = p.charAt(j++);
            } else if ('*' == p.charAt(j)) {
                if (preP == '.') {
                    preS = s.charAt(i++);
                } else {
                    if (preS == s.charAt(i)) {
                        preS = s.charAt(i++);
                    } else {
                        preP = p.charAt(j++);
                    }
                }
            }
        }

        return i == s.length();
    }

    public boolean isChar(char c) {
        return 'a' <= c && c <= 'z';
    }
}
