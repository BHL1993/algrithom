package jvm.wait;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/11/25 2:06 下午
 */
public class Client1 {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        MyThreadA myThreadA = new MyThreadA(obj);
        MyThreadB myThreadB = new MyThreadB(obj);

        myThreadA.run();
        myThreadB.run();
    }

    static class MyThreadA extends Thread {
        Object obj;

        MyThreadA(Object obj) {
            super();
            this.obj = obj;
        }

        @Override
        public void run() {
            synchronized (obj) {
                try {
                    System.out.println("MyThreadA running.... ");
                    Thread.sleep(2000);
                    System.out.println("MyThreadA going to wait....");
                    obj.wait();
                    System.out.println("MyThreadA wake up....");
                    System.out.println("MyThreadA determined....");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThreadB extends Thread {
        Object obj;

        MyThreadB(Object obj) {
            super();
            this.obj = obj;
        }

        @Override
        public void run() {
            synchronized (obj) {
                try {
                    System.out.println("MyThreadB running.... ");
                    Thread.sleep(2000);
                    System.out.println("MyThreadB going to notify....");
                    obj.notify();
                    System.out.println("MyThreadB notified....");
                    Thread.sleep(2000);
                    System.out.println("MyThreadB determined....");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
