package cn.web.servlet;
/**
 * 历史订单
 * 调用CRUDsubscription中的checkHistory（）方法
 * <p>
 * <p>
 * <p>
 * <p>
 * history.jsp页面中订单的的状态栏需要到Subscription类中去优化
 */

import cn.dao.CRUDSubscription;
import cn.domain.Manager;
import cn.domain.Subscription;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/historySubscripServlet")
public class historySubscripServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Manager manager = (Manager) session.getAttribute("user");
        CRUDSubscription crud = new CRUDSubscription();
        List<Subscription> managers = crud.checkHistory(manager);
        request.setAttribute("managers", managers);
        System.out.println(managers);
        request.getRequestDispatcher("/historySubscription.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
