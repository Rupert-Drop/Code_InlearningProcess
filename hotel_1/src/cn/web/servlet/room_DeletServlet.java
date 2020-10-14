package cn.web.servlet;
/**
 * 客房信息-->点击删除
 */

import cn.dao.CRUDSubscription_dtl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/room_DeletServlet")
public class room_DeletServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String sid = request.getParameter("sid");
        //  System.out.println(request.getParameter("sid"));
        CRUDSubscription_dtl crud = new CRUDSubscription_dtl();
        crud.delet(sid);
        /*此处可设置flag判断数据库操作是否成功，进行系统优化*/
        request.getRequestDispatcher("/roomSelectServlet").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
