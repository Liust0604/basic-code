package com.mori.designmode.proxy;

/**
 * 代理模式中的 真实类
 */
public class Lenovo implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println("花费" + money + "元，购买一台电脑。");
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑…");
    }
}
