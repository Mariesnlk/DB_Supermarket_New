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

@WebServlet(name = "SortedCategoriesByNameServlet", urlPatterns = {"/sorted-categories-name"})
public class SortedCategoriesByNameServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(SortedCategoriesByNameServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryService categoryService = new CategoryServiceImpl();

        List<Category> allCategories = categoryService.categoriesSortedByName();
        request.setAttribute("allCategories", allCategories);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/category/allCategories.jsp");
        LOGGER.info("doPost process");
        requestDispatcher.forward(request, response);
    }
}
