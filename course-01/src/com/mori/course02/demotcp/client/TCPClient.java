package com.mori.course02.demotcp.client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1、创建客户端对象，绑定服务器IP和端口。创建时就会去连接服务器。
        Socket socket = new Socket("127.0.0.1", 8888);
        //2、上面连接成功后可以开始交互
        OutputStream os = socket.getOutputStream(); //获取网络输出流向服务器发送数据，这里是多态，抽象类指向实现类、字节流的
        os.write("你好服务器".getBytes());
        System.out.println("向服务器打招呼");

        //InputStream is = socket.getInputStream(); //读取服务器数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        StringBuilder sb = new StringBuilder("收到服务器：");
        int len;
        byte[] bytes = new byte[1024];
        len = bis.read(bytes);
        sb.append(new String(bytes, 0, len));
        System.out.println(sb.toString());

        //释放资源
        socket.close();
    }
}
