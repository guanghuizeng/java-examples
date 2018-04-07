package corejava9.v1ch14.threadsafety;

public class ThreadTest {

    public static void main(String[] agrs) {
        Runnable runnable = new Runnable() {
            Counter counter = new Counter();   // 不同线程使用同一个Counter对象
            @Override
            public void run() {
                counter.count();
            }
        };

        // 启动10个线程
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    /*
     *

     第一次执行结果：

     Thread-1 - 2000
     Thread-0 - 2000
     Thread-2 - 3000
     Thread-3 - 4000
     Thread-4 - 5000
     Thread-5 - 6000
     Thread-6 - 7000
     Thread-7 - 8000
     Thread-8 - 9000
     Thread-9 - 10000

     第二次执行结果：

     Thread-0 - 1000
     Thread-1 - 2000
     Thread-2 - 3000
     Thread-3 - 4000
     Thread-4 - 5000
     Thread-5 - 6000
     Thread-6 - 7000
     Thread-7 - 8000
     Thread-8 - 9000
     Thread-9 - 10000

     上面两次输出中 Thread-1 的结果不一样，体现了线程不安全。

     */
}
