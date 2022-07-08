package cn.mori.web.requestlogin;

import cn.mori.web.util.checkFormUtils;
import com.alibaba.druid.support.json.JSONUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 输出字符
 */
@WebServlet("/checkCodeValueServlet")
public class CheckCodeValueServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        //判断验证码
        String verifyCode = request.getParameter("verifycode");
        HttpSession session = request.getSession();
        String verifyCodeSession = (String) session.getAttribute("VERIFYCODE_SESSION");
        Map<String, Object> resultMap = new HashMap<>();
        if (checkFormUtils.checkCode(verifyCode, verifyCodeSession)) {
            resultMap.put("isVCode", true);
            resultMap.put("vCodeMsg", "√");
        } else {
            resultMap.put("isVCode", false);
            resultMap.put("vCodeMsg", "验证码错误");
        }
        PrintWriter out = response.getWriter();
        out.print(JSONUtils.toJSONString(resultMap)); // 输出
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
