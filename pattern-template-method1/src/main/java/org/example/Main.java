package org.example;

import org.example.template.AbstractSetting;
import org.example.template.LocalSetting;
import org.example.template.RedisSetting;

public class Main {
    public static void main(String[] args) {
        AbstractSetting setting1 = new LocalSetting();
        System.out.println("test = " + setting1.getSetting("test"));
        System.out.println("test = " + setting1.getSetting("test"));
        AbstractSetting setting2 = new RedisSetting();
        System.out.println("autosave = " + setting2.getSetting("autosave"));
        System.out.println("autosave = " + setting2.getSetting("autosave"));
    }
}