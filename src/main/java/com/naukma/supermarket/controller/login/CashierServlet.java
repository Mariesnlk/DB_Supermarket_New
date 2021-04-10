package com.naukma.supermarket.controller.login;

import com.naukma.supermarket.model.Category;
import com.naukma.supermarket.model.Check;
import com.naukma.supermarket.model.Employee;
import com.naukma.supermarket.model.Product;
import com.naukma.supermarket.service.impl.CategoryServiceImpl;
import com.naukma.supermarket.service.impl.CheckServiceImpl;
import com.naukma.supermarket.service.impl.EmployeeServiceImpl;
import com.naukma.supermarket.service.impl.ProductServiceImpl;
import com.naukma.supermarket.service.interf.CategoryService;
import com.naukma.supermarket.service.interf.CheckService;
import com.naukma.supermarket.service.interf.EmployeeService;
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

@WebServlet(name = "CashierServlet", urlPatterns = {"/index-cashier"})
public class CashierServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(ManagerServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //all categories
        CategoryService categoryService = new CategoryServiceImpl();

        List<Category> allCategories = categoryService.findAll();
        request.setAttribute("allCategories", allCategories);

        //all products
        ProductService productService = new ProductServiceImpl();

        List<Product> allProducts = productService.findAll();
        request.setAttribute("allProducts", allProducts);

        //all employees
        EmployeeService employeeService = new EmployeeServiceImpl();

        List<Employee> allEmployees = employeeService.findAll();
        request.setAttribute("allEmployees", allEmployees);

        //all checks
        CheckService checkService = new CheckServiceImpl();

        List<Check> allChecks = checkService.findAll();
        request.setAttribute("allChecks", allChecks);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("indexCashier.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }
}
