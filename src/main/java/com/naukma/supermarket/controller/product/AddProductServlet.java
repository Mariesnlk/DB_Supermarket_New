package com.naukma.supermarket.controller.product;

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

@WebServlet(name = "AddProductServlet", urlPatterns = {"/add-product"})
public class AddProductServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(com.naukma.supermarket.controller.product.AddProductServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl();

        List<Category> allCategories = categoryService.findAll();
        request.setAttribute("allCategories", allCategories);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/product/addProduct.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer category_number = Integer.parseInt(request.getParameter("categoryProd"));
        String product_name = request.getParameter("nameProd");
        String characteristics = request.getParameter("charsProd");

        Product product = new Product(category_number, product_name, characteristics);

//        if (firstName.length() > 0 && lastName.length() > 0 ) {
//        //if (firstName.length() > 0 && lastName.length() > 0 && FieldsValidator.isCorrectWord(firstName) && FieldsValidator.isCorrectWord(firstName)) {
        ProductService productService = new ProductServiceImpl();
        productService.create(product);

//        request.setAttribute("lastName", lastName);
//        }
        LOGGER.info("doPost process");
        doGet(request, response);
    }
}

