package corejava9.v2ch01.path;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

    public static void main(String[] args) {

        Path path = Paths.get("/Users/guanghuizeng/workspace/github.com/guanghuizeng/java-gems/xanadu2.txt");
        System.out.println(path.getParent().toString());
        System.out.println(path.getFileName().toString());

        if (path.isAbsolute()) {
            System.out.println(path.toString());
        }

        System.out.println(path.toFile().renameTo(new File(path.getParent().toString() + "/xanadu.txt")));

    }

}
