package microsoft;

/**
 * 颜色分类
 * 
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 
 * 
 * 提示：
 * 
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * 
 * 
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/7 8:58 下午
 */
public class SortColors {

    public static void main(String[] args) {
        new SortColors().sortColors2(new int[]{2, 0, 2, 1, 1, 0});
    }

    public void sortColors(int[] nums) {
        int i = 0;
        for (int j = i; j < nums.length; j++) {
            if (nums[j] == 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }

        for (int j = i; j < nums.length; j++) {
            if (nums[j] == 1) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }

        for (int j = i; j < nums.length; j++) {
            if (nums[j] == 2) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }

        System.out.println();

    }


    /**
     * 三指针
     * zeroIndex 代表[0, zeroIndex) 之间数字应该为0
     * oneIndex 代表[zeroIndex, oneIndex) 之间数字应该为1
     * twoIndex 代表[twoIndex, len - 1] 之间数字应该为2
     *
     * 初始值
     * zeroIndex = 0；保证[0, zeroIndex)初始区间为空
     * oneIndex = 0；保证[zeroIndex, oneIndex)初始区间为空
     * twoIndex = len；保证[twoIndex, len - 1]初始区间为空
     *
     * 遍历方向
     * oneIndex -> twoIndex
     *
     * 终止条件
     * oneIndex == twoIndex
     *
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int zeroIndex = 0;
        int oneIndex = 0;
        int twoIndex = nums.length;

        while (oneIndex < twoIndex) {
            if (nums[oneIndex] == 0) {
                swap(nums, zeroIndex, oneIndex);
                zeroIndex++;
                oneIndex++;
            } else if (nums[oneIndex] == 1) {
                oneIndex++;
            } else {
                twoIndex--;
                swap(nums, oneIndex, twoIndex);
            }
        }

        System.out.println();
    }

    public void sortColors1(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }

        // all in [0, zero) = 0
        // all in [zero, i) = 1
        // all in [two, len - 1] = 2

        // 循环终止条件是 i == two，那么循环可以继续的条件是 i < two
        // 为了保证初始化的时候 [0, zero) 为空，设置 zero = 0，
        // 所以下面遍历到 0 的时候，先交换，再加
        int zero = 0;

        // 为了保证初始化的时候 [two, len - 1] 为空，设置 two = len
        // 所以下面遍历到 2 的时候，先减，再交换
        int two = len;
        int i = 0;
        // 当 i == two 上面的三个子区间正好覆盖了全部数组
        // 因此，循环可以继续的条件是 i < two
        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;
                swap(nums, i, two);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
        System.out.println();
    }

    private static void qsort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = partition(arr, low, high);

        qsort(arr, low, pivot - 1);
        qsort(arr, pivot + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= pivot) {
                low++;
            }

            arr[high] = arr[low];
        }

        arr[low] = pivot;
        return low;
    }
}
