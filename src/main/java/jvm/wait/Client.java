package jvm.wait;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/11/25 2:02 下午
 */
public class Client {
    public static void main(String[] args) {
        Queue queue=new LinkedList();
        int maxSize=10;

        Producer producer=new Producer(queue, maxSize, "product");
        Consumer consumer=new Consumer(queue, maxSize, "customer");

        producer.start();
        consumer.start();
        System.out.println("end-----");
    }
}
