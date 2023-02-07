package jvm;


import org.openjdk.jol.info.ClassLayout;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/10/19 9:49 上午
 */
public class JolExample {
    static MarkWord markWord1;

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000l);
        markWord1 = new MarkWord();

        System.out.println("before lock");
        System.out.println(ClassLayout.parseInstance(markWord1).toPrintable());

        sync();

        System.out.println("after lock");
        System.out.println(ClassLayout.parseInstance(markWord1).toPrintable());
    }

    public static void sync() {
        synchronized (markWord1) {
            System.out.println("locking");
            System.out.println(ClassLayout.parseInstance(markWord1).toPrintable());
        }
    }
}
