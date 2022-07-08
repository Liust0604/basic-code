package com.mori.course02.demofileio;

import com.mori.course02.demofileio.domain.Person;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class IoDemo {

    /*字节流*/

    @Test
    public void Test01() throws IOException {
        //1、创建FileOutputStream对象，指定数据目的路径（每次都会重新创建文件）
        FileOutputStream fos = new FileOutputStream("D:\\demo\\fileio\\fos.txt");
        //2、指定字节写入输出流(拼接内容)
        //48 0； 65 A； 97 a
        fos.write(97); //写一个字节，十进制转换为2进制，以2进制的形式保存
        fos.write(new byte[]{49, 48, 48}); //显示100，需要写3个字节
        byte[] bytes = new byte[]{65, 66, 67, 68, 69};
        fos.write(bytes); //ABCDE
        fos.write(new byte[]{-65, -66, -67, 68, 69}); //(中文)(中文)E
        fos.write(bytes, 1, 2); //写入字节数组的一部分 BC，从索引1开始取2个
        fos.write("你好".getBytes()); //字符串转字节数组
        //3、关闭流，释放资源
        fos.close();
    }

    @Test
    public void Test02() throws IOException {
        //追加写
        FileOutputStream fos = new FileOutputStream("D:\\demo\\fileio\\fos.txt", true);
        for (int i = 0; i < 3; i++) {
            fos.write("你好".getBytes());
            fos.write("\r\n".getBytes()); //换行
        }
        fos.close();
    }

    @Test
    public void Test03() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\demo\\fileio\\fos.txt");
        int len = 0;
        while ((len = fis.read()) != -1) {  //fis.read()读取到的1个字节；值赋值给len；while() 每次移动一次指针
            System.out.println(len);
        }
    }


    @Test
    public void Test04() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\demo\\fileio\\fos.txt");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes));
        }
        fis.close();
    }


    @Test
    /**
     * 文件复制：一读一写
     * 数据源->目的地
     * */
    public void Test05() throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("D:\\demo\\fileio\\a.jpg"); //输入流指定数据源
        FileOutputStream fos = new FileOutputStream("D:\\demo\\fileio\\acopy.jpg"); //输出流指定目的地
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) { //数组缓冲读取
            fos.write(bytes, 0, len);  //写入数据。通过有效数量，读多少写多少
        }
        //先关闭写的！ 因为写完了一定读完了
        fos.close();
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println("复制文件共耗时" + (end - start) + "ms");
    }

    /*字符流*/

    @Test
    public void Test06() throws IOException {
        FileReader fr = new FileReader("D:\\demo\\fileio\\2.txt");
        int len = 0;
        while ((len = fr.read()) != -1) {
            System.out.print((char) len); //byte/short/char 可以相互转换（向上转型为int)
        }
    }

    @Test
    public void Test07() throws IOException {
        FileReader fr = new FileReader("D:\\demo\\fileio\\2.txt");
        char[] chars = new char[1024]; //用来存储读取到的多个字符
        int len = 0; //记录读取到的有效字符个数
        while ((len = fr.read(chars)) != -1) {
            System.out.print(new String(chars));
        }
        fr.close();
    }

    @Test
    public void Test08() {
        //1、创建FileWriter流
        FileWriter fw = null;  //提高流对象作用域
        try {
            fw = new FileWriter("D:\\demo\\fileio\\fw.txt");
            //2、数据写入到内存缓冲区
            fw.write(97);
            char[] chars = {'a', 'b', 'c', 'd', 'e'};
            fw.write(chars);
            fw.write(chars, 1, 3);
            fw.write("有程序员开发", 1, 3);
            fw.write("你好！"); //到这一步，文件都没有改变
            //fw.flush();//3、刷新流
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //若流对象创建失败，流对象默认值是null，不能调用方法，会空指针异常
            if (fw != null) {
                try {
                    //4、关闭流,close()也会先刷新流
                    fw.close(); //close()也会抛出io异常，所以也要处理
                    //java.io.IOException: Stream closed
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void Test09() {
        try (FileInputStream fis = new FileInputStream("D:\\demo\\fileio\\a.jpg");
             FileOutputStream fos = new FileOutputStream("D:\\demo\\fileio\\acopy.jpg");) { //JDK9流对象也可以定义在外面，try(fis;fos)

            long start = System.currentTimeMillis();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                try {
                    fos.write(bytes, 0, len);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // close也不用写了，流对象作用域只有try，离开try代码块，自动释放流对象
            long end = System.currentTimeMillis();
            System.out.println("复制文件共耗时" + (end - start) + "ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*properties*/

    @Test
    public void Test10() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("k1", "v1");
        prop.setProperty("k2", "v2");
        prop.setProperty("名字", "英文");
        prop.setProperty("名字", "中文");
        showProp(prop);

        FileWriter fw = new FileWriter("D:\\demo\\fileio\\prop.txt"); //若属性集中含有中文，一般都用字符流
        prop.store(fw, "save data");
        fw.close();

        prop.store(new FileOutputStream("D:\\demo\\fileio\\prop2.txt"), "save data");
    }

    private void showProp(Properties prop) {
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }

    @Test
    public void Test11() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader("D:\\demo\\fileio\\prop.txt")); //加载属性集文件数据
        showProp(prop);
        System.out.println("=================");
        prop.load(new FileInputStream("D:\\demo\\fileio\\prop.txt")); //加载属性集文件数据
        showProp(prop);
    }

    /*缓冲流*/

    @Test
    public void Test12() throws IOException {
        //1、创建基本输出流
        FileOutputStream fos = new FileOutputStream("D:\\demo\\fileio\\bos.txt");
        //2、创建缓冲输出流。可以指定缓冲区大小，不写是默认
        BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
        //3、写入缓冲区
        bos.write("你好ABC0".getBytes()); //此时还没有写入到文件
        //bos.flush(); //刷新缓冲区到文件
        bos.close(); //释放资源。不用关闭基本流，关闭缓冲流就够了

        //1、创建基本输入流
        FileInputStream fis = new FileInputStream("D:\\demo\\fileio\\bos.txt");
        //1、创建缓冲输入流
        BufferedInputStream bis = new BufferedInputStream(fis);
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        bis.close();
    }


    @Test
    /**
     * 文件复制：缓冲流效率高 (缓冲流+缓冲数组)
     * */
    public void Test13() throws IOException {
        long start = System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\demo\\fileio\\a.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\demo\\fileio\\acopy.jpg"));

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制文件共用了" + (end - start) + "ms");
    }

    @Test
    public void Test14() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\demo\\fileio\\bw.txt"));
        for (int i = 0; i < 3; i++) {
            bw.write("ABC");
            bw.newLine();
        }
        bw.close();
    }

    @Test
    public void Test15() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\demo\\fileio\\bw.txt"));
        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }


    /*转换流*/
    @Test
    public void Test16() throws IOException {
        FileReader fr = new FileReader("D:\\demo\\fileio\\GBK格式文本.txt"); //直接查看，中文会乱码
        int len = 0;
        while ((len = fr.read()) != -1) {
            System.out.print((char) len);
        }
        fr.close();
    }

    @Test
    public void Test17() throws IOException {
        //可以指定编码表，不区分大小写。不指定默认utf-8
        //写一个gbk文件
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\demo\\fileio\\GBK格式文本.txt"), "gbk");
        osw.write("你好");
        osw.flush();
        osw.close();
        //读一个gbk文件
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\demo\\fileio\\GBK格式文本.txt"), "gbk");
        int len = -1;
        while ((len = isr.read()) != -1) {
            System.out.println((char) len);
        }
        isr.close();
    }


    @Test
    public void Test18() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\demo\\fileio\\GBK格式文本.txt"), "gbk");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\demo\\fileio\\UTF-8格式文本.txt"), "utf-8");
        int len = 0;
        char[] chars = new char[1024];
        while ((len = isr.read(chars)) != -1) {
            osw.write(chars, 0, len);
        }
        osw.close();
        isr.close();
    }

    /*序列化流*/

    @Test
    public void Test19() throws IOException {
        //1、创建一个对象的序列化流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\demo\\fileio\\oos.txt"));
        oos.writeObject(new Person("小明", 21));
        oos.close();
    }

    @Test
    public void Test20() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\demo\\fileio\\oos.txt"));
        //Object o = ois.readObject();
        Person person = (Person) ois.readObject(); //向下转型
        System.out.println(person);
        ois.close();
    }

    @Test
    /**
     * 序列化集合
     * */
    public void Test21() throws IOException, ClassNotFoundException {
        List<Person> list = new ArrayList<>();
        list.add(new Person("小明", 18));
        list.add(new Person("小红", 19));
        list.add(new Person("小杰", 20));

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\demo\\fileio\\oos2.txt"));
        oos.writeObject(list);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\demo\\fileio\\oos2.txt"));
        List<Person> l = (List<Person>) ois.readObject();
        System.out.println(l);

        ois.close();
        oos.close();
    }

    /*打印流*/

    @Test
    public void Test22() throws IOException {
        PrintStream ps = new PrintStream("D:\\demo\\fileio\\print.txt");
        ps.write(97);
        ps.println(97);
        ps.println("Hello World!");
        ps.close();
    }

    @Test
    public void Test23() throws IOException {
        System.out.println("控制台输出!");
        PrintStream ps = new PrintStream("D:\\demo\\fileio\\printsys.txt");
        System.setOut(ps); //改变打印流流向。输出语句目的地改为打印流的目的地
        System.out.println("打印流目的地输出!"); //System.out这个标准打印流，原本是输出到控制台，现在是输出到指定文件
        ps.close();
    }
}
