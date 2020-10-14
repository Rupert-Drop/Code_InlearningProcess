package cn.web.filter;
/**
 * 登录验证的过滤器
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0.强制转换，获取HtttpServletRequest和HtttpServletResponse
        HttpServletRequest request = (HttpServletRequest) req;
        //1.获取资源路径
        String uri = request.getRequestURI();
        //2.判断是否包含登陆相关的资源路径,!!!!!!注意排除掉css/js/图片/验证码等资源
        if (uri.contains("/login.jsp") || uri.contains("/index.jsp") || uri.contains("/loginServlet")
                || uri.contains("/style/") || uri.contains("/js/") || uri.contains("/images/")
                || uri.contains("/register-1.jsp") || uri.contains("/registerServlet") || uri.contains("/roomPrice.jsp") || uri.contains("/myadmin/login.jsp/")) {
            //包含登陆页面路径，判断出用户仅仅只是想登陆，放行
            chain.doFilter(req, resp);
        } else {
            //不包含登陆页面，用户想访问网站内部资源
            //3.判断用户是否登录
            //3.1 从session中获取user，
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                //4.若已登陆，允许访问
                chain.doFilter(req, resp);
            } else {
                //5.未登录，跳转到登陆页面
                request.setAttribute("login_msg", "您尚未登录，请先登录");
                request.getRequestDispatcher("/index.jsp").forward(request, resp);
            }
        }

        // chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
