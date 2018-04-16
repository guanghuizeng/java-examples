package corejava9.v2ch01.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

    public static void main(String[] args) {

        Path path = Paths.get("/Users/guanghuizeng/workspace/github.com/guanghuizeng/java-gems/xanadu2.txt");

        System.out.format("toString: %s\n", path.toString());
        System.out.format("getFileName: %s\n", path.getFileName().toString());
        System.out.format("getParent: %s\n", path.getParent().toString());
        System.out.format("getRoot: %s\n", path.getRoot().toString());



    }

}
