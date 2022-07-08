package com.mori.course01.demoapi;

import com.mori.course01.exercises.domain.classobj.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * ArrayList类
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayListDemo demo = new ArrayListDemo();

        ArrayList<String> list = new ArrayList<>();
        list.add("A1");
        list.add("B2");
        list.add("C3");
        demo.printArrayList(list);

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt();
            list1.add(num);
        }
        ArrayList<Integer> l = demo.getSmallList(list1);
        System.out.println(l);
        System.out.println("偶数共有：" + l.size() + "个");
    }

    /**
     * 对象数组
     * 缺点：数组一但创建，程序运行期间长度不可以改变
     */
    @Test
    public void test01() {

        Student[] array = new Student[3];

        Student s1 = new Student("小明", 18);
        Student s2 = new Student("小红", 16);

        //将s1的地址值赋到数组0号元素位置
        array[0] = s1;
        array[1] = s2;

        System.out.println(array[1]); //s1对象的地址值
        System.out.println(array[1].getName());

    }

    /**
     * ArrayList：
     * 长度可以随意变换
     */
    @Test
    public void test02() {
        ArrayList<Student> list = new ArrayList<>();
        System.out.println(list);//[]

        Student s1 = new Student("小明", 18);
        Student s2 = new Student("小红", 16);
        list.add(s1);
        list.add(s2);
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student.getName() + "-" + student.getAge());
        }
    }

    /**
     * ArrayList：
     * 遍历
     */
    @Test
    public void test03() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A1");
        list.add("B2");
        list.add("C3");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 生成6个1~33之间的随机整数，添加到集合，并遍历集合。
     */
    @Test
    public void test04() {
        ArrayList<Integer> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int num = r.nextInt(33) + 1;
            list.add(num);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 以指定格式{元素@元素@元素}打印集合的方法，参数是ArrayList
     */
    public void printArrayList(ArrayList<String> list) {
        String s = "{";
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                s += list.get(i) + "}";
            } else {
                s += list.get(i) + "@";
            }
        }
        System.out.println(s);
    }

    /**
     * 筛选ArrayList中的偶数元素，放入小集合中
     */
    public ArrayList<Integer> getSmallList(ArrayList<Integer> list) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < list.size() - 1; i++) {
            int num = list.get(i);
            if (num % 2 == 0) {
                l.add(num);
            }
        }
        return l;
    }
}
