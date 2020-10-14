package cn.web.servlet;
/**
 * 会员中心下的删除功能
 * 启动方式：进入会员中心后点击删除开始执行
 */

import cn.dao.CRUDSubscription;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletSubscriptionServlet")
public class deletSubscriptionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // System.out.println("已进入deletServlet");
        //获取要删除订单的id
        String id = request.getParameter("id");
        CRUDSubscription crud = new CRUDSubscription();
        crud.deleteById(id);
        request.getRequestDispatcher("/findAllMemberServlet").forward(request, response);
        // System.out.println(id);

        //1.获取要删除信息的用户名，
        //2.调用adrfMembersDao的delete方法，删除该记录

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
