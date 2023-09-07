package org.example;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Address[] addresses = new Address[]{new Address("湖南省", "长沙市", "岳麓区"), new Address("湖南省", "长沙市", "雨花区"), new Address("湖南省", "永州市", "零陵区"), new Address("湖南省", "永州市", "冷水滩区"), new Address("江苏省", "南京市", "建邺区"), new Address("江苏省", "南京市", "秦淮区"), new Address("江苏省", "苏州市", "吴江区"), new Address("江苏省", "苏州市", "姑苏区"),};
        Map<String, Map<String, List<Address>>> addressGrouping = Arrays.stream(addresses)
                                                                        .collect(Collectors.groupingBy(Address::province, Collectors.groupingBy(Address::city)));
        System.out.println(addressGrouping);
    }
}

record Address(String province, String city, String district) {
    @Override
    public String province() {
        return province;
    }

    @Override
    public String city() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" + "province='" + province + '\'' + ", city='" + city + '\'' + ", district='" + district + '\'' + '}';
    }
}