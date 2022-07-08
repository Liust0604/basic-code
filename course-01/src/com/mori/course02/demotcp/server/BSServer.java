package com.mori.course02.demotcp.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟B/S
 */
public class BSServer {
    public static void main(String[] args) throws IOException {
        //1、服务器监听端口，获取客户端及其输入流输出流
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                        //2、从html请求中解析出要返回的html文件路径
                        String line = br.readLine();
                        String[] arr = line.split(" ");
                        String htmlpath = arr[1].substring(1); //请求第一行中间部分，去除第一个/

                        //3、根据路径读取本地html页面文件，返回给浏览器
                        //若浏览器解析返回的html页面，里面有图片，则浏览器会单独开启一个线程，读取服务器的图片
                        bos.write("HTTP/1.1 200 OK\r\n".getBytes());
                        bos.write("Content-Type:text/html\r\n".getBytes());
                        bos.write("\r\n".getBytes()); //必须写入空行，否则浏览器不解析
                        FileInputStream fis = new FileInputStream(htmlpath);
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = fis.read(bytes)) != -1) {
                            bos.write(bytes, 0, len);
                        }
                        socket.shutdownOutput();

                        //释放资源
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        // server.close();
    }

}
