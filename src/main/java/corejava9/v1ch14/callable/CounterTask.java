package corejava9.v1ch14.callable;

import java.util.concurrent.Callable;

public class CounterTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count = count + 1;
        }
        return count;
    }
}
