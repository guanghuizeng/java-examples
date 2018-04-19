package corejava9.v2ch01.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FileAtrributesTest {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/guanghuizeng/workspace/github.com/guanghuizeng/java-gems/xanadu.txt");

        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);

        System.out.printf("size: %d\n", attr.size());
        System.out.printf("isOther: %b\n", attr.isOther());
        System.out.printf("fileKey: %s\n", attr.fileKey());
        System.out.printf("isRegularFile: %b\n", attr.isRegularFile());
        System.out.printf("isSymbolicLink: %b\n", attr.isSymbolicLink());
        System.out.printf("creationTime: %s\n", attr.creationTime());
        System.out.printf("lastAccessTime: %s\n", attr.lastAccessTime().toString());
        System.out.printf("lastModifiedTime: %s\n", attr.lastModifiedTime().toString());


    }
}
