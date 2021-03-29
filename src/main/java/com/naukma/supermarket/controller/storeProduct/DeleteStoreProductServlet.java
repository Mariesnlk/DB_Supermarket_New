package com.naukma.supermarket.controller.storeProduct;

import com.naukma.supermarket.model.StoreProduct;
import com.naukma.supermarket.service.impl.StoreProductServiceImpl;
import com.naukma.supermarket.service.interf.StoreProductService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteStoreProductServlet", urlPatterns = {"/delete-storeProduct"})
public class DeleteStoreProductServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(DeleteStoreProductServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("doGet process");
        doDelete(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String upc = request.getParameter("upc");

        StoreProductService storeProductService = new StoreProductServiceImpl();
        StoreProduct storeProductToDelete = storeProductService.findById(upc);
        storeProductService.delete(storeProductToDelete);

        response.sendRedirect("/storeProducts");
    }
}
