import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
//        String f = "./res/settings.properties";
//        Properties conf = new Properties();
//        conf.load(new java.io.FileInputStream(f));
//        System.out.println(conf.getProperty("port"));
//        System.out.println(conf.getProperty("build", "6060"));

//        //load InputStream 默认读取ascii
//        String settings = "# test" + "\n" + "course=Java" + "\n" + "last_open_date=2019-08-07T12:35:01";
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(settings.getBytes("UTF-8"));
//        Properties props = new Properties();
//        props.load(inputStream);
//
//        System.out.println("course: " + props.getProperty("course"));
//        System.out.println("last_open_date: " + props.getProperty("last_open_date"));
//        System.out.println("last_open_file: " + props.getProperty("last_open_file"));
//        System.out.println("auto_save: " + props.getProperty("auto_save", "60"));

        //load FileReader 重载方法可以读取utf-8
        FileReader conf = new FileReader("./res/settings.properties", StandardCharsets.UTF_8);
        Properties props = new Properties();
        props.load(conf);
        props.setProperty("url", "测试");
        props.store(new FileWriter("./res/settings.properties", StandardCharsets.UTF_8), "测试中文");
        props.setProperty("url1", "测试2");
        props.store(new FileOutputStream("./res/settings.properties"), "test chinese");
    }

}