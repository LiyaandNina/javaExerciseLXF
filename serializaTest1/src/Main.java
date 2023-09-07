import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputBuffer)){
            objectOutputStream.writeUTF("Hello, world!");
            objectOutputStream.writeInt(12345);
            objectOutputStream.writeObject(Double.valueOf(123.456));
        }
        System.out.println(Arrays.toString(outputBuffer.toByteArray()));
        //由于java反序列化是由jvm直接创建对象，存在严重安全隐患，一般不用，建议用json
    }
}