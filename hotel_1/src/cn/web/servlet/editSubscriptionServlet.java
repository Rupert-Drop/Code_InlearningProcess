package cn.web.servlet;
/**
 * 功能：完成修改联系人信息功能
 * 启动：会员中心-->联系人信息
 */

import cn.dao.CRUDSubscription;
import cn.domain.Subscription;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/editSubscriptionServlet")
public class editSubscriptionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String no = request.getParameter("no");
        // System.out.println("no:"+no);
        CRUDSubscription crud = new CRUDSubscription();
        Subscription subscription = crud.checkByNo(no);
        request.setAttribute("subscription", subscription);
        System.out.println("subscription:" + subscription);
        request.getRequestDispatcher("/editSubscription.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
