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

@WebServlet(name = "DeleteProductServlet", urlPatterns = {"/delete-product"})
public class DeleteProductServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(com.naukma.supermarket
            .controller.product.DeleteProductServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("doGet process");
        doDelete(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idProduct = Integer.parseInt(request.getParameter("id"));

        ProductService productService = new ProductServiceImpl();
        Product productToDelete = productService.findById(idProduct);
        productService.delete(productToDelete);

        response.sendRedirect("/products");
    }
}