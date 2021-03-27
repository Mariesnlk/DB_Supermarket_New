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

@WebServlet(name = "GetProductByIdServlet", urlPatterns = {"/product"})
public class GetProductByIdServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(GetProductByIdServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = new ProductServiceImpl();

        Integer idProduct = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(idProduct);
        request.setAttribute("product", product);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/product/showProduct.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);

    }
}