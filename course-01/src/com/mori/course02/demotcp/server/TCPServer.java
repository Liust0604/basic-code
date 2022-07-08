package com.mori.course02.demotcp.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1、创建服务器对象。指定监听本机的哪个端口号
        ServerSocket server = new ServerSocket(8888);
        //2、获取客户端对象。有哪个客户端访问，就获取到该客户端的对象
        Socket socket = server.accept();
        //InputStream is = socket.getInputStream(); //读取客户端数据
        StringBuilder sb = new StringBuilder("客户端发来：");
        int len;
        /*byte[] bytes = new byte[1024];
        while ((len = is.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len));
        }*/
        //对于文件来说，有结束符，所以while直到遇到结束符。而Socket没有结束符，数据没填满缓冲区，就会一直堵塞在while
        //可以用字符流的ready()方法，判断这个流是否准备好被读取。先读取一次，若又准备好读取，就再读一次
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        char[] chars = new char[1024];
        do {
            if ((len = br.read(chars)) != -1) {
                sb.append(new String(chars, 0, len));
            }
        } while (br.ready());
        System.out.println(sb.toString());

        OutputStream os = socket.getOutputStream(); //往客户端回写数据
        os.write("收到谢谢".getBytes());
        System.out.println("回复客户端");

        //释放资源，两个对象都得释放
        socket.close();
        server.close();
    }
}
