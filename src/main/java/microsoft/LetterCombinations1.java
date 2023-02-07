package microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/2/1 11:32 上午
 */
public class LetterCombinations1 {
    //定义一个集合表示字符串的所有可能
    static Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static void main(String[] args) {
        System.out.println(new LetterCombinations1().letterCombinations("89"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        dfs1(res, digits, sb, 0);
        return res;
    }

    private void dfs1(List<String> res, String digits, StringBuilder sb, int level) {
        if (level == digits.length() - 1) {
            String s = map.get(digits.charAt(level));

            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                res.add(sb.toString());
                sb.deleteCharAt(sb.length() - 1);
            }
            return;
        }

        String s = map.get(digits.charAt(level));
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs1(res, digits, sb, level + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private void dfs(List<String> res, String digits, StringBuilder sb, int level) {
        if (level == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String s = map.get(digits.charAt(level));
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs(res, digits, sb, level + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
