package com.naukma.supermarket.controller.product;

import com.naukma.supermarket.model.Product;
import com.naukma.supermarket.service.impl.ProductServiceImpl;
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

@WebServlet(name = "GetAllProductsServlet", urlPatterns = {"/products"})
public class GetAllProductsServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(com.naukma.supermarket
            .controller.product.GetAllProductsServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = new ProductServiceImpl();

        List<Product> allProducts = productService.findAll();
        request.setAttribute("allProducts", allProducts);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/product/allProducts.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }

}