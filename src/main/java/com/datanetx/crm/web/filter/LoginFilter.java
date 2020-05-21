package com.datanetx.crm.web.filter;

import com.datanetx.crm.settings.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入到验证有没有登录过的过滤器");

        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;

        String path =httpServletRequest.getServletPath();

        if ("/login.jsp".equals(path) || "/settings/user/login.do".equals(path)){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{

            HttpSession session = httpServletRequest.getSession();
            User user = (User) session.getAttribute("user");
            //如果user不为null，说明登录过,直接放行；否则说明想非法访问，重定向到登录页面。
            if (user != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
            /*
            一、在实际项目开发中，对于路径的使用，不论操作的是前端还是后端，一律使用绝对路径
            二、关于转发和重定向的路径写法如下：
                转发：使用的是一种特殊的绝对路径的使用方式，这种绝对路径前不加/项目名，这种路径也称这为内部路径，如：/login.jsp
                重定向：使用的是传统绝对路径的写法，前面必须以/项目名开头，后面跟具体的资源路径，如：/crm/login.jsp
            三、为什么此处使用重定向，而不使用转发？
                转发之后，路径会停留在老路径上，而不是跳转之后最新资源的路径。
                我们应该在为用户跳转到登录页的同时，将浏览器的地址栏自动设置为当前的登录页的路径。
             */
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsp");
            }
        }
    }
}
