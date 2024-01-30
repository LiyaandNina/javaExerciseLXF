package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewQ {
    public static void main(String[] args) {
        // 模拟按行读取配置文件:
        List<String> props = List.of("profile=native", "debug=true", "logging=warn", "interval=500");
        Map<String, String> config = props.stream()
                                          .map(kv -> {
                                              String[] tmp = kv.split("\\=");
                                              return Map.of(tmp[0], tmp[1]);
                                          }).reduce(new HashMap<String, String>(), (m, kv) -> {
                                              m.putAll(kv);
                                              return m;
                                          });
        config.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });
    }
}
