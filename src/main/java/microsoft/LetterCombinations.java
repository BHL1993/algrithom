package microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * 
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 示例 1：
 * 
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 
 * 
 * 提示：
 * 
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/12 10:13 下午
 */
public class LetterCombinations {
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

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }

        StringBuilder sb = new StringBuilder();

        dfs(res, digits, 0, sb);

        return res;
    }

    private void dfs(List<String> res, String digits, int level, StringBuilder sb) {
        if (level >= digits.length()) {
            return;
        }
        String s = map.get(digits.charAt(level));

        if (level == digits.length() - 1) {
            String s1 = sb.toString();
            for (int i = 0; i < s.length(); i++) {
                res.add(s1 + s.charAt(i));
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                StringBuilder tmp = new StringBuilder(sb);
                tmp.append(s.charAt(i));
                dfs(res, digits, level + 1, tmp);
            }
        }
    }

    private void dfs1(List<String> res, String digits, int level, StringBuilder sb) {
        if (level == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String s = map.get(digits.charAt(level));

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs1(res, digits, level + 1, sb);
            sb.deleteCharAt(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }
}
