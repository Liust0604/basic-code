package com.mori.course02.demotcp.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * 文件上传服务器
 */
public class UploadServer {
    public static void main(String[] args) throws IOException {
        //1、启动服务器，监听端口号
        ServerSocket server = new ServerSocket(8887);

        while (true) { //服务器一直监听
            //2、获取客户端对象，和客户端的输入流输出流
            Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();
                        OutputStream os = socket.getOutputStream();

                        long start = System.currentTimeMillis();
                        //3、接收客户端传来的文件,并保存到本地
                        File dir = new File("D:\\demo\\fileio\\uploads");
                        if (!dir.exists()) dir.mkdirs();
                        String fileName = "mori" + System.currentTimeMillis() + new Random().nextInt(10000) + ".jpg";
                        FileOutputStream fos = new FileOutputStream(new File(dir, fileName));
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = is.read(bytes)) != -1) {
                            fos.write(bytes, 0, len);
                        }
                        long end = System.currentTimeMillis();

                        //4、上传成功，回写给客户端
                        String msg = "上传成功！" + (end - start) + "ms";
                        os.write(msg.getBytes());

                        //释放资源
                        fos.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        //server.close(); //若服务器一直监听就不用关闭了
    }
}
