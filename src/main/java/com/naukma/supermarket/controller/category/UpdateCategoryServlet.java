package com.naukma.supermarket.controller.category;

import com.naukma.supermarket.controller.product.UpdateProductServlet;
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

@WebServlet(name = "UpdateCategoryServlet", urlPatterns = {"/update-category"})
public class UpdateCategoryServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(UpdateProductServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryService categoryService = new CategoryServiceImpl();

        Integer idCategory = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.findById(idCategory);
        request.setAttribute("categoryToUpdate", category);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/category/updateCategory.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer idCategory = Integer.parseInt(request.getParameter("id"));
        String categoryName = request.getParameter("category_name");

        Category categoryUpdate = new Category(idCategory, categoryName);
        CategoryService categoryService = new CategoryServiceImpl();

        categoryService.update(categoryUpdate);

        response.sendRedirect("/categories");

    }
}
