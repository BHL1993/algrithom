package microsoft;

/**
 * 搜索旋转排序数组 II
 * <p>
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * <p>
 * 你必须尽可能减少整个操作步骤。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * <p>
 * <p>
 * 示例2：
 * 输入：nums = [2,5,6,0,1,1,2], target = 3
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/9 11:06 上午
 */
public class SearchII {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] == nums[low]) {
                low++;
                continue;
            }

            if (nums[mid] > nums[low]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}
