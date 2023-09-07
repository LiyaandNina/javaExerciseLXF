import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        try(Writer writer = new FileWriter("readme.txt", StandardCharsets.UTF_8)){
            writer.write("Hello\n");
            writer.write("Hello".toCharArray());
            writer.write('H');
        }
    }
}