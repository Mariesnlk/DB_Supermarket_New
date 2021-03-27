package com.naukma.supermarket.controller.category;

import com.naukma.supermarket.controller.employee.DeleteEmployeeServlet;
import com.naukma.supermarket.model.Category;
import com.naukma.supermarket.model.Employee;
import com.naukma.supermarket.service.impl.CategoryServiceImpl;
import com.naukma.supermarket.service.impl.EmployeeServiceImpl;
import com.naukma.supermarket.service.interf.CategoryService;
import com.naukma.supermarket.service.interf.EmployeeService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCategoryServlet", urlPatterns = {"/delete-category"})
public class DeleteCategoryServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(DeleteCategoryServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("doGet process");
        doDelete(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idCategory = Integer.parseInt(request.getParameter("id"));

        CategoryService categoryService = new CategoryServiceImpl();
        Category categoryToDelete = categoryService.findById(idCategory);
        categoryService.delete(categoryToDelete);

        response.sendRedirect("/categories");
    }
}
