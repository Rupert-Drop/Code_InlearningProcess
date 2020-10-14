package cn.web.servlet;
/**
 * 完成了修改manager对象密码的功能
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

@WebServlet("/editPasswordServlet")
public class editPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("UTF-8");
        //2.获取数据
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        String reNewPassword = request.getParameter("reNewPassword");
        //2.1判断password是否为null
//        System.out.println("我是密码："+password);
//        System.out.println("我是新密码:"+newPassword);
        //2.2判断reNewPassword是否与newpassword相等
//        存疑：为什么不是password=null
        /*---------!!!!!!!!!!!!!!!!!if&&else语句问题!!!!!!!!!!!!!!-----------*/
       /* if (password==null||reNewPassword==null||newPassword==null||reNewPassword!=password){
            System.out.println("密码为空");
            System.out.println("密码不一致");
            request.getRequestDispatcher("/editPassword.jsp").forward(request,response);
        }else {
            System.out.println("我是else密码："+password);
            System.out.println("new："+reNewPassword+"；"+newPassword);
        }*/
        /*---------!!!!!!!!!!!!!!!!!if&&else语句问题!!!!!!!!!!!!!!-----------*/

        //3.封装对象remanager
        Manager reManager = new Manager();
        reManager.setPassword(newPassword);

        //3.1从session域中获取用户名，并调用Crud方法去数据库中修改密码
        HttpSession session = request.getSession();
        Manager sesssionUser = (Manager) session.getAttribute("user");
        reManager.setUsername(sesssionUser.getUsername());
        CRUDManager crud = new CRUDManager();


        /*此处可优化代码，返回一个布尔值，判断是否修改成功*/
        crud.change(reManager);

        /*---------------------------------------*/
        request.getRequestDispatcher("/exitServlet").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
