package corejava9.v2ch01.scanning;

import java.io.*;
import java.util.Scanner;

public class ScanXan {

    public static void main(String[] args) throws IOException {
        Scanner scanner = null;

        try {
            PrintStream printStream = new PrintStream(new FileOutputStream("ints.txt"));

            int[] ints = {1, 2, 3, 4, 5};
            for (int i = 0; i < 5; i++) {
                printStream.print(ints[i]);
            }
            printStream.close();

            scanner = new Scanner(new BufferedReader(new FileReader("ints.txt")));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }

        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}

/*
    这是 hexdump ints.txt 后的结果

    0000000 31 32 33 34 35
    0000005
 */