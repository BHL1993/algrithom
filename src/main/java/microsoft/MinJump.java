package microsoft;

/**
 * 跳跃游戏
 * <p>
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * <p>
 * 示例2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/4 9:02 下午
 */
public class MinJump {

    public static void main(String[] args) {
        System.out.println(new MinJump().minJump(new int[]{2,3,0,1,4}));
    }

    public static int res = Integer.MAX_VALUE;

    public int minJump(int[] nums) {
        dfs(nums, 0, 0);
        return res;
    }

    private void dfs(int[] nums, int depth, int step) {
        if (depth == nums.length - 1) {
            res = Math.min(res, step);
            return;
        }




        int num = nums[depth];
        for (int i = 1; i <= num; i++) {
            dfs(nums, depth + i, step + 1);
        }
    }
}
