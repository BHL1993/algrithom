package microsoft;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * <p>
 * 输入： heights = [2,4]
 * 输出： 4
 * <p>
 * 提示：
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/9 3:02 下午
 */
public class LargestRectangleArea {
    public static void main(String[] args) {
        System.out.println(new LargestRectangleArea().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new LargestRectangleArea().largestRectangleArea3(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new LargestRectangleArea().largestRectangleArea5(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int res = 0;

        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }


    public int largestRectangleArea4(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int[] left_i = new int[n];
        int[] right_i = new int[n];
        left_i[0] = -1;
        right_i[n - 1] = n;
        int res = 0;
        for (int i = 1; i < n; i++) {
            int tmp = i - 1;
            while (tmp >= 0 && heights[tmp] >= heights[i]) tmp = left_i[tmp];
            left_i[i] = tmp;
        }
        for (int i = n - 2; i >= 0; i--) {
            int tmp = i + 1;
            while (tmp < n && heights[tmp] >= heights[i]) tmp = right_i[tmp];
            right_i[i] = tmp;
        }
        for (int i = 0; i < n; i++) res = Math.max(res, (right_i[i] - left_i[i] - 1) * heights[i]);
        return res;
    }

    /**
     * 依次求每个柱形能形成的矩形的面积
     * 分别找到
     *      当前柱形左侧第一个小于当前柱形高度的位置 i
     *      当前柱形右侧第一个小于当前柱形高度的位置 j
     * 则当前柱形形成的矩形的面积S = (j - i - 1) * 当前矩形的高度
     *
     * 空间换时间
     *  通过leftMin数组提前维护第i个柱形左侧第一个小于当前高度的柱形位置
     *  通过rightMin数组提前维护第i个柱形右侧第一个小于当前高度的柱形位置
     *
     *  在维护leftMin的过程中，如果heights[tmp] >= heights[i]，则将tmp直接复制为leftMin[tmp]，再次进行循环比较。
     *  原理：
     *      如果heights[tmp] >= heights[i]
     *              则代表第一个小于 heights[i] 的位置还在tmp左侧。需要继续向左寻找第一个小于heights[i]的位置。
     *              而leftMin[tmp]表示tmp左侧第一个小于heights[tmp]的位置，即：(leftMin[tmp], tmp)区间内的所有柱形高度都大于heights[tmp]，也就更大于heights[i]。
     *              因此：
     *                  如果heights[leftMin[tmp]] <  heights[i]。则代表leftMin[tmp]位置的柱形为i左侧第一个小于heights[i]高度的柱形位置。
     *                  如果heights[leftMin[tmp]] >=  heights[i]。则代表[leftMin[tmp], tmp]区间内所有柱形高度都大于heights[i]，则使用leftMin[tmp]作为下一次循环的起始位置，继续判断，直至最左侧位置。
     *
     *  维护rightMin的过程同理。
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea5(int[] heights) {
        int res = 0;

        int[] leftMin = new int[heights.length];
        int[] rightMin = new int[heights.length];
        leftMin[0] = -1;
        rightMin[heights.length - 1] = heights.length;

        for (int i = 1; i < heights.length; i++) {
            int tmp = i - 1;
            while (tmp >= 0 && heights[tmp] >= heights[i]) {
                tmp = leftMin[tmp];
            }
            leftMin[i] = tmp;
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            int tmp = i + 1;
            while (tmp < heights.length && heights[tmp] >= heights[i]){
                tmp = rightMin[tmp];
            }
            rightMin[i] = tmp;
        }

        for (int i = 0; i < heights.length; i++) {
            int left = leftMin[i];
            int right = rightMin[i];

            res = Math.max(res, heights[i] * (right - left - 1));
        }
        return res;

    }

    /**
     * 依次求每个柱形能形成的矩形的面积
     * 分别找到
     *      当前柱形左侧第一个小于当前柱形高度的位置 i
     *      当前柱形右侧第一个小于当前柱形高度的位置 j
     * 则当前柱形形成的矩形的面积S = (j - i - 1) * 当前矩形的高度
     *
     * 在遍历当前柱形时，直接从当前位置开始，向两侧分别寻找第一个小于当前高度的位置，并计算矩形面积
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        int res = 0;

        int[] leftMin = new int[heights.length];
        int[] rightMin = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            int tmp = i;
            while (tmp >= 0 && heights[tmp] >= heights[i]) {
                tmp --;
            }
            leftMin[i] = tmp + 1;

            tmp = i;
            while (tmp < heights.length && heights[tmp] >= heights[i]) {
                tmp++;
            }
            rightMin[i] = tmp - 1;
        }

        for (int i = 0; i < heights.length; i++) {
            int left = leftMin[i];
            int right = rightMin[i];

            res = Math.max(res, heights[i] * (right - left + 1));
        }
        return res;
    }

    /**
     * 遍历每个元素，依次判断每个元素能形成的最大矩形面积
     * 分别在该元素的左右两侧，找出第一个小于该元素的位置，最终的矩形就为该位置之间形成的面积
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            int low = i;
            int high = i;

            while (low >= 0 && heights[low] >= heights[i]) {
                low--;
            }

            while (high <= heights.length - 1 && heights[high] >= heights[i]) {
                high++;
            }
            res = Math.max(res, (high - low - 1) * heights[i]);
        }

        return res;
    }


    public int largestRectangleArea1(int[] heights) {
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                res = Math.max(Math.max(res, (j - i + 1) * min), heights[j]);
            }
        }

        return res;
    }
}
