package org.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = (String) request.getSession().getAttribute("user");
        String lang = parseLanguageFromCookie(request);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        if (lang.equals("zh")) {
            pw.write("<h1>你好, " + (user != null ? user : "Guest") + "</h1>");
            if (user == null) {
                pw.write("<p><a href=\"/signin\">登录</a></p>");
            } else {
                pw.write("<p><a href=\"/signout\">登出</a></p>");
            }
        } else {
            pw.write("<h1>Welcome, " + (user != null ? user : "Guest") + "</h1>");
            if (user == null) {
                pw.write("<p><a href=\"/signin\">Sign In</a></p>");
            } else {
                pw.write("<p><a href=\"/signout\">Sign Out</a></p>");
            }
        }
        pw.write("<p><a href=\"/pref?lang=en\">English</a> | <a href=\"/pref?lang=zh\">中文</a>");
        pw.flush();
    }

    private String parseLanguageFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if (cookie.getName().equals("lang")) {
                    return cookie.getValue();
                }
            }
        }
        return  "en";
    }
}
