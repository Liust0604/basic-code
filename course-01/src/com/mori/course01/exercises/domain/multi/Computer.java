package com.mori.course01.exercises.domain.multi;

public class Computer {
    public void PowerOn() {
        System.out.println("打开笔记本电脑…");
    }

    public void PowerOff() {
        System.out.println("关闭笔记本电脑…");
    }

    public void useUSBDevice(USB usb) { //传参是接口，若传入USB类型则就按USB类型，若传入USB接口的实现类，会先向上转型为USB类型
        usb.openUSB();
        //要先判断，再向下转型
        if (usb instanceof Mouse) {
            Mouse mouse = (Mouse) usb;
            mouse.click();
        } else if (usb instanceof KeyBoard) {
            KeyBoard keyBoard = (KeyBoard) usb;
            keyBoard.type();
        }
        usb.closeUSB();
    }
}
