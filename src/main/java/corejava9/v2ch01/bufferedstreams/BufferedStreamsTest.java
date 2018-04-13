package corejava9.v2ch01.bufferedstreams;

import java.io.*;

/**
 * 1. 如何比较 buffered IO 和 unbuffered IO ?
 * 2. 如何比较 stream IO 和 character IO ?
 */
public class BufferedStreamsTest {

    public static void main(String[] args) throws IOException {

        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            inputStream = new BufferedInputStream(new FileInputStream("file1.txt"));
            outputStream = new BufferedOutputStream(new FileOutputStream("file2.txt"));

            int b;
            while ((b = inputStream.read()) != -1) {
                outputStream.write(b);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        }

        try {
            reader = new BufferedReader(new FileReader("file1.txt"));
            writer = new BufferedWriter(new FileWriter("file3.txt"));

            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.flush();  // 需要主动 flush 吗？
                writer.close();
            }
        }
    }
}
