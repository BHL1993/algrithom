package microsoft;

import java.util.HashSet;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/9 9:17 下午
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] charArray = s.toCharArray();
        int tmp = 0, ret = 0;
        HashSet<Character> set = new HashSet<>();

        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i < s.length(); i++) {
                if (set.contains(charArray[i])) {
                    ret = Math.max(ret, tmp);
                    set.clear();
                    tmp = 0;
                    break;
                } else {
                    tmp++;
                    set.add(charArray[i]);
                }
            }
            ret = Math.max(ret, tmp);
        }


        return ret;
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] charArray = s.toCharArray();
        int left = 0, right = 0;
        int ret = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            if (!set.contains(charArray[right])) {
                set.add(charArray[right++]);
            } else {
                ret = Math.max(ret, set.size());
                set.remove(charArray[left++]);
            }
        }

        return Math.max(ret, set.size());
    }
}
