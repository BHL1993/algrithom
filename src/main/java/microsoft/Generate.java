package microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/2/28 1:42 下午
 */
public class Generate {
    public static void main(String[] args) {
        System.out.println(new Generate().generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(Arrays.asList(1));
        if (numRows == 1) {
            return ret;
        }

        ret.add(Arrays.asList(1, 1));
        if (numRows == 2) {
            return ret;
        }

        for (int i = 3; i <= numRows; i++) {
            build(ret, i);
        }

        return ret;
    }

    private void build(List<List<Integer>> ret, int level) {
        List<Integer> pre = ret.get(level - 2);
        List<Integer> list = new ArrayList<>();
        list.add(1);

        for (int i = 1; i < level - 1; i++) {
            list.add(pre.get(i) + pre.get(i - 1));
        }

        list.add(1);
        ret.add(list);
    }
}
