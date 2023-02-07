package jvm.wait;

import java.util.Queue;
import java.util.Random;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/11/25 1:57 下午
 */
public class Producer extends Thread{
    Queue queue;//队列定义，存放数据

    int maxSize=0;//容量声明

    public Producer(Queue queue,int maxSize,String name) {//创建线程对象构造函数
        super(name);
        this.queue=queue;
        this.maxSize=maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("队列已经满了！生产者在等待消费者消耗！");
                        queue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                Random random = new Random();
                int a = random.nextInt();
                System.out.println("Product value:" + a);
                queue.add(a);
                queue.notifyAll();//队列满了时通知消费者线程开始执行
            }
        }
    }
}
