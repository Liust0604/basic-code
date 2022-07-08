package cn.mori.web.servlet;

import cn.mori.web.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@WebServlet("/jsonServlet")
public class JsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //========Java对象转Json字符串

        Person user = new Person();
        user.setName("小明");
        user.setGender("男");
        user.setAge(12);
        user.setBirthday(new Date());
        Person user1 = new Person("小红", "女", 19, new Date());
        Person user2 = new Person("小绿", "男", 21, new Date());

        //1、创jackson核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //java对象转JSON对象
        String jsonStr = mapper.writeValueAsString(user);//对象转换为json字符串
        System.err.println(jsonStr);
        mapper.writeValue(new File("D:\\demo\\fileio\\json\\uesr.json"), user); //数据写入文件中

        response.setContentType("text/json;charset=utf-8");
        //mapper.writeValue(response.getWriter(), user); //数据写到字符输出流
        mapper.writeValue(response.getOutputStream(), user); //数据写到字节输出流

        //List、Map
        List<Person> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        System.err.println(mapper.writeValueAsString(list));

        Map<String, Object> map = new HashMap();
        map.put("班级", "向日葵班");
        map.put("排名", "第一名");
        map.put("口号", "向日");
        map.put("users", list);
        String json = mapper.writeValueAsString(map);
        System.err.println(json);

        //=======Json字符串转Java对象
        System.err.println("=================");
        Person person = mapper.readValue(jsonStr, Person.class);
        System.err.println(person);
        Map<String, Object> map1 = mapper.readValue(json, Map.class);
        System.err.println(map1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
