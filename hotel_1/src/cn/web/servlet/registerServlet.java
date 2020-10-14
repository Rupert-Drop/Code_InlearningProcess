package cn.web.servlet;
/**
 * 完成注册功能
 * 实现了
 * a；密码的校验
 * b：相同用户名的检查
 * c：判断新的用户信息是否添加成功
 */

import cn.dao.CRUDManager;
import cn.domain.Manager;
import cn.domain.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        0.设置编码
        request.setCharacterEncoding("UTF-8");
        //1.获取register-1.jsp页面提交的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        //封装member对象
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setName(name);
        member.setPhone(phone);
        member.setEmail(email);

//        封装为manager对象
        Manager manager = new Manager();
        manager.setPassword(password);
        manager.setUsername(username);

        /***********1.1密码的校验；；；判断password是否与repassword相等************/
        boolean repswdfalg = true;
        do {
            if (password.equals(repassword)) {
                repswdfalg = false;
                System.out.println("中repswdflag:" + repswdfalg);
            } else {
//                System.out.println("密码不一致，请重新确认密码");
                request.getRequestDispatcher("/register-1.jsp").forward(request, response);
                break;
            }

        } while (repswdfalg);
        /***********1.1判断password是否与repassword相等************/
        //继续获取数据

        //2。用户名检验：：：：调用adrfMemberDao中的find方法，判断该用户名是否已经被注册
        CRUDManager crud = new CRUDManager();
        boolean registerFlag = crud.check(manager);
        if (registerFlag == true) {
            //a:已被注册，重新输入用户名
            System.out.println("该用户已被注册");
            request.getRequestDispatcher("/register-1.jsp").forward(request, response);

        } else {
            //b：未被注册，向下执行
            //3.调用CRUD中的add方法，向数据库中插入当前获取到的信息数据
            crud.add(manager);

            /*再次查找表，判断是否添加成功*/
            boolean addFlag = crud.check(manager);

            //判断新的用户信息是否添加成功
            if (addFlag == true) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/register-1.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
