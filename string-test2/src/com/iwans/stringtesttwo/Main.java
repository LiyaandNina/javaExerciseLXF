package com.iwans.stringtesttwo;

public class Main {
    public static void main(String[] args) {
//        Weekday day = Weekday.SUN;
//        Weekday day2 = Weekday.valueOf("SUN");
//        boolean a = (day == Weekday.SUN);
//        System.out.println(a);
//        Weekday day3 = new Weekday() 错误的，无法new
        WeekDay x = WeekDay.SAT;
        String res = x.name();
        System.out.println("res: " + res);
        System.out.println(x.dayValue);
        System.out.println(x.chinese);
    }
}

enum Weekday {
    SUN, MON, TUE, WES, THU, FRI, SAT
}

enum WeekDay {
    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"),
    FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    public final int dayValue;
    public final String chinese;

    WeekDay(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return this.chinese;
    }
}