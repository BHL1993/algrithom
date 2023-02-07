package jvm.wait;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/11/25 2:30 下午
 */
public class WaitThread extends Thread {
    private final Object lock;

    public WaitThread(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                long start = System.currentTimeMillis();
                System.out.println("开始 wait time= " + start);
                lock.wait();
                long end = System.currentTimeMillis();
                System.out.println("结束 wait time= " + end);
                System.out.print("wait time = " + (end - start));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
