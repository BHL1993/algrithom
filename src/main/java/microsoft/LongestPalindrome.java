package microsoft;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/1/10 8:01 下午
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        String ret = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String tmp = s.substring(i, j + 1);
                if (isPalindrome(tmp) && tmp.length() > ret.length()) {
                    ret = tmp;
                }
            }
        }

        return ret;
    }

    public boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }

        return true;
    }


    /**
     * 动态规划
     * 1、确定dp数组，以及下表的含义
     * dp[i][j]代表 从i到j的字串是否为回文串
     * 2、确定递推公式
     * dp[i][j]要为true，则需要 S[i] == S[j] 且 dp[i+1][j-1] 也为true。
     * 特殊情况（S[i] == S[j]的前提下）：
     * a、i = j (只有一个字符的字符串也是回文串)
     * b、j = i + 1 （有两个字符的字符串，且这两个字符串相同，也是回文串）
     * 3、dp数组初始化
     * 
     * 4、确定遍历顺序
     * 由于dp[i][j]为true或false，可能需要由dp[i+1][j-1]决定，
     * 而dp[i][j]在dp[i+1][j-1]的右上方，因此遍历顺序需要从下往上，从左往右
     *
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        if (s.length() == 1) {
            return s;
        }

        int low = 0, high = 0, maxLength = 0;

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (dp[i + 1][j - 1] || j == i + 1) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxLength) {
                            low = i;
                            high = j;
                            maxLength = j - i + 1;
                        }
                    }
                }
            }
        }

        return s.substring(low, high + 1);

    }

    public static int low = 0, high = 0, maxLength = 0;

    public static String longestPalindrome2(String s) {
        if (s.length() == 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }

        return s.substring(low, high + 1);
    }

    public static void extend(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1) {
            if (s.charAt(left) != s.charAt(right)) {
                return;
            } else {
                if (right - left + 1 > maxLength) {
                    low = left;
                    high = right;
                    maxLength = right - left + 1;
                }
            }
            left--;
            right++;
        }
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome2("babad"));
    }
}
