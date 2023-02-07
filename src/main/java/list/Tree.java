package list;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/12/8 10:57 上午
 */
public class Tree {
    public void just(Mountain mountain) {
        System.out.println("x3");
        mountain.say();
    }

    public static void main(String[] args) {
       new Tree().just(() -> System.out.println("x1"));
    }
}
