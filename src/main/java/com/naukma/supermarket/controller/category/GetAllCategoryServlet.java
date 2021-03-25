package com.naukma.supermarket.controller.category;

import com.naukma.supermarket.model.Category;
import com.naukma.supermarket.service.impl.CategoryServiceImpl;
import com.naukma.supermarket.service.interf.CategoryService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllCategoryServlet", urlPatterns = {"/categories"})
public class GetAllCategoryServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(GetAllCategoryServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryService categoryService = new CategoryServiceImpl();

        List<Category> allCategories = categoryService.findAll();
        request.setAttribute("allCategories", allCategories);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/category/allCategories.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }

}
