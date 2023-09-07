package com.itranswarp.learnjava.url;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

public class MyURLBuilder {

    private String scheme = "http";
    private int port = -1;
    private String domain = null;
    private String path = "/";
    private String username = null;
    private String password = null;
    private Map<String, String> query = null;

    public static MyURLBuilder builder () {
        return new MyURLBuilder();
    }

    public String build(){
        StringBuilder sb = new StringBuilder();
        sb.append(scheme).append("://");
        if (username != null && password != null) {
            sb.append(username).append(":").append(password).append("@");
        }
        sb.append(domain);
        if (port >= 0) {
            sb.append(':').append(port);
        }
        sb.append(path);
        if (query != null && !query.isEmpty()) {
            query.forEach((k, v) -> {
                sb.append(k).append("=").append(URLEncoder.encode(v, StandardCharsets.UTF_8));
            });
        }
        return sb.toString();
    }

    public MyURLBuilder setScheme(String scheme) {
        this.scheme = Objects.requireNonNull(scheme);
        return this;
    }

    public MyURLBuilder setDomain(String domain) {
        this.domain = Objects.requireNonNull(domain);
        return this;
    }

    public MyURLBuilder setPath(String path) {
        this.path = Objects.requireNonNull(path);
        return this;
    }

    public MyURLBuilder setQuery(Map<String, String> query) {
        this.query = query;
        return this;
    }

    public MyURLBuilder setPort(int port) {
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port");
        }
        this.port = port;
        return this;
    }

    public MyURLBuilder setCredential(String username, String password) {
        this.username = Objects.requireNonNull(username);
        this.password = Objects.requireNonNull(password);
        return this;
    }

}
