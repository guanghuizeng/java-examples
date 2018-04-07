package corejava9.v1ch14.threadsafety;

public class Counter {

    private int num; // 不同Counter对象使用相同的int变量

    public void count() {
        for (int i = 0; i < 1000; i++) {
            num = num + 1;
        }
        System.out.println(Thread.currentThread().getName() + " - " + num);
    }
}
