package list;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/12/8 10:21 上午
 */
public class MyForeach {
    private Integer[] arr = new Integer[]{1, 2, 3};

    public void foreach(Consumer<Integer> action) {
        for (Integer integer : arr) {
            /*action.accept(integer);*/
            action.andThen(action);
        }
    }



    public static void main(String[] args) {
        new MyForeach().foreach(r -> System.out.println(r + r));
    }
}
