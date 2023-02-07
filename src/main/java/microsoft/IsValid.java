package microsoft;

import java.util.Stack;

/**
 * 有效的括号
 * 
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "()"
 * 输出：true
 * 示例2：
 * 
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 * 
 * 输入：s = "(]"
 * 输出：false
 * 
 * 
 * 提示：
 * 
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/28 10:55 上午
 */
public class IsValid {
    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("()[{}]"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (leftChar(s.charAt(i))) {
                stack.add(s.charAt(i));
            } else {
                if (stack.empty() || !matchChar(stack.pop(), s.charAt(i))) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public boolean leftChar(char c) {
        return '(' == c || '[' == c || '{' == c;
    }

    public boolean matchChar(char left, char right) {
        if ('(' == left) {
            return ')' == right;
        } else if ('[' == left) {
            return ']' == right;
        } else if ('{' == left) {
            return '}' == right;
        }
        return false;
    }
}
