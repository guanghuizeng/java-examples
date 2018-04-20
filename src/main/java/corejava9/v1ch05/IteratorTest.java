package corejava9.v1ch05;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class IteratorTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");

        list.iterator().forEachRemaining(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
