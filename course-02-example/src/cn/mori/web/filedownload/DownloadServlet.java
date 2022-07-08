package cn.mori.web.filedownload;

import cn.mori.web.util.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取参数，并拼接为完整真实路径
        ServletContext ctx = this.getServletContext();
        String filepath = request.getParameter("filepath");
        String path = ctx.getRealPath(filepath);

        String filename = "newFile";
        if (filepath != null && filepath.contains("/")) {
            String[] arr = filepath.split("/");
            if (arr.length > 1) {
                filename = arr[arr.length - 1];
            }
        }

        //3、设置响应头，1、设置MIME类型 2、以下载的方式处理消息
        String mimeType = ctx.getMimeType(filename);
        response.setHeader("content-type", mimeType);
        String encodeFileName = DownLoadUtils.getFileName(request.getHeader("user-agent"), filename); //解决文件名中文乱码问题
        response.setHeader("content-disposition", "attachment;filename=" + encodeFileName);

        //2、读取文件,并写入输出流
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream(new File(path)));
        ServletOutputStream sos = response.getOutputStream();
        int len = -1;
        byte[] bytes = new byte[1024 * 8];
        while ((len = fis.read(bytes)) != -1) {
            sos.write(bytes, 0, len);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
