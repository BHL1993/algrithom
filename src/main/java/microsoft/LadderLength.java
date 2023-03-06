package microsoft;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单词接龙
 * <p>
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 * <p>
 * 每一对相邻的单词只差一个字母。
 * 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * <p>
 * 示例 2：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 *
 *
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/3/3 10:38 上午
 */
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            indexMap.put(wordList.get(i), i);
        }
        dfs(beginWord, endWord, wordList, indexMap);
        return 0;
    }

    private void dfs(String beginWord, String endWord, List<String> wordList, Map<String, Integer> indexMap) {

    }
}
