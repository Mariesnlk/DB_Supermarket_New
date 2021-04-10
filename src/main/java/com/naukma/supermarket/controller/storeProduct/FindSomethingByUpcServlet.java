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

@WebServlet(name = "FindSomethingByUpcServlet", urlPatterns = {"/storeProductByUpc"})
public class FindSomethingByUpcServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(FindSomethingByUpcServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StoreProductService storeProductService = new StoreProductServiceImpl();

        String upc = request.getParameter("upc");

        StoreProduct storeProduct = storeProductService.findSomethingByUpc(upc);
        request.setAttribute("storeProductByUpc", storeProduct);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/storeProduct/showStoreProductByUpc.jsp");
        LOGGER.info("doPost process");
        requestDispatcher.forward(request, response);

    }
}
