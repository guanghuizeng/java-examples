package corejava9.v1ch14.threadlocal;

public class ThreadLocalTest {

    private ThreadLocal<Long> threadId = new ThreadLocal<>();
    private ThreadLocal<String> threadName = new ThreadLocal<>();

    public void set() {
        threadId.set(Thread.currentThread().getId());
        threadName.set(Thread.currentThread().getName());
    }

    public Long getThreadId() {
        return threadId.get();
    }

    public String getThreadName() {
        return threadName.get();
    }

    public static void main(String[] args) throws Exception {
        final ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        threadLocalTest.set();

        System.out.println("id: " + threadLocalTest.getThreadId());
        System.out.println("name: " + threadLocalTest.getThreadName());

        Thread thread = new Thread() {
            @Override
            public void run() {
                threadLocalTest.set();
                System.out.println("id: " + threadLocalTest.getThreadId());
                System.out.println("name: " + threadLocalTest.getThreadName());

            }
        };

        thread.start();
        thread.join();  // 为什么要执行join？

        System.out.println("id: " + threadLocalTest.getThreadId());
        System.out.println("name: " + threadLocalTest.getThreadName());

        /* output:

            id: 1
            name: main
            id: 10
            name: Thread-0
            id: 1
            name: main

         */
    }


}
