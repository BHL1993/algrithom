package microsoft;

/**
 * 最大子数组和
 * <p>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/4 5:51 下午
 */
public class MaxSubArray {
    /**
     * num[i] 只有两种选择
     * 1、加入前一区间，作为结果集的一部分
     * 2、作为新区间的起始位置
     * <p>
     * 选择1的条件：sum > 0。
     *      前面的区间和大于0，如果num[i] >= 0，则直接加入该区间，并更新最大值。
     *                      如果num[i] < 0，虽然num[i]本身小于0，sum + num[i]小于原sum，但是num[i]之后的元素可能为正数，即最终的sum仍然有继续变大的可能。
     * 选择2的条件：sum <= 0。
     *      前面的区间和已经小于0，如果将num[i]继续加入前面的区间，则最终的和肯定小于num[i]本身，所以将num[i]作为新区间的起始位置
     * <p>
     * <p>
     * 遍历到 num[i] 时，如果sum <= 0
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
