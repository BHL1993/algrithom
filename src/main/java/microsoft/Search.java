package microsoft;

/**
 * 搜索旋转排序数组
 * <p>
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * <p>
 * 示例2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * <p>
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/29 9:12 下午
 */
public class Search {
    public static void main(String[] args) {
        System.out.println(new Search().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new Search().search(new int[]{1, 0, 1, 1, 1}, 0));
    }

    /**
     * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
     * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] == nums[low]) {
                // 1, 0, 1, 1, 1
                //nums[mid] 等于 nums[low] 的情况。无法判断哪侧数据有序，low直接右移
                low++;
            } else if (nums[mid] > nums[low]) {//比较 nums[mid] 与 nums[0]大小，确定mid左侧部分有序还是mid右侧部分有序
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;//如果mid左侧有序且target在左侧范围内，则在左侧范围中继续查找
                } else {
                    low = mid + 1;//否则，在右侧范围中查找
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    low = mid + 1;//如果mid右侧有序，且target在右侧范围内，则在右侧范围中继续查找
                } else {
                    high = mid - 1;//否则，在左侧范围中查找
                }
            }
        }

        return -1;
    }

}
