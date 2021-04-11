package com.naukma.supermarket.controller.storeProduct;

import com.naukma.supermarket.model.StoreProductAndProduct;
import com.naukma.supermarket.service.impl.StoreProductAndProductServiceImpl;
import com.naukma.supermarket.service.interf.StoreProductAndProductService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindInfoByUpcServlet", urlPatterns = {"/find-lot-info-by-upc"})
public class FindInfoByUpcServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(FindInfoByUpcServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StoreProductAndProductService storeProductService = new StoreProductAndProductServiceImpl();

        String upc = request.getParameter("upc");

        StoreProductAndProduct showStoreProductByUpcExtended = storeProductService.findInfoByUPC(upc);
        request.setAttribute("storeProductByUpcExtended", showStoreProductByUpcExtended);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/storeProduct/showStoreProductByUpcExtended.jsp");
        LOGGER.info("doPost process");
        requestDispatcher.forward(request, response);

    }
}