package algorithm;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：BaiHailong
 * @date ：Created in 2022/9/6 8:40 下午
 */
public class CommonArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{9, 4, 9, 8, 4};
        int[] arr2 = new int[]{4, 9, 5};
        System.out.println(JSON.toJSONString(common(arr1, arr2)));
    }

    public static int[] common(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = arr2HashMap(nums1);
        HashMap<Integer, Integer> map2 = arr2HashMap(nums2);

        List<Integer> retList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer key = entry.getKey();
            Integer cnt = entry.getValue();

            Integer map2Value = map2.get(key);

            if (map2Value != null) {
                if (cnt >= map2Value) {
                    while (map2Value > 0) {
                        retList.add(key);
                        map2Value--;
                    }
                } else {
                    while (cnt > 0) {
                        retList.add(key);
                        cnt--;
                    }
                }
                map2.remove(key);
            }
        }

        int[] ret = new int[retList.size()];
        for (int i = 0; i < retList.size(); i++) {
            ret[i] = retList.get(i);
        }

        return ret;
    }

    public static HashMap<Integer, Integer> arr2HashMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            Integer cnt = map.get(i);
            if (cnt == null) {
                map.put(i, 1);
            } else {
                map.put(i, cnt + 1);
            }
        }

        return map;
    }
}
