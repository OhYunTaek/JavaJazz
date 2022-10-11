package sec04;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

/*
 * Code By OhYunTaek 2022.10.11(화)
 */
// 챕터 13 예제
public class Channel2Demo {
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("D\\Temp\\data.txt");

        FileChannel fc = FileChannel.open(p,
                StandardOpenOption.READ,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE);

        ByteBuffer buf = ByteBuffer.allocate(1024);
        String s = "유유상종.\n Birds of a feather flock together.\n" +
                "시간은 금이다.\n Time is money.";

        buf.put(s.getBytes());

        buf.flip();
        int count = fc.write(buf);
        System.out.println("D:\\Temp\\file.txt에 " + count + "바이트 기록");

        buf.clear();
        fc.read(buf);

        System.out.println(new String(buf.array()));

        fc.close();
    }
}