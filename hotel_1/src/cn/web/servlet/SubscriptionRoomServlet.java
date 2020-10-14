package cn.web.servlet;
/**
 * 功能：完成空闲房间的查找
 * 辅助完成新建订单的操作
 * <p>
 * <p>
 * 新建订单的下一步
 */

import cn.dao.CRUDRoom;
import cn.domain.Room;
import cn.domain.Subscription;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.List;

@WebServlet("/SubscriptionRoomServlet")
public class SubscriptionRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subscription = request.getParameter("subscription");
        //调用CRUDRoom中的查找空房间方法
        CRUDRoom crud = new CRUDRoom();
        List<Room> romlist = crud.selectRoom();
        //System.out.println(romlist);
        request.setAttribute("romlist", romlist);

        for (Room manager : romlist) {
            System.out.println(manager);
            System.out.println(manager.getId());
            System.out.println(manager.getNo());
        }
        request.getRequestDispatcher("/createSubscriptionDtl-2.jsp").forward(request, response);

        // request.getRequestDispatcher("/createSubscriptionDtlServlet").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
