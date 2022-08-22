package com.south.controller;

import com.south.entity.Admin;
import com.south.entity.Borrow;
import com.south.service.ProductService;
import com.south.service.impl.ProductServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "findAllBorrow";
        }
        HttpSession session = req.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        switch (method) {
            case "findAllBorrow":
                String pageStr = req.getParameter("page");
                Integer page = Integer.parseInt(pageStr);
                List<Borrow> borrowList = productService.findAllBorrowByState(0, page);
                req.setAttribute("list", borrowList);
                req.setAttribute("dataPrePage", 6);
                req.setAttribute("currentPage", page);
                req.setAttribute("pages", productService.getBorrowPagesByState(0));
                req.getRequestDispatcher("admin.jsp").forward(req, resp);
                break;
            case "handle":
                String idStr = req.getParameter("id");
                String stateStr = req.getParameter("state");
                Integer id = Integer.parseInt(idStr);
                Integer state = Integer.parseInt(stateStr);
                productService.handleBorrow(id,state,admin.getId());
                if(state == 1 || state == 2){
                    resp.sendRedirect("/admin?page=1");
                }
                if(state == 3){
                    resp.sendRedirect("/admin?method=getBorrowed&page=1");
                }
                break;
            case "getBorrowed":
                pageStr = req.getParameter("page");
                page = Integer.parseInt(pageStr);
                borrowList = productService.findAllBorrowByState(1,page);
                req.setAttribute("list", borrowList);
                req.setAttribute("dataPrePage", 6);
                req.setAttribute("currentPage", page);
                req.setAttribute("pages", productService.getBorrowPagesByState(1));
                req.getRequestDispatcher("return.jsp").forward(req, resp);
                break;
        }
    }
}
