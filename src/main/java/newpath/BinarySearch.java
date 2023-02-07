package newpath;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/1/4 9:23 下午
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(1025 & 1024 - 1);
    }

    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == target) {
                return mid;
            } else if (mid > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return 0;
    }
}
