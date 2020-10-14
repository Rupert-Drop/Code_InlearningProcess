package cn.web.servlet;
/**
 * 功能：完成管理员的登录
 */

import cn.dao.CRUDManager;
import cn.domain.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admLoginServlet")
public class admLoginServlet extends HttpServlet {
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

        //调用adrfManagerDao方法,查找manager，并完成登录
        CRUDManager crud = new CRUDManager();
        //拿到处理后的结果
        boolean flag = crud.check(manager);
        HttpSession session = request.getSession();

        if (flag == true) {
            System.out.println(flag);
            session.setAttribute("user", manager);
            request.getRequestDispatcher("mymanager/subscriptionQuery.jsp").forward(request, response);
        } else {
            System.out.println(flag);
            request.getRequestDispatcher("mymanager/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
