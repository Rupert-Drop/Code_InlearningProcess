package cn.web.servlet;
/**
 * 功能：新建订单
 * 启动方式：会员中心-->新建订单
 */

import cn.domain.Subscription;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createSubscriptionDtlServlet")
public class createSubscriptionDtlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Subscription表，
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Subscription subscription = new Subscription();
        subscription.setLinkman(name);
        subscription.setPhone(phone);
        subscription.setEmail(email);
        request.setAttribute("subscription", subscription);
        request.getRequestDispatcher("/SubscriptionRoomServlet").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
