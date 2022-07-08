package com.mori.course02.demoenum.domain;

public enum WeekEnum3 {
    MON("星期一") {
        @Override
        public void show() {
            System.out.println("星期一");
        }
    }, TUE("星期二") {
        @Override
        public void show() {
            System.out.println("星期二");
        }
    }, WED("星期三") {
        @Override
        public void show() {
            System.out.println("星期三");
        }
    };

    private String name;

    WeekEnum3(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract void show();
}
