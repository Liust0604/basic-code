package com.mori.course02.demofileio;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDemo {
    @Test
    public void Test01() {
        System.out.println("路径分隔符：" + File.pathSeparator);
        System.out.println("文件分隔符：" + File.separator);
    }

    @Test
    public void Test02() {
        File f1 = new File("D:\\demo\\fileio");
        System.out.println(f1); //重写了toString

        File f2 = new File("D:\\demo", "fileio");
        System.out.println(f2);

        File f3 = new File(f1, "a.text");
        System.out.println(f3);
    }

    @Test
    public void Test03() {
        File f1 = new File("D:\\demo\\fileio\\a.jpg");
        System.out.println("绝对路径：" + f1.getAbsolutePath());
        System.out.println("路径：" + f1.getPath());
        System.out.println("名称：" + f1.getName());
        System.out.println("大小：" + f1.length());
        System.out.println("是否存在：" + f1.exists());
        if (f1.exists()) { //路径存在，才有判断是文件还是文件夹的意义的
            System.out.println("是目录吗：" + f1.isDirectory());
            System.out.println("是文件吗：" + f1.isFile());
        }
        System.out.println("D:\\demo\\fileio是目录吗：" + new File("D:\\demo\\fileio").isDirectory());


        System.out.println("------------------------");

        File f2 = new File("a.jpg");  //传入相对路径，是相对于项目根目录的路径
        System.out.println("绝对路径：" + f2.getAbsolutePath());
        System.out.println("路径：" + f2.getPath() + " ; " + f2.toString());
        System.out.println("名称：" + f2.getName());
        System.out.println("大小：" + f2.length());
        System.out.println("是否存在：" + f2.exists());
        System.out.println("是目录吗：" + f2.isDirectory());
        System.out.println("是文件吗：" + f2.isFile());


    }

    @Test
    public void Test04() throws IOException {
        File f1 = new File("1.txt");
        boolean b1 = f1.createNewFile();
        boolean b2 = f1.createNewFile();
        System.out.println("创建文件:" + b1 + "," + b2);

        System.out.println("----------------");

        File f2 = new File("D:\\demo\\fileio\\1.txt");
        boolean a2 = f2.createNewFile();
        System.out.println("创建文件:" + a2);

        File f3 = new File("D:\\demo\\fileio\\newDir");
        boolean a3 = f3.mkdir();
        System.out.println("创建单级文件夹:" + a3);

        File f4 = new File("D:\\demo\\fileio\\newDir\\1\\2");
        boolean a4 = f4.mkdirs();
        System.out.println("创建多级文件夹:" + a4);

    }


    @Test
    public void Test05() {
        File f2 = new File("D:\\demo\\fileio\\1.txt");
        boolean a2 = f2.delete();
        System.out.println("删除文件:" + a2);

        //文件夹里有东西是不能删除的，返回false
        File f4 = new File("D:\\demo\\fileio\\newDir\\1\\2");
        boolean a4 = f4.delete();
        System.out.println("创建多级文件夹:" + a4);

        File f5 = new File("D:\\demo\\fileio\\newDir\\1");
        boolean a5 = f5.delete();
        System.out.println("删除文件夹:" + a5);

        File f3 = new File("D:\\demo\\fileio\\newDir");
        boolean a3 = f3.delete();
        System.out.println("创建单级文件夹:" + a3);
    }

    @Test
    public void Test06() {
        File file = new File("D:\\demo\\fileio");
        String[] arr = file.list();
        for (String fileName : arr) {
            System.out.println(fileName);
        }
        System.out.println("-------------");

        File[] arr1 = file.listFiles();
        for (File f : arr1) {
            System.out.println(f.getPath());
        }
    }

    @Test
    /**
     * 递归
     * */
    public void Test07() {
        int sum = sumN(10);
        System.out.println("1~n的和：" + sum);

        int value = getValue(5);
        System.out.println("阶乘：" + value);
    }

    /**
     * 计算1~n之间的和：
     * n + (n-1) + (n-2) + ... + 1
     * 1、结束条件：n=1时结束 ->
     * 2、目的：获取下一个被加的数字
     * A、确认关系。
     * 不同：这一级是n，下一级是n-1,所以这一级传参是n，下一级传参是n-1；=> n 和 sumN(n-1)
     * 关系：n*n-1 => n * sumN(n-1)
     * 需要记录结果： => return n * sumN(n-1);
     * B、确认结束。
     * 不能再次调用本方法，且记录值是1 ，所以 return n + sumN(n-1) = 0 所以 n=1 =>  if (n == 1) return 1; 返回值
     * （不推荐使用递归，使用for）
     */
    private int sumN(int n) {
        //结束
        if (n == 1) return 1;
        return n + sumN(n - 1);
    }
/*
    private int sumN(int n) {
        if (n > 0) {
            return n + sumN(n - 1);
        }
        return 0;
    }
*/

    /**
     * 阶乘 （符合条件的递归，不符合条件指定结束值）
     * n! = n*(n-1)*(n-2)*…*2*1;
     * 1、关系：
     * 不同：n 和 n-1 => 参数 n 和 getValue(n-1)
     * 关系：n*n-1 => n * getValue(n-1)
     * 需要记录结果： return n * getValue(n-1)；
     * 2、结束
     * 最后记录结果为1，且不调用下一级方法  n * getValue(n-1) = 1 => n = 1
     */
    private int getValue(int n) {
        if (n == 1) {
            return 1;
        }
        return n * getValue(n - 1);
    }

    @Test
    /**
     * 递归打印路径
     * */
    public void Test08() {
        //printAllPath("D:\\demo\\fileio");
        System.out.println("--------------------");
        List<String> javaFiles = getJavaPath("D:\\demo\\course01");
        System.out.println(javaFiles.size());
        for (String file : javaFiles) {
            System.out.println(file);
        }
        System.out.println("--------------------");
        getJavaPath2("D:\\demo\\course01");
        System.out.println("--------------------");
        getJavaPath3("D:\\demo\\course01");
    }

    /**
     * 递归：（符合条件的递归，不符合条件的不处理）
     * 1、关系：
     * 不同：这一级路径 和 下一级路径 => rootPath 和 printAllPath(下一级路径)
     * 关系：没有关系
     * 记录：不需要记录，只是打印内容。方法执行完毕结束
     * 2、结束：
     * 整理：
     * 1、遍历当前目录下的路径。
     * 2、如果是目录，就递归，如果不是目录，就不递归，没有返回值方法执行结束就出栈，那么可以不处理，等方法执行完成就好。
     * 3、回到这一层的时候继续遍历下一个路径
     */
    private void printAllPath(String rootPath) {
        File parent = new File(rootPath);
        if (parent.exists()) {
            System.out.println(parent.getAbsolutePath());
            if (parent.isDirectory()) {
                File[] children = parent.listFiles();
                for (File child : children) {
                    printAllPath(child.getAbsolutePath()); //实现递归的是这里，其他是一些操作，若不符合递归条件，则方法自己执行结束出栈
                }
            }
        }
    }

    /**
     * 递归：指定文件
     * 1、关系
     * 不同：当前目录 和 下一级目录 rootPath 和  getJavaPath(下级目录)
     * 关系：没有关系
     * 记录：需要记录，通过 javaFiles 记录 => return javaFiles
     * 2、结束
     * 方法执行完出栈结束
     */
    private List<String> getJavaPath(String rootPath) {
        List<String> javaFiles = new ArrayList();
        File parent = new File(rootPath);
        if (parent.exists()) {
            if (parent.isDirectory()) {
                //遍历
                File[] children = parent.listFiles();
                for (File child : children) {
                    //每次进入方法都是一个新的保存了文件的list，只有方法出栈的时候，才会传递给当前list
                    List<String> childrenFiles = getJavaPath(child.getAbsolutePath()); //此处递归
                    javaFiles.addAll(childrenFiles); // javaFiles 记录递归出栈的结果
                }
            } else if (parent.isFile()) {
                String filePath = parent.getAbsolutePath();
                if (filePath.toLowerCase().endsWith(".java")) {
                    javaFiles.add(filePath); // javaFiles 记录结果
                }
            }
        }
        return javaFiles;
    }

    /**
     * 文件过滤器过滤文件
     */
    private void getJavaPath2(String rootPath) {
        File parent = new File(rootPath);
        File[] files = parent.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".java");
            }
        });
        for (File file : files) {
            if (file.isDirectory()) {
                getJavaPath2(file.getAbsolutePath());
            } else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    private void getJavaPath3(String rootPath) {
        File parent = new File(rootPath);
        /*File[] files = parent.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory() || name.toLowerCase().endsWith(".java");
            }
        });*/

        File[] files = parent.listFiles((dir, name) ->
                new File(dir, name).isDirectory() || name.toLowerCase().endsWith(".java"));

        for (File file : files) {
            if (file.isDirectory()) {
                getJavaPath2(file.getAbsolutePath());
            } else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
