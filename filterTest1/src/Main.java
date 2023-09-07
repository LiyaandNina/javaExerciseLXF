import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        byte[] buffer = "Hello, world!".getBytes("UTF-8");
        try(CountFileInputStream inputStream = new CountFileInputStream(new ByteArrayInputStream(buffer))){
            int n;
            while ((n = inputStream.read()) != -1){
                System.out.println((char) n);
            }
            System.out.println("Counts: " + inputStream.getCount());
        }
    }
}

class CountFileInputStream extends FilterInputStream {
    private int count = 0;

    CountFileInputStream(InputStream inx){
        super(inx);
    }

    public int getCount(){
        return this.count;
    }

    @Override
    public int read() throws IOException {
        int n = in.read();
        if(n != -1){
            this.count ++;
        }
        return n;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int n = in.read(b, off, len);
        if (n != -1){
            this.count += n;
        }
        return n;
    }
}