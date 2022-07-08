package cn.mori.web.requestlogin;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 输出字符
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //图片前面不能加text文本编码，不然读出来是文本乱码
        int width = 80;
        int height = 25;

        //1、内存中创建图片(宽，高，图片类型)
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2、美化图片
        //填充背景色
        Graphics g = img.getGraphics(); //获得图片
        g.setColor(Color.pink); //设置颜色
        g.fillRect(0, 0, width, height); //填充矩形 坐标(0,0)->(w,h)
        //画边框
        g.setColor(Color.blue);
        g.drawRect(0, 0, width - 1, height - 1); //画矩形线条，-1是边框占了一个像素
        //写验证码
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = r.nextInt(str.length());
            char ch = str.charAt(index);
            sb.append(ch);
            g.drawString(ch + "", i * (width / 5), (height / 2));
        }
        //4、验证码存入session
        String verifyCodeSession = sb.toString();
        HttpSession session = request.getSession();
        session.setAttribute("VERIFYCODE_SESSION", verifyCodeSession);

        //画干扰线
        g.setColor(Color.green);
        for (int i = 0; i < 10; i++) {
            int x1 = r.nextInt(width);
            int x2 = r.nextInt(width);
            int y1 = r.nextInt(height);
            int y2 = r.nextInt(height);
            g.drawLine(x1, x2, y1, y2);
        }

        //3、图片输出到浏览器展示
        // ImageIO 的write方法，可以将内存中的图片，写到流里（图片对象，后缀名，流）
        ImageIO.write(img, "jpg", response.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
