package org.example;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Pair<String> pair1 = new Pair<>("first", "second");
        Pair<Integer> pair2 = new Pair<>(123, 456);
        //调用反射实例化T
//        Pair<String> pair = new Pair(String.class);

        //无法取得带泛型的类型
        Class cls1 = pair1.getClass();
        Class cls2 = pair2.getClass();
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == Pair.class);;

        // 无法判断带泛型的类型
        // 后面写 Pair<Integer> 就会编译不通过
        if (pair1 instanceof Pair<String>) { }

        // 子类继承父类时，会将泛型信息存储在子类中，可获取
        Class<IntPair> intPairClass = IntPair.class;
        Type t = intPairClass.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            Type[] types = pt.getActualTypeArguments();
            Type firstType = types[0];
            Class<?> typeClass = (Class<?>) firstType;
            System.out.println(typeClass);
        }
    }
}

class Pair<T> {
    T first;
    T last;

    // 无法直接实例化T
    // 实际上会出现
    // T first = new Object(); 显然类型不匹配
//    public Pair() {
//        first = new T();
//    }

//    public Pair(Class<T> cls) throws InstantiationException, IllegalAccessException {
//        first = cls.newInstance();
//        last = cls.newInstance();
//    }

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    //实质上擦拭后变为覆写Object的方法
//    public Boolean equals(T t) { return this.first == t; }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }
}

class IntPair extends Pair<Integer> {
    public IntPair(int a, int b) {
        super(a, b);
    }
}