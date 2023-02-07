package algorithm;

import java.util.Arrays;

/**
 * @author ：BaiHailong
 * @date ：Created in 2022/1/14 11:18 上午
 */
public class FindOnlyOne {
    public static int find2(int[] arr) {
        int[] tmp = new int[100];

        for (int i = 0; i < arr.length; i++) {
            if (tmp[arr[i]] == 0) {
                tmp[arr[i]] = 1;
            } else {
                tmp[arr[i]] = 0;
            }
        }

        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == 1) {
                return i;
            }
        }
        return 0;
    }

    public static int find(int[] arr) {
        Arrays.sort(arr);
        int ret = 0;
        for (int i = 0; i < arr.length; i = i + 2) {
            if (i == arr.length - 1 || (arr[i] != arr[i + 1])) {
                ret = arr[i];
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{1, 3, 4, 4, 3, 1, 2}));
        System.out.println(find2(new int[]{1, 3, 4, 2, 4, 3, 1}));
    }
}
