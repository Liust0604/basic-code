package com.mori.course02.demotcp.client;

import java.io.*;
import java.net.Socket;

/**
 * 文件上传客户端
 */
public class UpLoadClient {
    public static void main(String[] args) throws IOException {
        //1、建立和服务器连接。获取输入流输出流
        Socket socket = new Socket("127.0.0.1", 8887);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        //2、读取本地文件，并发送给服务器
        File file = new File("D:\\demo\\fileio\\a.jpg");
        FileInputStream fis = new FileInputStream(file);
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }
        socket.shutdownOutput();

        //3、接收服务器回写消息
        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        //释放资源
        fis.close();
        socket.close();
    }
}
