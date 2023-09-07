package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class Main {

    public static void main(String[] args) {
        log("[{}] start {} at {}...", LocalTime.now().withNano(0), "engine", LocalDate.now());
    }

    static void log(String format, Object... args) {
        //to do
        int len = format.length();
        char last = '\0';
        int argsIndex = 0;
        StringBuilder sb = new StringBuilder(len + 20);
        for(int i = 0; i < len; i++) {
            char ch = format.charAt(i);
            if (ch == '}') {
                if (last == '{') {
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(args[argsIndex]);
                    argsIndex++;
                } else {
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
            last = ch;
        }
        System.out.println(sb);
    }
}