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

@WebServlet(name = "GetAllStoreProductsServlet", urlPatterns = {"/storeProducts"})
public class GetAllStoreProductsServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(GetAllStoreProductsServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StoreProductService storeProductService = new StoreProductServiceImpl();

        List<StoreProduct> allStoreProducts = storeProductService.findAll();
        request.setAttribute("allStoreProducts", allStoreProducts);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/storeProduct/allStoreProducts.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }
}
