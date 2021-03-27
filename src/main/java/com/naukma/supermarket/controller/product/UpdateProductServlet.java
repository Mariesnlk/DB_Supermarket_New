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

@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/update-product"})
public class UpdateProductServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(UpdateProductServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = new ProductServiceImpl();

        Integer idProduct = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(idProduct);
        request.setAttribute("productToUpdate", product);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/product/updateProduct.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer idProduct = Integer.parseInt(request.getParameter("id"));
        int categoryNumber = Integer.parseInt(request.getParameter("category_number"));
        String productName = request.getParameter("product_name");
        String characteristics = request.getParameter("characteristics");

        Product updateProduct = new Product(idProduct, categoryNumber, productName, characteristics);
        ProductService productService = new ProductServiceImpl();

        productService.update(updateProduct);

        response.sendRedirect("/products");

    }
}

