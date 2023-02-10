package microsoft;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/30 10:00 下午
 */
public class TtrapI {
    public static void main(String[] args) {
        System.out.println(new TtrapI().trap(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(new TtrapI().trap1(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(new TtrapI().trap2(new int[]{4, 2, 0, 3, 2, 5}));
/*
        System.out.println(new TtrapI().calByDp3(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(new TtrapI().calByDp3(new int[]{5, 4, 1, 2}));
        System.out.println(new TtrapI().trap(new int[]{5, 4, 1, 2}));*/
    }

    /**
     * 接雨水
     * 依次计算每个柱子能接多少水。
     * 当前柱子能接多少水，取决于当前柱子左右两侧的最高柱子的高度 leftMax 与 rightMax，当前柱子能接的水 = Min(leftMax, rightMax) - 当前柱子高度
     * <p>
     * 空间换时间
     * 通过提前维护 leftMax[] 与 rightMax[]，保存 每个柱子左侧最高柱子的位置 与 每个柱子右侧最高柱子的位置
     * <p>
     * Tips：最左侧与最右侧柱子 能接的水一定为 0
     * <p>
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     */
    public int trap(int[] height) {
        int res = 0;

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int tmp = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[tmp] > height[i]) {
                leftMax[i] = tmp;
            } else {
                leftMax[i] = -1;
                tmp = i;
            }
        }

        tmp = height.length - 1;
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[tmp] > height[i]) {
                rightMax[i] = tmp;
            } else {
                rightMax[i] = -1;
                tmp = i;
            }
        }

        for (int i = 1; i < height.length - 1; i++) {
            if (leftMax[i] != -1 && rightMax[i] != -1) {
                int min = Math.min(height[leftMax[i]], height[rightMax[i]]);
                res += (min - height[i]);
            }
        }

        return res;
    }

    /**
     * 接雨水
     * 依次计算每个柱子能接多少水。
     * 当前柱子能接多少水，取决于当前柱子左右两侧的最高柱子的高度 leftMax 与 rightMax，当前柱子能接的水 = Min(leftMax, rightMax) - 当前柱子高度
     * <p>
     * trap方法维护了 leftMax[] 与 rightMax[]两个数组分别保存第i个柱子左侧与右侧的最高高度
     * 而在计算每个柱子能接的水时，height数组遍历方向为从左到右，可以在遍历的同时维护leftMax，减少leftMax[]数组的空间占用，因为leftMax一定是随着向右遍历的过程不断变大。
     * 因此只需要额外维护 rightMax[] 一个数组就可以
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int res = 0;

        int leftMax = 0;
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = -1;

        int tmp = height.length - 1;
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[tmp] > height[i]) {
                rightMax[i] = tmp;
            } else {
                rightMax[i] = -1;
                tmp = i;
            }
        }

        for (int i = 0; i < height.length - 1; i++) {
            if (rightMax[i] != -1 && height[leftMax] > height[i]) {
                res += Math.min(height[leftMax], height[rightMax[i]]) - height[i];
            }

            if (height[i] > height[leftMax]) {
                leftMax = i;
            }
        }

        return res;
    }

    /**
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     * <p>
     * 接雨水
     * 依次计算每个柱子能接多少水。
     * 当前柱子能接多少水，取决于当前柱子左右两侧的最高柱子的高度 leftMax 与 rightMax，当前柱子能接的水 = Min(leftMax, rightMax) - 当前柱子高度
     * <p>
     * 进一步简化，不使用额外数组，将空间复杂度降低到 O(1)
     * <p>
     * 整体思路：找短板
     * 双指针
     * left、right分表向内循环，每次循环从left、right位置中挑选一个位置进行雨量计算。
     * 使用 leftMax 与 rightMax两个变量分别记录 left、right 向内循环过程中不断更新的 left左侧的最大值 与 right右侧的最大值。
     * <p>
     * 选择left位置计算还是right位置计算？
     * 如果 leftMax < rightMax，则计算 left 位置；否则，计算 right 位置
     * 原理：
     * leftMax < rightMax，代表 [0, left) 区间内的最大值小于 (right, len - 1] 区间内的最大值。
     * 对于left位置的柱子而言，左侧的最高的柱子高度为leftMax。但因为(left, right)区间内的最高柱子现在还不知道，无法确定右侧最高的柱子高度为多少。
     * 假设(left, right)区间内的最高柱子的高度大于rightMax，为tmp。则(left, len - 1]区间的最大值为tmp，因为leftMax < rightMax，所以leftMax < tmp。此时短板为 leftMax，水量为 leftMax - height[left];
     * 否则，如果(left, right)区间内的最高柱子的高度小于 rightMax，则(left, len - 1]区间的最大值仍为 rightMax。此时短板仍然为 leftMax，水量为 leftMax - height[left];
     * 因此，如果 leftMax < rightMax，left位置两侧的短板 一定是 leftMax。因此选择计算 left 柱子的水量；
     * 否则选择计算 right 柱子的水量；
     */
    public int trap2(int[] height) {
        int res = 0;

        int low = 0;
        int high = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (low < high) {
            //每次循环开始，首先更新 leftMax 与 rightMax。
            //1、为什么把当前柱子的高度加入判断？当前柱子的高度会对当前柱子能接的水量产生影响吗？
            //      当前位置的高度如果大于之前的最大高度，则leftMax = 当前高度，res += (leftMax - height[low]);为空计算，不影响结果
            //2、为什么 leftMax 与 rightMax 的更新放在开头不放在结尾
            //      因为leftMax、rightMax初始值为0，放在开头可以避免边界值的判断
            leftMax = Math.max(leftMax, height[low]);
            rightMax = Math.max(rightMax, height[high]);

            if (leftMax < rightMax) {
                res += (leftMax - height[low]);
                low++;
            } else {
                res += (rightMax - height[high]);
                high--;
            }
        }

        return res;
    }
}
