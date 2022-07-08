package com.mori.course02.demothread.domain;

/**
 * 资源类：属性和状态
 */
public class BaoZi {

    private String pi; // 皮

    private String xian; //陷

    private boolean flag = false; //资源状态：初始值为没有，可以先执行生产者任务

    public BaoZi() {

    }

    public BaoZi(String pi, String xian) {
        this.pi = pi;
        this.xian = xian;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public String getXian() {
        return xian;
    }

    public void setXian(String xian) {
        this.xian = xian;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
