import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException{
        InputStream input = new ByteArrayInputStream("Hello".getBytes());
        try(Reader reader = new InputStreamReader(input, StandardCharsets.UTF_8)){
            char[] buffer = new char[1000];
            int n = 0;
            while ((n = reader.read(buffer)) != -1){
                System.out.println("read " + n + " chars.");
            }
        }
    }
}