package microsoft;


import java.util.ArrayList;

/**
 * 插入取件
 * 
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 
 * 示例1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。
 * 
 * 
 * 示例 3：
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 
 * 示例 4：
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 
 * 示例 5：
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * 
 * 
 * 提示：
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <=intervals[i][0] <=intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <=newInterval[0] <=newInterval[1] <= 105
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/6 9:19 上午
 */
public class InsertRange {
    public static void main(String[] args) {
        int[][] merge = new InsertRange().merge1(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        System.out.println();
    }

    public int[][] merge(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int len = intervals.length;
        int i = 0;
        // 判断左边不重合
        while (i < len && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        // 判断重合
        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);
        // 判断右边不重合
        while (i < len && intervals[i][0] > newInterval[1]) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[0][]);
    }


    public int[][] merge1(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();

        int len = intervals.length;
        int i = 0;

        while(i < len && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        while (i < len && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        while(i < len && intervals[i][0] > newInterval[1]){
            res.add(intervals[i]);
            i++;
        }

        return  res.toArray(new int[0][]);
    }
}
