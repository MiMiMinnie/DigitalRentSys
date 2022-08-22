package com.south.controller;

import com.south.entity.Admin;
import com.south.entity.User;
import com.south.service.LoginService;
import com.south.service.impl.LoginServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();

    /**
     * 处理登录业务的逻辑
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        Object object = loginService.login(username,password,type);
        if(object != null){
            HttpSession session = req.getSession();
            switch (type){
                case "user":
                    User user = (User) object;
                    session.setAttribute("user", user);
                    //跳转到用户的页面
//                    List<Product> list = bookService.findAll(1);
//                    req.setAttribute("list",list);
//                    req.setAttribute("dataPrePage",6);
//                    req.setAttribute("currentPage",1);
//                    req.setAttribute("pages",productService.getPages());
//                    req.getRequestDispatcher("index.jsp").forward(req,resp);
                    resp.sendRedirect("/product?page=1");
                    break;
                case "admin":
                    Admin admin = (Admin) object;
                    session.setAttribute("admin",admin);
                    //跳转到管理员的页面
                    resp.sendRedirect("admin?method=findAllBorrow&page=1");
                    break;
            }
        }else{
            resp.sendRedirect("login.jsp");
        }
    }
}
