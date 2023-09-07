package org.example;

import java.math.BigInteger;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.generate(new MyCode());
        stream.limit(100).forEach(System.out::println);
    }
}

class MyCode implements Supplier<Integer>{
    private int a = 0;
    private int b = 0;
    @Override
    public Integer get(){
        if (this.a == 0){
            this.a++;
            return this.a;
        }

        if (this.b == 0){
            this.b++;
            return this.b;
        }

        int res = this.a + this.b;
        this.a = this.b;
        this.b = res;
        return res;
    }
}