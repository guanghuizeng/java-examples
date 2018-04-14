package corejava9.v2ch01.datastream;

import java.io.*;

/**
 * scanner 和 data stream 有什么差异？
 */
public class DataStreamTest {

    public static void main(String[] args) throws IOException {
        DataOutputStream out = null;
        DataInputStream in = null;

        try {
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("ints.txt")));

            int[] ints = {1, 2, 3, 4, 5};
            for (int i = 0; i < 5; i++) {
                out.writeInt(ints[i]);
            }

            out.close();

            in = new DataInputStream(new BufferedInputStream(new FileInputStream("ints.txt")));

            int i;
            while (true) {
                i = in.readInt();
                System.out.println(i);
            }
        } catch (EOFException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        }
    }
}

/*
    这是 hexdump ints.txt 后的结果

    0000000 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 04
    0000010 00 00 00 05
    0000014

 */