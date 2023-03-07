package microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 单词拆分 II
 * <p>
 * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 * 注意：词典中的同一个单词可能在分段中被重复使用多次。
 * <p>
 * 示例 1：
 * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * 输出:["cats and dog","cat sand dog"]
 * <p>
 * 示例 2：
 * 输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * 输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * 解释: 注意你可以重复使用字典中的单词。
 * <p>
 * 示例 3：
 * 输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * 输出:[]
 * <p>
 * 提示：
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中所有字符串都 不同
 */
public class WordBreakII {
    public static void main(String[] args) {
        System.out.println(new WordBreakII().wordBreak("aaaaaaa", Arrays.asList("aaaa","aa","a")));
        System.out.println(new WordBreakII().wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog")));
    }

    /**
     * 回溯法
     *
     * 依次将start位置后，每个存在于 wordDict 的单词加入结果集
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, s, wordDict, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            sb.append(" ");
        }

        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            if (wordDict.contains(substring)) {
                sb.append(substring);
                sb.append(" ");
                dfs(res, sb, s, wordDict, i + 1);
                sb.delete(sb.length() - (i- start + 2), sb.length());
            }
        }
    }
}
