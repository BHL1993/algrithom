package microsoft;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 * 
 * 
 * 
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 
 * 
 * 示例2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 
 * 
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * 
 * 
 * 提示：
 * 0 <= nums.length <= 105
 * -109<= nums[i]<= 109
 * nums是一个非递减数组
 * -109<= target<= 109
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/29 10:29 下午
 */
public class SearchRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{7, 7, 7,  7, 7}, 6)));
    }

    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                int left = mid;
                int right = mid;

                while (left >= 0 && nums[left] == target) {
                    left--;
                }

                while (right < nums.length && nums[right] == target) {
                    right++;
                }

                return new int[]{left + 1, right - 1};

            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        return new int[]{-1, -1};
    }
}
