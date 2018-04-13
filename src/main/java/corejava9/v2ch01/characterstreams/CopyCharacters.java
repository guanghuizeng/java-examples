package corejava9.v2ch01.characterstreams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 使用 character streams 复制文件内容
 */
public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        FileReader reader = null;
        FileWriter writer = null;

        try {
            reader = new FileReader("file1.txt");
            writer = new FileWriter("file2.txt");

            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}
