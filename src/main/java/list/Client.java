package list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/12/7 8:17 下午
 */
public class Client {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(11);
        System.out.println(a.stream().filter((r) -> r > 12).anyMatch(k -> k > 13));
        System.out.println(a.stream().filter(r -> r > 12).collect(Collectors.toList()));

        a.sort((r1, r2) -> r1 * r1 - r2);


    }
}
