package cn.web.servlet;
/**
 * 客房信息
 * 启动方式：点击客房信息进入
 * 表subscription_dtl
 */

import cn.dao.CRUDSubscription_dtl;
import cn.domain.Subscription_dtl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/roomSelectServlet")
public class roomSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String sid = request.getParameter("sid");
//        System.out.println(sid);
        CRUDSubscription_dtl crud = new CRUDSubscription_dtl();

        /*---------------尝试使用map失败------------------*/
      /*  Map<String,Object> map = crud.checkBySid(sid);
        System.out.println(map);
       request.setAttribute("map",map);
       request.getRequestDispatcher("/subscriptionDetail.jsp").forward(request,response);*/
        /*---------------尝试使用map失败------------------*/

        //使用list
        List<Subscription_dtl> list = crud.checkBySsid(sid);
        request.setAttribute("slist", list);
        request.getRequestDispatcher("/subscriptionDetail.jsp").forward(request, response);
        // System.out.println(list);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
