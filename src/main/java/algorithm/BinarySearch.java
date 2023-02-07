package algorithm;

/**
 * 二分查找
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/11 9:19 下午
 */

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(1025 & 1024 - 1);
    }
    public int search(int[] nums, int target) {
        int m = 0, l = 0, r = nums.length - 1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }
}
