package com.naukma.supermarket.controller.login;

import com.naukma.supermarket.model.*;
import com.naukma.supermarket.service.impl.*;
import com.naukma.supermarket.service.interf.*;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "ManagerServlet", urlPatterns = {"/index-manager"})
public class ManagerServlet extends HttpServlet {

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

        //all storeProducts
        StoreProductService storeProductService = new StoreProductServiceImpl();

        List<StoreProduct> allStoreProducts = storeProductService.findAll();
        request.setAttribute("allStoreProducts", allStoreProducts);

        //all customerCards
        CustomerCardService customerCardService = new CustomerCardServiceImpl();

        List<CustomerCard> allCustomerCards = customerCardService.findAll();
        request.setAttribute("allCustomerCards", allCustomerCards);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("indexManager.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }












}
