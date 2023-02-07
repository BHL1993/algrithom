package microsoft;

import java.util.Stack;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/1/29 5:35 下午
 */
public class LongestValidParentheses1 {
    public int longestValidParentheses(String s) {

        int res = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i) || stack.empty() || s.charAt(stack.peek()) != '(') {
                stack.push(i);
            } else {
                stack.pop();
            }
        }

        boolean[] arr = new boolean[s.length()];
        while (!stack.empty()) {
            arr[stack.pop()] = true;
        }

        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arr[i]) {
                res = Math.max(res, tmp);
                tmp = 0;
            } else {
                tmp++;
            }
        }
        res = Math.max(res, tmp);
        return res;
    }
}
