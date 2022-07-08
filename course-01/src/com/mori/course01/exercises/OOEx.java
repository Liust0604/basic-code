package com.mori.course01.exercises;

import com.mori.course01.exercises.domain.classobj.Person;
import com.mori.course01.exercises.domain.classobj.Phone;
import com.mori.course01.exercises.domain.classobj.Student2;
import com.mori.course01.exercises.domain.extendsex.*;
import com.mori.course01.exercises.domain.extendsinterface.MyInterfaceConst;
import com.mori.course01.exercises.domain.extendsinterface.MyInterfaceStatic;
import com.mori.course01.exercises.domain.extendsinterface.impl.MyInterfaceAbstractImpl;
import com.mori.course01.exercises.domain.extendsinterface.impl.MyInterfaceDefaultAImpl;
import com.mori.course01.exercises.domain.extendsinterface.impl.MyInterfaceDefaultBImpl;
import com.mori.course01.exercises.domain.innerclass.AnonymousInterface;
import com.mori.course01.exercises.domain.innerclass.Body;
import com.mori.course01.exercises.domain.innerclass.Outer;
import com.mori.course01.exercises.domain.innerclass.impl.AnonymousInterfaceImpl;
import com.mori.course01.exercises.domain.multi.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class OOEx {

    /*********类和对象**********/

    //面向对象
    @Test
    public void test01() {
        printArr(new int[]{1, 2, 3, 4, 5});
    }

    public void printArr(int[] array) {
        //面向过程:通过循环遍历打印，注意到过程中的每一个细节
        //面向对象:通过Arrays对象打印
        System.out.println(Arrays.toString(array));
    }

    //类实例化对象Phone
    @Test
    public void test02() {
        Phone phone = new Phone();

        System.out.println(phone.brand);//默认值null
        System.out.println(phone.price);//默认值0.0

        System.out.println("==================");
        phone.brand = "apple";
        phone.price = 6750.80;
        System.out.println(phone.brand);
        System.out.println(phone.price);

        System.out.println("==================");
        phone.call("Nana");
        phone.sendMsg();
    }

    //关键字对类的影响

    /**
     * 私有private
     */
    @Test
    public void private01() {
        Person person = new Person();//无参构造
        Person person1 = new Person("小红", 16, false);//全参构造
        //person.age =;   直接访问private内容，是错误写法！
        //需要通过方法访问private的内容
        person.setName("小明");
        //person.setAge(-20);
        person.setAge(18);
        person.setMale(true);
        person.show();
        System.out.println(person.getName());
        System.out.println(person.isMale());

        person.sayHello("小红");
        System.out.println(person);
    }

    /**
     * 匿名(Anonymous)对象
     */
    @Test
    public void anonymous01() {
        new Person().setName("小李");
    }

    /**
     * 静态Static
     */
    @Test
    public void static01() {
        Student2 stu1 = new Student2("小明", 18);
        Student2 stu2 = new Student2("小红", 16);

        stu1.room = "国际英语101";
        System.out.println(Student2.room);
        System.out.println(stu1.getName() + " 年龄：" + stu1.getAge() + "，学号：" + stu1.getId() + "，教室：" + stu1.room);
        System.out.println(stu2.getName() + " 年龄：" + stu2.getAge() + "，学号：" + stu2.getId() + "，教室：" + stu2.room);

        System.out.println("==============");

        //普通方法
        Student2 stu3 = new Student2("小李", 11);
        stu3.method();
        //静态方法
        stu3.methodStatic();
        Student2.methodStatic();  //推荐

    }

    /**
     * 静态代码块，优先于构造方法执行，只执行一次。
     * 因为是静态的内容是属于类的，所以static随着class只在工作区的时候加载一次，然后才执行构造方法
     */
    @Test
    public void static02() {
        Student2 stu1 = new Student2();
        Student2 stu2 = new Student2();

        //每执行一次构造方方法，类中的静态idCounter加一，最后得到的是类创建的所有对象的数量
        System.out.println("stu1:" + stu1.getIdCounter());
        System.out.println("stu2:" + stu2.getIdCounter());
    }

    /*********继承**********/

    /**
     * 继承
     */
    @Test
    public void extends01() {
        //创建一个子类对象
        Teacher teacher = new Teacher();
        //Teacher类中什么都没写，但是会继承父类Employee中的方法。
        //若父类的方法为private、protected则报红，private只能自己本类使用
        teacher.method();
    }

    /**
     * 继承：访问成员变量
     */
    @Test
    public void extends02() {
        Father f = new Father();
        System.out.println(f.numF); //父类对象只能使用父类内容，没有任何子类内容
        Children c = new Children();
        System.out.println(c.numF + " " + c.numC); // 子类可以用父类和子类的内容

        System.out.println("========");

        // 成员变量重名的情况
        // 方法，用谁谁优先，没有向上找
        // 直接使用成员变量，对象是谁就用谁的成员变量
        System.out.println(c.num);  //左边子，子优先，200
        System.out.println(f.num);  //左边父，父优先，100
        //System.out.println(c.abc);  //父子都没有，报错！
        // 间接(通过方法)使用成员变量，方法是谁的就用谁的成员变量
        // 只有找不到的时候才向上找，本类中有成员变量的时候直接用本类的即可
        f.methodF();    //父的方法，找父类的变量，100
        c.methodF();    //子用父类的方法，找父类的变量，100
        c.methodC();    //子用子类的方法，找子类的变量，200
    }

    /**
     * 继承：访问局部变量
     */
    @Test
    public void extends03() {

        //num重名：父类的成员变量，子类的成员变量，子类的局部变量
        Children c = new Children();
        c.method();
    }

    /**
     * 继承：成员方法
     */
    @Test
    public void extends04() {
        //成员方法同名
        Children c = new Children();
        c.methodover(); //子类有该方法，用子类的
        c.methodF();    //子类没有该方法，向上找，父类有用父类的
    }

    /**
     * 继承：重写
     */
    @Test
    public void override01() {
        OldPhone phone = new OldPhone();
        phone.call();
        phone.send();
        phone.show();
        System.out.println("=====");
        NewPhone newphone = new NewPhone();
        newphone.call();
        newphone.send();
        newphone.show();
    }

    /**
     * 重写：访问构造方法
     */
    @Test
    public void override02() {
        //继承：super的用法
        NewPhone newphone = new NewPhone();
        newphone.methodZi();
    }

    /**
     * this的用法
     */
    @Test
    public void override03() {
        Zi zi = new Zi();
        zi.showNum();
    }

    /**
     * 抽象
     */
    @Test
    public void abstract01() {
        //Animal animal = new Animal(); // 错误写法！不能直接new创建一个抽象类对象
        Cat cat = new Cat();
        cat.eat();
        System.out.println("===");
        DogGolden golden = new DogGolden(); //孙子类
        golden.eat();
        golden.sleep();
        DogErHa erHa = new DogErHa();
        erHa.eat();
        erHa.sleep();
    }

    /**
     * 继承案例：群主发红包
     * 1、群主发出红包，群主余额扣除一笔金额
     * 2、金额分成n等分
     * 3、成员领取红包，成员余额增加
     * 逻辑：所有共性：用户类，包括姓名和余额。 群主有发红包方法，普通成员有收红包方法，都继承用户类
     * 不论是群主还是成员，都是独立的对象，通过方法修改自己本身作为用户类的那部分信息
     */
    @Test
    public void extendsEx01() {
        Manager manager = new Manager("群主", 100);

        Member a = new Member("A", 0);
        Member b = new Member("B", 0);
        Member c = new Member("C", 0);

        System.out.println("==发红包前");
        manager.showMoney();
        a.showMoney();
        b.showMoney();
        c.showMoney();

        //发红包
        ArrayList<Integer> redRedPackets = manager.sendRedPacket(20, 3);
        a.receiveRedPacket(redRedPackets);
        b.receiveRedPacket(redRedPackets);
        c.receiveRedPacket(redRedPackets);

        System.out.println("==发红包后");
        manager.showMoney();
        a.showMoney();
        b.showMoney();
        c.showMoney();
    }

    /**
     * 接口
     */
    @Test
    public void interface01() {
        //接口中的抽象方法需要通过实现类来使用
        MyInterfaceAbstractImpl impl = new MyInterfaceAbstractImpl();
        impl.methodAbs1();
        impl.methodAbs2();
        //默认方法
        System.out.println("-----------------");
        MyInterfaceDefaultAImpl implA = new MyInterfaceDefaultAImpl();
        implA.methodAbs();
        implA.methodDefault(); //实现类没有默认方法，则向上找接口
        MyInterfaceDefaultBImpl implB = new MyInterfaceDefaultBImpl();
        implB.methodAbs();
        implB.methodDefault();  //实现类中重写了接口的默认方法
        //静态方法
        System.out.println("-----------------");
        MyInterfaceStatic.methodStatic();
        //私有方法
        System.out.println("-----------------");
        //接口常量
        System.out.println("-----------------");
        System.out.println(MyInterfaceConst.NUM_OF_CLASS);
    }

    /*********多态**********/

    /**
     * 多态关系，访问成员变量和承运方法
     **/
    @Test
    public void Multi01() {
        //左侧父类引用指向右侧子类对象
        Fu1 obj = new Zi1();
        //因为子类就是一个父类，所以父类引用指向子类对象就是，把子类对象看作一个父类对象。
        //规则仍然是继承规则，访问特点没有变化。关键是要区分对象。
        //直接访问成员变量：要看左侧，原来左侧是Zi obj = ，obj为子， 现在左侧是 Fu obj = ，obj为父
        System.out.println(obj.num); //原:子10  现：父20（变量不会覆盖，是谁的就是谁的）
        // System.out.println(obj.num2); //成员变量：编译看左，运行看左。因为idea看左边Fu没有num2，所以编译报错

        //访问成员方法：要看new的对象 仍然是子
        obj.methodFu();  // 子没找到，向上找父执行
        //obj.methodZi();  // 成员方法：编译看左，运行看右。因为idea看左边Fu没有methodZi方法，所以编译报错
        obj.method(); //子覆盖重写了，子里找到，执行子里内容
        //通过成员方法访问成员变量：要看方法属于谁
        obj.showNum(); //若子不重写，则先找子再找父20，若子重写，则找到子的10
    }

    /**
     * 对象向上/向下转型
     **/
    @Test
    public void Multi02() {
        //对象的向上转型，就是多态的写法，父类引用指向子类
        Animal1 animal = new Cat1();
        animal.eat();
        //animal.catchMouse(); //报红，猫已经被看作一个动物了，不能调用猫特有方法

        //对象的向下转型
        System.out.println("-----------------");
        //正确
        Animal1 animal1 = new Cat1();  //本来创建的时候是猫，看作一个动物
        Cat1 cat = (Cat1) animal1;  //原本是猫的动物，向下转型还原成猫，还原成功【可行】
        cat.eat();
        cat.catchMouse(); //还原成猫好，可以调用猫特有方法
        //错误 编译不会报错，运行会报 类转换异常 java.lang.ClassCastException
        Dog1 dog = (Dog1) animal1;
        dog.watchHouse();
    }

    /**
     * 判断父类引用的对象，原来子类的类型
     **/
    @Test
    public void Instanceof() {
        giveMeAPet(new Dog1());
        giveMeAPet(new Cat1());
    }

    public static void giveMeAPet(Animal1 animal) {
        if (animal instanceof Dog1) {
            System.out.println("给了一只狗…");
            Dog1 dog = (Dog1) animal;
            dog.watchHouse();
        }
        if (animal instanceof Cat1) {
            System.out.println("给了一只猫…");
            Cat1 cat = (Cat1) animal;
            cat.catchMouse();
        }
    }

    /**
     * 接口、多态综合案例
     * 功能：一个笔记本电脑，通过USB接口，连接两个USB设备：鼠标和键盘
     * 分析：
     * 1、笔记本是独立的设备，本身具有开关机功能
     * 2、鼠标和键盘是独立设备，本身具有各自的鼠标点击和键盘输入功能
     * 3、要使得独立的笔记本使用USB设备的功能，需要一个USB接口，笔记本通过USB接口实现USB设备的打开关闭功能
     * 4、只要USB设备符合USB接口的规范，那么笔记本就可以通过USB接口，控制USB设备的运行
     * 5、规范有：
     * 开关USB设备，这个是USB设备通用功能，所以抽象为接口的抽象方法，方法名写的都一致即可。笔记本只需要控制USB接口的打开关闭即可
     * USB设备又有各自的功能，笔记本通过判断是什么设备来实现设备独有的功能
     * 步骤:
     * 1、创建一个电脑，有开关机功能
     * 2、创建一个USB接口，有打开和关闭USB设备功能 (先有了规范，才能按照规范生产设备)
     * 3、创建鼠标和键盘，作为USB设备实现USB接口的通用功能，再各自添加独有的点击和输入功能
     * 4、笔记本使用USB设备，电脑添加使用USB的功能。通过USB接口控制USB设备的开关，判断USB设备的类型，实现USB设备的独有功能。
     **/
    @Test
    public void interfaceMultiEx01() {
        Computer computer = new Computer();
        computer.PowerOn();

        //1、多态写法，传入的就是USB类型
        USB mouse = new Mouse();
        computer.useUSBDevice(mouse);
        //2、直接USB实现类，因为方法传参是USB类型，所以存入时实现类会先向上转型
        KeyBoard keyBoard = new KeyBoard();
        computer.useUSBDevice(keyBoard);

        computer.PowerOff();
    }

    /*********内部类**********/

    @Test
    /**
     * 使用成员内部类
     * */
    public void innerClass01() {
        Body body = new Body(); //外部类对象
        //1、间接使用成员内部类：外部类对象，调用外部类方法，间接使用内部类
        body.methodBody();

        //2、直接使用成员内部类：按照公式外.内
        System.out.println("-----------------");
        Body.Heart heart = new Body().new Heart();
        heart.beat();
    }

    @Test
    /**
     * 成员内部类访问变量
     * */
    public void innerClass02() {
        Outer.Inner inner = new Outer().new Inner();
        inner.methodInner();
    }

    @Test
    /**
     * 局部内部类
     * */
    public void innerClass03() {
        Outer outer = new Outer();
        outer.methodOuter();
    }

    @Test
    /**
     * 匿名内部类
     * */
    public void innerClass04() {
        //1、实现类实现接口
        AnonymousInterface obj1 = new AnonymousInterfaceImpl();
        obj1.method();
        System.out.println("===============");
        //匿名内部类实现接口
        AnonymousInterface obj2 = new AnonymousInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类实现了接口方法");
            }
        };
        obj2.method();
    }
}
