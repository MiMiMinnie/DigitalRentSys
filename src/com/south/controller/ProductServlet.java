package com.south.controller;

import com.south.entity.Product;
import com.south.entity.Borrow;
import com.south.entity.User;
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

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null){
            method = "findAll";
        }
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        switch (method){
            case "findAll":
                String pageStr = req.getParameter("page");
                Integer page = Integer.parseInt(pageStr);
                List<Product> list = productService.findAll(page );
                req.setAttribute("list",list);
                req.setAttribute("dataPrePage",6);
                req.setAttribute("currentPage",page);
                req.setAttribute("pages", productService.getPages());
                req.getRequestDispatcher("index.jsp").forward(req,resp);
                break;
            case "addBorrow":
                String productidStr = req.getParameter("productid");
                Integer productid = Integer.parseInt(productidStr);
                productService.addBorrow(productid, user.getId());
                resp.sendRedirect("/product?method=findAllBorrow&page=1");
                break;

            case "findAllBorrow":
                pageStr = req.getParameter("page");
                page = Integer.parseInt(pageStr);
                List<Borrow> borrowList = productService.findAllBorrowByUserId(user.getId(),page);
                req.setAttribute("list",borrowList);
                req.setAttribute("dataPrePage",6);
                req.setAttribute("currentPage",page);
                req.setAttribute("pages", productService.getBorrowPages(user.getId()));
                req.getRequestDispatcher("borrow.jsp").forward(req,resp);
                break;
        }
    }
}
