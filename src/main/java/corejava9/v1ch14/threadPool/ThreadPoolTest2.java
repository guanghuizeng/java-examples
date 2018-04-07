package corejava9.v1ch14.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest2 {

    public static void main(String[] agrs) {

        // 创建线程池的5中方式

        ExecutorService cachedPool = Executors.newCachedThreadPool();
        ExecutorService fixedPool = Executors.newFixedThreadPool(10);
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        ExecutorService scheduledPool = Executors.newScheduledThreadPool(10);
        ExecutorService workStealPool = Executors.newWorkStealingPool();

    }
}
