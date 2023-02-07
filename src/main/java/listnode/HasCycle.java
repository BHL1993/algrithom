package listnode;

import java.util.Stack;

/**
 * @author ：BaiHailong
 * @date ：Created in 2022/9/7 12:13 下午
 */
public class HasCycle {
    private  long l ;

    public static void main(String[] args) {
        HasCycle hasCycle = new HasCycle();
        Long a = null;
        hasCycle.setL(a);
        System.out.println(hasCycle.getL());
    }

    public long getL() {
        return l;
    }

    public  void setL(Long l) {
        this.l = l;
    }

    public static int longestLength(String s) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (isValid(substring)) {
                    ret = Math.max(ret, j - i);
                }
            }
        }
        return ret;
    }

    public static boolean isValid(String str) {
        char[] charArr = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(') {
                stack.push('(');
            } else {
                if (stack.empty()) {
                    return false;
                }

                Character pop = stack.pop();
                if (pop == null) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
