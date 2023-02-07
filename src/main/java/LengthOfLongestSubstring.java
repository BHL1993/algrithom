import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/9/27 8:47 下午
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        Set<Character> characterSet = new HashSet<>();

        int rk = -1, ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                characterSet.remove(s.charAt(i - 1));
            }

            while (rk + 1 < n && !characterSet.contains(s.charAt(rk + 1))) {
                characterSet.add(s.charAt(rk + 1));
                rk++;
            }

            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
