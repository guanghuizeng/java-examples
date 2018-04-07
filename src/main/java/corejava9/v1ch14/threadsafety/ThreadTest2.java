package corejava9.v1ch14.threadsafety;

public class ThreadTest2 {

    public static void main(String[] agrs) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Counter counter = new Counter();   // 不同线程使用不同的Counter对象。这样是线程安全的
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
