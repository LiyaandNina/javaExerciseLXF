package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebFilter(urlPatterns = "/slow/*")
public class CacheFilter implements Filter {
    private Map<String, byte[]> cache = new ConcurrentHashMap<>();

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //获取url路径
        String url = req.getRequestURI();
        //获取缓存内容
        byte[] data = cache.get(url);
        if (data == null) {
            CachedHttpServletResponse wrapper = new CachedHttpServletResponse(resp);
            //让下游组件写入伪造的response
            chain.doFilter(request, wrapper);
            data = wrapper.getContent();
            cache.put(url, data);
        }
        //写入原始的response
        ServletOutputStream output = resp.getOutputStream();
        output.write(data);
        output.flush();
    }

}

class CachedHttpServletResponse extends HttpServletResponseWrapper {
    private boolean open = false;
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    public CachedHttpServletResponse(HttpServletResponse response) {
        super(response);
    }

    //获取Writer
    public PrintWriter getWriter() {
        if (open) {
            throw new IllegalStateException("Cannot re-open writer!");
        }
        open = true;
        return new PrintWriter(output, false, StandardCharsets.UTF_8);
    }

    //获取OutputStream
    public ServletOutputStream getOutputStrem() {
        if (open) {
            throw new IllegalStateException("Cannot re-open output stream!");
        }
        open = true;
        return new ServletOutputStream() {
            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setWriteListener(WriteListener writeListener) {

            }

            //实际写入ByteArrayOutputStream
            @Override
            public void write(int b) throws IOException {
                output.write(b);
            }
        };
    }

    //返回写入的Byte[]
    public byte[] getContent() {
        return output.toByteArray();
    }
}
