package org.example.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/slow/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        //模拟运行1s
        try {
            Thread.sleep(1000);
        } catch (InterruptedException  e) {
        }

        PrintWriter pw = response.getWriter();
        pw.write("<h1>Hello, world!</h1>");
        pw.flush();
    }
}
