package microsoft;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 最长有效括号
 * 
 * 给你一个只包含 '('和 ')'的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * 
 * 示例 1：
 * 
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * 
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * 
 * 输入：s = ""
 * 输出：0
 * 
 * 提示：
 * 
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/28 11:31 上午
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses2("(()"));
    }

    public int longestValidParentheses2(String s) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i) || stack.empty() || s.charAt(stack.peek()) != '(') {
                stack.push(i);
            } else {
                stack.pop();
            }
        }

        int res = 0, pre = s.length();

        while (!stack.empty()) {
            res = Math.max(res, pre - stack.peek() - 1);
            pre = stack.pop();
        }

        res = Math.max(res, pre);
        return res;
    }


    public int longestValidParentheses(String s) {
        int res = 0;

        Stack<Integer> stack = new Stack<>();
        boolean[] arr = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                stack.push(i);
            } else {
                if (stack.empty()) {
                    arr[i] = true;
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.empty()) {
            arr[stack.pop()] = true;
        }

        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!arr[i]) {
                tmp++;
            } else {
                res = Math.max(res, tmp);
                tmp = 0;
            }
        }
        res = Math.max(res, tmp);
        return res;
    }
}
