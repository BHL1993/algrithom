package microsoft;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 返回容器可以储存的最大水量。
 * 
 * 说明：你不能倾斜容器。
 * 
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 输入：height = [1,1]
 * 输出：1
 * 
 * 提示：
 * 
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/12 12:25 下午
 */
public class MaxArea {
    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea1(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea1(int[] height) {
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

    public int maxArea(int[] height) {
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
