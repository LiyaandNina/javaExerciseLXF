package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class HttpMyTest {

    static HttpClient httpClient = HttpClient.newBuilder().build();

    public static void main(String[] args) throws Exception{
        System.out.println("start my http test.");
        httpGet("https://www.sina.com.cn/");
        httpPost("https://accounts.douban.com/j/mobile/login/basic",
                "name=bob%40example.com&password=12345678&remember=false&ck=&ticket=");
        httpGetImage("https://img.t.sinajs.cn/t6/style/images/global_nav/WB_logo.png");
    }

    static void httpGet(String url) throws Exception{
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                                         .header("User-Agent", "Java HttpClient")
                                         .header("Accept", "*/*")
                                         .timeout(Duration.ofSeconds(5))
                                         .version(HttpClient.Version.HTTP_2).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body().substring(0, 1024) + "\n...");
    }

    static void httpPost(String url, String body) throws Exception{
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                .header("User-Agent", "Mozilla/5.0 (compatible, MSIE 11, Windows NT 6.3; Trident/7.0) like Gecko")
                .header("Accept", "*/*")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .timeout(Duration.ofSeconds(5))
                .version(HttpClient.Version.HTTP_2)
                .POST(HttpRequest.BodyPublishers.ofString(body, StandardCharsets.UTF_8))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    static void httpGetImage(String url) throws Exception{
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                .header("User-Agent", "Java HttpClient")
                .header("Accept", "*/*")
                .timeout(Duration.ofSeconds(5))
                .version(HttpClient.Version.HTTP_2)
                .build();
        HttpResponse<InputStream> response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());
        BufferedImage image = ImageIO.read(response.body());
        ImageIcon imageIcon = new ImageIcon(image);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(200,100);
        JLabel label = new JLabel(imageIcon);
        frame.add(label);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
