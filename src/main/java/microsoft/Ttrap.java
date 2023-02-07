package microsoft;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 示例 2：
 * 
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * 
 * 提示：
 * 
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/30 10:00 下午
 */
public class Ttrap {
    public static void main(String[] args) {
        System.out.println(new Ttrap().calByDp3(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(new Ttrap().calByDp3(new int[]{5, 4, 1, 2}));
    }

    public int calByLine(int[] height) {
        int res = 0;
        int tmp = 0;

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
        }

        for (int i = 1; i <= max; i++) {
            boolean start = false;
            tmp = 0;
            for (int j = 0; j < height.length; j++) {
                if (height[j] >= i) {
                    if (start) {
                        res = res + tmp;
                        System.out.println(tmp);
                        tmp = 0;
                    }
                    start = true;
                } else {
                    if (start) {
                        tmp++;
                    }
                }
            }
        }

        return res;
    }

    public int calByColumn(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = getMax(0, i - 1, height);
            int rightMax = getMax(i + 1, height.length - 1, height);

            if (leftMax >= height[i] && rightMax >= height[i]) {
                res += Math.min(leftMax, rightMax) - height[i];
            }
        }

        return res;
    }

    private int getMax(int low, int high, int[] height) {
        int max = 0;

        while (low <= high) {
            if (max < height[low]) {
                max = height[low];
            }

            low++;
        }
        return max;
    }

    public int calByDp(int[] height) {
        int res = 0;
        int[] leftMaxDp = new int[height.length];
        int[] rightMaxDp = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                leftMaxDp[i] = 0;
            } else {
                leftMaxDp[i] = Math.max(leftMaxDp[i - 1], height[i - 1]);
            }
        }

        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                rightMaxDp[i] = 0;
            } else {
                rightMaxDp[i] = Math.max(rightMaxDp[i + 1], height[i + 1]);
            }
        }

        for (int i = 0; i < height.length; i++) {
            if (leftMaxDp[i] >= height[i] && rightMaxDp[i] >= height[i]) {
                res += Math.min(leftMaxDp[i], rightMaxDp[i]) - height[i];
            }
        }

        return res;
    }

    public int calByDp1(int[] height) {
        int res = 0;
        int leftMax = 0;
        int[] rightMaxDp = new int[height.length];

        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                rightMaxDp[i] = 0;
            } else {
                rightMaxDp[i] = Math.max(rightMaxDp[i + 1], height[i + 1]);
            }
        }

        for (int i = 0; i < height.length; i++) {
            leftMax = i > 0 ? Math.max(leftMax, height[i - 1]) : 0;
            if (leftMax >= height[i] && rightMaxDp[i] >= height[i]) {
                res += Math.min(leftMax, rightMaxDp[i]) - height[i];
            }
        }

        return res;
    }

    public int calByDp3(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }


        return res;
    }

    public int calByDp2(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}
