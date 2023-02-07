package algorithm;


import java.util.HashMap;

/**
 * 在线选举
 * 
 * 给你两个整数数组 persons 和 times 。在选举中，第i张票是在时刻为times[i]时投给候选人 persons[i]的。
 * 
 * 对于发生在时刻 t 的每个查询，需要找出在t 时刻在选举中领先的候选人的编号。
 * 
 * 在t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
 * 
 * 实现 TopVotedCandidate 类：
 * 
 * TopVotedCandidate(int[] persons, int[] times) 使用persons 和 times 数组初始化对象。
 * int q(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。
 * 
 * 示例：
 * 
 * 输入：
 * ["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
 * [[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [24], [8]]
 * 输出：
 * [null, 0, 1, 1, 0, 0, 1]
 * 
 * 解释：
 * TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
 * topVotedCandidate.q(3); // 返回 0 ，在时刻 3 ，票数分布为 [0] ，编号为 0 的候选人领先。
 * topVotedCandidate.q(12); // 返回 1 ，在时刻 12 ，票数分布为 [0,1,1] ，编号为 1 的候选人领先。
 * topVotedCandidate.q(25); // 返回 1 ，在时刻 25 ，票数分布为 [0,1,1,0,0,1] ，编号为 1 的候选人领先。（在平局的情况下，1 是最近获得投票的候选人）。
 * topVotedCandidate.q(15); // 返回 0
 * topVotedCandidate.q(24); // 返回 0
 * topVotedCandidate.q(8); // 返回 1
 * 
 * 提示：
 * 
 * 1 <= persons.length <= 5000
 * times.length == persons.length
 * 0 <= persons[i] < persons.length
 * 0 <= times[i] <= 109
 * times 是一个严格递增的有序数组
 * times[0] <= t <= 109
 * 每个测试用例最多调用 104 次 q
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/11 3:50 下午
 */
public class TopVotedCandidate {
    public static void main(String[] args) {
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0, 1, 0, 1, 1}, new int[]{24, 29, 31, 76, 81});
        topVotedCandidate.q(28);
        System.out.println("");
    }

    private int[] arr;
    private int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        int[] ans = new int[persons.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int top = persons[0];
        map.put(top, 1);

        for (int i = 1; i < times.length; i++) {
            int c = persons[i];
            map.merge(c, 1, Integer::sum);

            if (map.get(c) >= map.get(top)) {
                top = c;
            }

            ans[i] = top;
        }

        this.arr = ans;
        this.times = times;

    }


    public int q(int t) {
        int l = 0, r = times.length - 1;
        int m = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (times[m] == t) {
                r = m;
                break;
            } else if (times[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return arr[r];
    }
}
