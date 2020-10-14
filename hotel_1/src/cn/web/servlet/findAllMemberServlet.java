package cn.web.servlet;
/**
 * 功能：完成会员中心的信息查询
 * 并会返回一个member对象
 * 启动方式：进入会员中心后再次点击导航中的会员中心
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

@WebServlet("/findAllMemberServlet")
public class findAllMemberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //1.调用CRUDsubscription中的check()方法查询数据库中的subscription表，并返回一个arraylist的subscription表集合，
        CRUDSubscription crud = new CRUDSubscription();
        /*---------根据用户名及订单状态查询调用crud，checkbyusername（）---------*/
        HttpSession session = request.getSession();
        Manager manager = (Manager) session.getAttribute("user");
        List<Subscription> slist = crud.checkByUsername(manager);
        //2.将得到的members对象存入到request域中
        request.setAttribute("slist", slist);
        //  System.out.println(slist);
        //2.1将存储有members信息的request转发到memberscenter.jsp页面
        request.getRequestDispatcher("/memberCenter.jsp").forward(request, response);
        //3.0在页面中先得到members对象
        // 3.1再利用el表达式显示信息${member.name}${member.sex}${member.phone}....

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
