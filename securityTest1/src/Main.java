import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
//        String encoded = URLEncoder.encode("中文字符", StandardCharsets.UTF_8);
//        System.out.println("en: " + encoded);
//        String decoded = URLDecoder.decode(encoded, StandardCharsets.UTF_8);
//        System.out.println("de: " + decoded);
//        byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad, 0x21 };
//        String b64encode1 = Base64.getEncoder().encodeToString(input);
//        String b64encode2 = Base64.getEncoder().withoutPadding().encodeToString(input);
//        System.out.println(b64encode1);
//        System.out.println(b64encode2);
//        byte[] d1 = Base64.getDecoder().decode(b64encode1);
//        byte[] d2 = Base64.getDecoder().decode(b64encode2);
//        System.out.println(Arrays.toString(d1));
//        System.out.println(Arrays.toString(d2));

        MessageDigest md1 = MessageDigest.getInstance("SHA-256");
        md1.update("Hello".getBytes());
        md1.update("World".getBytes());
        byte[] result = md1.digest();
        System.out.println(Arrays.toString(result));
        System.out.println(new BigInteger(1, result).toString(16));
        System.out.println(new BigInteger(1, result));
    }
}