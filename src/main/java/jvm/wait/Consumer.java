package jvm.wait;

import java.util.Queue;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/11/25 2:00 下午
 */
public class Consumer extends Thread {
    Queue queue;//队列定义，存放数据

    int maxSize = 0;//容量声明

    public Consumer(Queue queue, int maxSize, String name) {//创建线程对象构造函数
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("队列为空！消费者在等待生产者生产！");
                        queue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("customer value:" + queue.remove());
                queue.notifyAll();
            }
        }
    }
}
