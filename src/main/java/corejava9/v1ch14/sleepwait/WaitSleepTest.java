package corejava9.v1ch14.sleepwait;


public class WaitSleepTest {

    public static void main(String[] args) {
        new Thread(new Task1()).start();
        try {
            Thread.sleep(5000);  // 当前线程停止运行
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(new Task2()).start();
    }

    private static class Task1 implements Runnable {
        @Override
        public void run() {
            // 使用WaitSleepTest.class对象锁
            synchronized (WaitSleepTest.class) {
                System.out.println("enter thread1...");
                System.out.println("thread1 is waiting...");

                try {
                    WaitSleepTest.class.wait();  // 放弃WaitSleepTest.class的对象锁
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // 如果注释掉 WaitSleepTest.class.wait(); 语句，那么由于加锁的原因两个线程里的方法将顺序运行。

                System.out.println("thread1 is going on ....");
                System.out.println("thread1 is over!!!");
            }
        }
    }

    private static class Task2 implements Runnable {
        @Override
        public void run() {
            // 使用WaitSleepTest.class对象锁
            synchronized (WaitSleepTest.class) {
                System.out.println("enter thread2....");
                System.out.println("thread2 is sleep....");

                // 调用notify()方法后，线程Thread1进入对象锁定池准备获取对象锁进入运行状态
                WaitSleepTest.class.notify();

                // 区别
                // 如果我们注释掉这一行代码：WaitSleepTest.class.notify();，即在线程Thread1调用了WaitSleepTest.class.wait()方法，
                // 但是没有调用notify()方法，则线程Thread1永远处于挂起状态。

                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("thread2 is going on....");
                System.out.println("thread2 is over!!!");
            }
        }
    }
}
