package jvm.wait;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/11/25 2:28 下午
 */
public class NotifyThread extends Thread {
    private final Object lock;

    public NotifyThread(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            // 做一些业务逻辑相关的事。。。。
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 业务逻辑完成了...
            System.out.println("开始 notify time= " + System.currentTimeMillis());
            lock.notify();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("结束 notify time= " + System.currentTimeMillis());
        }
    }
}
