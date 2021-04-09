package com.naukma.supermarket.controller.login;

import com.naukma.supermarket.model.Category;
import com.naukma.supermarket.model.Product;
import com.naukma.supermarket.service.impl.CategoryServiceImpl;
import com.naukma.supermarket.service.impl.ProductServiceImpl;
import com.naukma.supermarket.service.interf.CategoryService;
import com.naukma.supermarket.service.interf.ProductService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagerServlet", urlPatterns = {"/index-manager"})
public class ManagerServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(ManagerServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryService categoryService = new CategoryServiceImpl();

        List<Category> allCategories = categoryService.findAll();
        request.setAttribute("allCategories", allCategories);

//        ProductService productService = new ProductServiceImpl();
//
//        List<Product> allProducts = productService.findAll();
//        request.setAttribute("allProducts", allProducts);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("indexManager.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }












}
