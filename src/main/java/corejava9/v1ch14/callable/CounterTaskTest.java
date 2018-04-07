package corejava9.v1ch14.callable;

import java.util.concurrent.FutureTask;

public class CounterTaskTest {

    public static void main(String[] args) throws Exception { // Callable对象会抛出异常，这和Runnable对象不同

        CounterTask task = new CounterTask();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        Thread thread = new Thread(futureTask);  // Thread初始化时不接收Callable类型对象

        thread.start();
        Integer counter = futureTask.get();
        System.out.println(counter);
    }

}
