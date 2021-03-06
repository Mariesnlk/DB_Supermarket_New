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
import java.util.List;

@WebServlet(name = "ListStoreProductsByProductNameServlet", urlPatterns = {"/list-store-products"})
public class ListStoreProductsByProductNameServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(ListStoreProductsByProductNameServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StoreProductService storeProductService = new StoreProductServiceImpl();

        String productName = request.getParameter("nameProd");

        List<StoreProduct> allStoreProducts = storeProductService.allStoreProductsByProductName(productName);
        request.setAttribute("allStoreProducts", allStoreProducts);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/storeProduct/allStoreProducts.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }
}