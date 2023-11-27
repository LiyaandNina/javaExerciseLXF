package org.example.service;

import org.example.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class UserService {
    private List<User> users = List.of(
            new User(1, "bob@example.com", "password", "bob"),
            new User(2, "alice@example.com", "password", "alice")
    );

    @Autowired(required = false)
    private MailService mailService;

    @Autowired
    private ZoneId zoneId;

    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                if (mailService != null) {
                    mailService.sendMail(user.getEmail(), "Login successfully",
                            "Hi, you have logged in at " + ZonedDateTime.now(this.zoneId).format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
                } else {
                    System.out.println("skip send email.");
                }
                return user;
            }
        }
        throw new RuntimeException("login failed.");
    }
}
