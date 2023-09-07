import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        if(args.length != 2){
            System.err.println("Usage:\n  java CopyFile.java <source> <target>");
            System.exit(1);
        }
        copy(args[0], args[1]);
    }

    static void copy(String source, String target ) throws IOException {
        List<byte> tmpBuffer = new ArrayList();

        //读取原始文件并保存到缓存List中
        try(InputStream sourceInput = new FileInputStream(source); OutputStream targetOutput = new FileOutputStream(target)){
            sourceInput.transferTo(targetOutput);
        }

    }
}