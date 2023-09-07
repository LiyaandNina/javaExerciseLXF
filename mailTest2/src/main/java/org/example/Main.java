package org.example;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


public class Main {
    public static void main(String[] args) throws Exception {
        String smtp = "smtp.163.com";
        String userName = "liyaandnina@163.com";
        String password = "CBRJUMGCVKFXYHES";
        Properties props = new Properties();
        props.put("mail.smtp.host", smtp); // SMTP主机名
        props.put("mail.smtp.port", "465"); // 主机端口号
        props.put("mail.smtp.auth", "true"); // 是否需要用户认证
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("liyaandnina@163.com"));
        message.setRecipients(Message.RecipientType.TO, "kekai.sun@wibu.com.cn");
        message.setSubject("Hello", "UTF-8");
        message.setText("hi, test.", "UTF-8");
        Transport.send(message);
    }
}