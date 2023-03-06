package microsoft;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长连续序列
 * <p>
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/3/3 2:46 下午
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        System.out.println(new LongestConsecutive().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    /**
     * 用哈希表存储每个端点值对应连续区间的长度
     * 若数已在哈希表中：跳过不做处理
     * 若是新数加入：
     * 取出其左右相邻数已有的连续区间长度 left 和 right
     * 计算当前数的区间长度为：cur_length = left + right + 1
     * 根据 cur_length 更新最大长度 max_length 的值
     * 更新区间两端点的长度值
     */
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                int left = map.get(nums[i] - 1) == null ? 0 : map.get(nums[i] - 1);
                int right = map.get(nums[i] + 1) == null ? 0 : map.get(nums[i] + 1);
                int tmp = left + right + 1;
                if (tmp > res) {
                    res = tmp;
                }

                map.put(nums[i], tmp);
                //只需更新端点处对应的连续区间长度
                // 因为后续如果出现该区间内的数字，则该数字一定在哈希表中存在，即无需处理
                // 而产生左右取件相连的情况时，只取左右区间各端点对应的连续区间长度
                map.put(nums[i] - left, tmp);
                map.put(nums[i] + right, tmp);
            }
        }
        return res;
    }
}
