package microsoft;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashSet;

/**
 * 最小覆盖子串
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * <p>
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 * <p>
 * <p>
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/8 3:14 下午
 */
public class MinWindow {
    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        int[] arr = new int[80];
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
            int index = t.charAt(i) - '0';
            arr[index] = arr[index] + 1;
        }


        int low = 0;
        int high = 0;
        int start = 0;
        int len = s.length() + 1;
        while (high < s.length()) {
            if (set.contains(s.charAt(high))) {
                addChar(arr, s.charAt(high), -1);
                if (containAll(arr)) {
                    if (high - low + 1 < len) {
                        len = high - low + 1;
                        start = low;
                    }

                    while (low < high) {
                        if (set.contains(s.charAt(low))) {
                            addChar(arr, s.charAt(low), 1);
                            if (containAll(arr)) {
                                if (high - low + 1 < len) {
                                    len = high - low + 1;
                                    start = low;
                                }

                                low++;
                            } else {
                                high++;
                                break;
                            }
                        } else {
                            low++;
                        }
                    }
                } else {
                    high++;
                }
            } else {
                high++;
            }
        }

        if (len == s.length() + 1) {
            return "";
        }

        return s.substring(start, start + len);
    }

    private boolean containAll(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private void addChar(int[] arr, char charAt, int n) {
        int i = charAt - '0';
        arr[i] = arr[i] + n;
    }
}
