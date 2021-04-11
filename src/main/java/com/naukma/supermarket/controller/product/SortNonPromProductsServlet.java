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

@WebServlet(name = "SortNonPromProductsServlet", urlPatterns = {"/sort-non-prom"})
public class SortNonPromProductsServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(SortNonPromProductsServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = new ProductServiceImpl();
        List<Product> allProducts = null;

        String sorting = request.getParameter("sorting");
        System.out.println(sorting);

        if (sorting.equals("byQuantity")) {
            allProducts = productService.nonPromProductsSortedByQuantity();
            System.out.println(allProducts);
        } else if(sorting.equals("byName")){
            allProducts = productService.nonPromProductsSortedByName();
            System.out.println(allProducts);
        }

        request.setAttribute("allProductNames", allProducts);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/product/allProductNames.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }
}
