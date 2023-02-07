package sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/1/28 5:20 下午
 */
public class QuickSort {
    private static int partition1(int[] arr, int low, int high) {
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


    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 6, 3, 2, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
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
