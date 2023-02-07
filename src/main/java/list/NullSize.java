package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：BaiHailong
 * @date ：Created in 2022/8/4 10:12 上午
 */
public class NullSize {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        System.out.println(list.size());

        list.add(null);

        System.out.println(list.size());
    }
}
