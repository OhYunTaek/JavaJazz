import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * Code By OhYunTaek 2022.10.11(화)
 */
// 챕터 13 도전과제
public class P558Ex1 {
    public static void main(String[] args) {
        String fileName = "D:\\temp\\file.txt";

        try {
            byte[] buf = new byte[100];

            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);

            while (bis.read(buf) != -1)
                System.out.print(new String(buf));

            fis.close();
            bis.close();
        } catch (FileNotFoundException ex) {
            System.out.println(fileName + " 파일을 열 수 없습니다");
        } catch (IOException ex) {
            System.out.println(fileName + "파일을 읽을 수 없습니다");
        }
    }
}