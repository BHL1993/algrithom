package algorithm;

import java.util.Arrays;

/**
 * 供暖器
 * 
 * 冬季已经来临。你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 
 * 现在，给出位于一条水平线上的房屋houses 和供暖器heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 * 
 * 
 * 示例 1:
 * 
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 * 
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * 示例 3：
 * 
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 * 
 * 
 * 为了得到距离每个房屋最近的供暖器，可以将供暖器数组 heaters 排序，然后通过二分查找得到距离最近的供暖器。
 * 
 * 具体而言，对于每个房屋 house，需要在有序数组 heaters 中找到最大的下标 i，使得 heaters[i]≤house，
 * 特别地，当 heaters[0]>house 时，i = -1。在得到下标 i 之后，令 j = i + 1，则 j 是满足 heaters[j]>house 的最小下标。
 * 特别地，当 heaters[n−1]≤house 时，j = n，其中 n 是数组 heaters 的长度。
 * 
 * 得到下标 i 和 j 之后，离房屋 house 最近的供暖器为 heaters[i] 或 heaters[j]，分别计算这两个供暖器和房屋 house 的距离，其中的最小值即为该房屋需要的供暖器的最小加热半径。
 * 对于 i = -1 或 j = n 的下标越界情况，只要将对应的距离设为 +∞ 即可。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/20 9:38 上午
 */
public class FindRadius {
    public static void main(String[] args) {
        FindRadius findRadius = new FindRadius();
        System.out.println(findRadius.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
    }

    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;

        Arrays.sort(heaters);

        for (int house : houses) {
            int i = binarySearch(heaters, house);
            int j = i + 1;
            int leftDistance = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
            int rightDistance = j >= heaters.length ? Integer.MAX_VALUE : heaters[j] - house;

            ans = Math.max(ans, Math.min(leftDistance, rightDistance));


            if (i < 0) {
                ans = Math.max(ans, heaters[0] - house);
            } else if (i >= heaters.length - 1) {
                ans = Math.max(ans, house - heaters[heaters.length - 1]);
            } else {
                ans = Math.max(ans, Math.min(house - heaters[i], heaters[i + 1] - house));
            }
        }

        return ans;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (nums[left] > target) {
            return -1;
        }
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    /**
     * 需要求得最小加热半径 ans，使得所有的 houses[i]均被覆盖。
     *
     * 在以 ans 为分割点的数轴上具有「二段性」：
     *
     * 数值小于 ans 的半径无法覆盖所有的房子；
     * 数值大于等于 ans 的半径可以覆盖所有房子。
     * 因此可直接「二分答案」，考虑应该在什么范围内进行「二分」。
     *
     * 可以从数据范围入手，使用 1e9 为二分上界，该做法能确保答案在二分范围内。
     *
     * 考虑如何实现 check 函数。
     *
     * 先对 houses 和 heaters 进行排序，使用 i 指向当前处理到的 houses[i]；j 指向 可能 覆盖到 houses[i] 的最小下标 heaters[j]；x 代表当前需要 check 的半径。
     *
     * 当且仅当 heaters[j] + x < houses[i] 时，houses[i] 必然不能被 heaters[j] 所覆盖，此时让 j 自增。
     *
     * 找到合适的 j 之后，再检查 heaters[j] - x <= houses[i] <= heaters[j] + x 是否满足，即可知道 houses[i] 的覆盖情况。
     *
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            int curDistance = Math.abs(houses[i] - heaters[j]);
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                curDistance = Math.min(curDistance, Math.abs(houses[i] - heaters[j]));
            }
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }
}
