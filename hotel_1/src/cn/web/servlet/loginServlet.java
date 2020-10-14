package cn.web.servlet;
/**
 * 完成登陆功能
 * 调用adrfManagerDao方法中的findManager方法查询数据库中
 * 的所有用户名及密码
 * 以校验用户名及密码
 * 判断是否允许用户登陆
 */

/*
 * 咨询：mysql5.和mysql8的使用及区别
 * */

import cn.dao.CRUDManager;
import cn.domain.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("UTF-8");
        //2.获取数据
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        //封装成manager对象
        Manager manager = new Manager();
        manager.setUsername(username);
        manager.setPassword(pwd);

        //调用CRUD方法,查找manager，并完成登录
        CRUDManager crud = new CRUDManager();
        //拿到处理后的结果
        boolean flag = crud.check(manager);
//        System.out.println("flag:"+flag);
        HttpSession session = request.getSession();
        if (flag == true) {
            session.setAttribute("user", manager);
            request.getRequestDispatcher("/findAllMemberServlet").forward(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
