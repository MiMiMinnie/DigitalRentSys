package com.south.filter;

import com.south.entity.User;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/product")
public class UserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)servletRequest).getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            ((HttpServletResponse)servletResponse).sendRedirect("login.jsp");
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
