package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewR {
    public static void main(String[] args) {
        // 模拟按行读取配置文件:
        List<String> props = List.of("profile=native", "debug=true", "logging=warn", "interval=500");
        Map<String, String> map = props.stream()
                                       .map(s -> s.split("\\="))
                                       .map(s -> Map.of(s[0], s[1]))
                                       .reduce(new HashMap<>(), (m, kv) -> {
                                           m.putAll(kv);
                                           return m;
                                       });
        map.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}
