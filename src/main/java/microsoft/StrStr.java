package microsoft;

/**
 * 找出字符串中第一个匹配项的下标
 * 
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * 
 * 示例 1：
 * 
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 
 * 
 * 示例 2：
 * 
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * 
 * 
 * 提示：
 * 
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/29 10:42 上午
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && same(haystack, i, needle)) {
                return i;
            }
        }

        return -1;
    }

    private boolean same(String haystack, int i, String needle) {
        int j = 0;
        while (i < haystack.length() && j < needle.length()){
            if(haystack.charAt(i++) != needle.charAt(j++)){
                return false;
            }
        }

        return j >= needle.length();
    }
}
