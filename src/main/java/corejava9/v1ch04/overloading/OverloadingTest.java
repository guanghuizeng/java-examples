package corejava9.v1ch04.overloading;

public class OverloadingTest {
    private String name;
    public OverloadingTest() {
    }
    // 利用了 Overloading 机制
    public OverloadingTest(String name) {
        this.name = name;
    }
    public String test() {
        return "hello";
    }
}
class OverrideTest extends OverloadingTest {
    // Override, 重写了test函数
    public String test() {
        return "world";
    }
}
