package com.naukma.supermarket.controller.category;

import com.naukma.supermarket.controller.product.GetProductByIdServlet;
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

@WebServlet(name = "GetCategoryByIdServlet", urlPatterns = {"/category"})
public class GetCategoryByIdServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(GetCategoryByIdServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryService categoryService = new CategoryServiceImpl();

        Integer idCategory = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.findById(idCategory);
        request.setAttribute("category", category);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/category/showCategory.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);

    }
}
