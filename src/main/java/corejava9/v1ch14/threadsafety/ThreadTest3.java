package corejava9.v1ch14.threadsafety;

public class ThreadTest3 {

    public static void main(String[] agrs) {
        Runnable runnable = new Runnable() {
            Counter2 counter = new Counter2();   // 不同线程使用同一个Counter对象，但counter中的num值是在线程内存中，所以是线程安全的。
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
}
