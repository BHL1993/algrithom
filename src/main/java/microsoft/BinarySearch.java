package microsoft;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/1/29 5:31 下午
 */
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(new BinarySearch().binarySearch(new int[]{1, 3, 4, 5, 7, 8}, 8));
    }

    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
