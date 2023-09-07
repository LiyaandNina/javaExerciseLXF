import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] data = Files.readAllBytes(Path.of("./res/test.txt"));
        System.out.println(new String(data, "UTF-8"));
        String files1 = Files.readString(Path.of("./res/test.txt"));
        String files2 = Files.readString(Path.of("./res", "test.txt"), StandardCharsets.UTF_8);
        List<String> lines = Files.readAllLines(Path.of("./res/test.txt"));
    }
}