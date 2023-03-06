package microsoft;

/**
 * 验证回文串
 * <p>
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 * <p>
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 * <p>
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/3/3 10:37 上午
 */
public class IsPalindromeI {
    public static void main(String[] args) {
        //System.out.println(new IsPalindromeI().isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(new IsPalindromeI().isPalindrome(".,"));
        System.out.println(new IsPalindromeI().isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        int low = 0;
        int high = s.length() - 1;
        while (low <= high) {
            while (!legalChar(s.charAt(low)) && low < high) {
                low++;
            }

            while (!legalChar(s.charAt(high)) && low < high) {
                high--;
            }

            if (!equal(s.charAt(low++), s.charAt(high--))) {
                return false;
            }
        }

        return true;
    }

    private boolean legalChar(char cha) {
        return ('a' <= cha && cha <= 'z') || ('A' <= cha && cha <= 'Z') || ('0' <= cha && cha <= '9');
    }

    private boolean equal(char a, char b) {
        if ('0' <= a && a <= '9') {
            return a == b;
        } else if ('a' <= a && a <= 'z') {
            return a == b || (a - 'a') == (b - 'A');
        } else {
            return a == b || (a - 'A') == (b - 'a');
        }
    }
}
