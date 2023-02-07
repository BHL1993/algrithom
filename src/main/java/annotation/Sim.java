package annotation;

/**
 * @author ：BaiHailong
 * @date ：Created in 2022/2/23 5:34 下午
 */
public class Sim {
    public static void main(String[] args) {
        int a = 1;
        change(a);
        System.out.println(a);
    }

    private static void change(int i) {
        i++;
        System.out.println(i);
    }
}
