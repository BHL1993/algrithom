package algorithm;

import java.util.Arrays;

/**
 * @author ：BaiHailong
 * @date ：Created in 2022/9/7 10:59 上午
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        int low = 0;
        int index = 1;
        for (; index <= nums.length / 2; index++) {
            if (nums[index] > nums[index - 1]) {
                low = index;
            }
        }
        return nums[low];
    }
}
