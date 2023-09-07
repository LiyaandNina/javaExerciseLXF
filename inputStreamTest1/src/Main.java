import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        readFile();
        byte[] data = { 72, 101, 108, 108, 111, 33 };
        try(InputStream inputStream = new ByteArrayInputStream(data)){
            int n;
            while ((n = inputStream.read()) != -1){
                System.out.println((char) n);
            }
        }
    }

    static void readFile() throws IOException{
        try(InputStream inputStream = new FileInputStream("./README.MD");){
            byte[] buffer = new byte[1000];
            int tmp;
            while ((tmp = inputStream.read(buffer)) != -1){
                System.out.println("read " + tmp + " bytes");
            }
        }
    }
}