package microsoft;

import com.alibaba.fastjson.JSON;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 
 * 算法的时间复杂度应该为 O(log (m+n))
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/9 9:46 下午
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combined = combine(nums1, nums2);

        int mid = (nums1.length + nums2.length) / 2;
        int car = (nums1.length + nums2.length) % 2;
        if (car == 1) {
            return combined[mid];
        } else {
            return (combined[mid] + combined[mid - 1]) / 2d;
        }
    }

    private static int[] combine(int[] nums1, int[] nums2) {
        int[] combined = new int[nums1.length + nums2.length];
        int index = 0, x1 = 0, x2 = 0;

        while (index < combined.length) {
            int val1 = x1 < nums1.length ? nums1[x1] : Integer.MAX_VALUE;
            int val2 = x2 < nums2.length ? nums2[x2] : Integer.MAX_VALUE;

            if (val1 <= val2) {
                combined[index++] = val1;
                x1++;
            } else {
                combined[index++] = val2;
                x2++;
            }
        }

        return combined;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(combine(new int[]{1, 2}, new int[]{3, 4})));
    }
}
