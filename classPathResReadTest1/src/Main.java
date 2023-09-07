import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        String conf = "C:\\conf\\default.properties";
        try (InputStream input = Main.class.getResourceAsStream("/default.properties")) {
            // TODO:
        }
    }
}