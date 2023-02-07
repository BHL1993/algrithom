package sort;

/**
 * @author ：BaiHailong
 * @date ：Created in 2022/8/12 9:53 上午
 */
public class Client {
    public static void main(String[] args) {
        String s0 = "kvill";
        String s1 = new String("kvill");
        String s2 = new String("kvill");
        System.out.println(s0 == s1); //false
        s1.intern();
        s2 = s2.intern(); //把常量池中“kvill”的引用赋给s2
        System.out.println(s0 == s1); //false
        System.out.println(s0 == s1.intern()); //true
        System.out.println(s0 == s2);//true


    }
}
