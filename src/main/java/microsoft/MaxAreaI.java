package microsoft;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/12 12:25 下午
 */
public class MaxAreaI {
    public static void main(String[] args) {
        System.out.println(new MaxAreaI().maxArea1(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(new MaxAreaI().maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(new MaxAreaI().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * 双指针
     * 左指针left、右指针right
     * 首先计算以left、right为边能容纳的最大面积 = (right - left) * 短板，即min(height[left], height[right])
     *
     * 如果height[left] < height[right]，即left位置为短板
     *      此时如果向内移动长板right，短板位置仍然是left，或者是向内移动后的right。短板高度只能不变或更小，而right - left一定会变小，所以最终能借的水一定会变少。
     *      此时如果向内移动短板left，虽然right - left仍然一定会变小，但是短板left向内移动后，新的短板有可能变大，能接的水就有可能变多。
     * 因此，每次计算完当前位置能接的水后，需要不断向内移动短板，才能找到接最多水的位置。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int res = 0;
        int low = 0;
        int high = height.length - 1;
        while (low < high) {
            if (height[low] < height[high]) {
                res = Math.max(res, (high - low) * height[low++]);
            } else {
                res = Math.max(res, (high - low) * height[high--]);
            }
        }

        return res;
    }

    public int maxArea2(int[] height) {
        int ret = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                ret = Math.max((right - left) * height[left++], ret);
            } else {
                ret = Math.max((right - left) * height[right--], ret);
            }
        }

        return ret;
    }

    public int maxArea1(int[] height) {
        int ret = 1;
        int left = 0, right = 1;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[right]) {
                int rightArea = (i - right) * height[right];
                int leftArea = (i - left) * Math.min(height[i], height[left]);
                if (rightArea > leftArea) {
                    left = right;
                }
                right = i;
                ret = Math.max(ret, Math.max(rightArea, leftArea));
            } else if (height[i] == height[right]) {
                ret = (i - left) * Math.min(height[i], height[left]);
                right = i;
            } else {
                int rightArea = (i - right) * height[i];
                int leftArea = (i - left) * Math.min(height[i], height[left]);

                if (rightArea > leftArea) {
                    left = right;
                }

                right = i;
                ret = Math.max(ret, Math.max(rightArea, leftArea));
            }
        }

        return ret;
    }
}
