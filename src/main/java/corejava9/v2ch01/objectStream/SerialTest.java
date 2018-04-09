package corejava9.v2ch01.objectStream;

import java.io.*;

public class SerialTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // write();

        // 中间修改serialVersionUID, 会导致解析失败, 报错信息：
        // Exception in thread "main" java.io.InvalidClassException: corejava9.v2ch01.objectStream.SerialA; local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID = 2
        read();
    }

    public static void write() throws IOException {
        SerialA serialA = new SerialA();
        serialA.setName("test");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("SerialA.dat"))) {
            out.writeObject(serialA);
        }
    }

    public static void read() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("SerialA.dat"))) {
            SerialA serialA = (SerialA) in.readObject();
            System.out.println(serialA);

        }
    }
}
