package com.naukma.supermarket.controller.storeProduct;

import com.naukma.supermarket.model.StoreProduct;
import com.naukma.supermarket.service.impl.StoreProductServiceImpl;
import com.naukma.supermarket.service.interf.StoreProductService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetStoreProductByIdServlet", urlPatterns = {"/storeProduct"})
public class GetStoreProductByIdServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(com.naukma.supermarket.controller
            .storeProduct.GetStoreProductByIdServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StoreProductService storeProductService = new StoreProductServiceImpl();

        String upc = request.getParameter("upc");

        StoreProduct storeProduct = storeProductService.findById(upc);
        request.setAttribute("storeProduct", storeProduct);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/storeProduct/showStoreProduct.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);

    }
}
