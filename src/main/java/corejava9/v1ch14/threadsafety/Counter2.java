package corejava9.v1ch14.threadsafety;

public class Counter2 {

    public void count() {
        int num = 0; // 把int变量放到线程内存中
        for (int i = 0; i < 100; i++) {
            num = num + 1;
        }
        System.out.println(Thread.currentThread().getName() + " - " + num);
    }
}
