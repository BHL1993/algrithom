package jvm.wait;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/11/25 2:30 下午
 */
public class TestWaitNotify {
    public static void main(String[] args) {
        Object lock = new Object();
        WaitThread t1 = new WaitThread(lock);
        NotifyThread t2 = new NotifyThread(lock);
        t1.start();
        t2.start();
    }
}
