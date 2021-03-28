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

@WebServlet(name = "UpdateStoreProductServlet", urlPatterns = {"/update-storeProduct"})
public class UpdateStoreProductServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(com.naukma.supermarket
            .controller.storeProduct.UpdateStoreProductServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StoreProductService storeProductService = new StoreProductServiceImpl();

        String upc = request.getParameter("upc");

        StoreProduct storeProduct = storeProductService.findById(upc);
        request.setAttribute("storeProductToUpdate", storeProduct);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/storeProduct/updateStoreProduct.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String UPC = request.getParameter("upc");
        String UPCProm = request.getParameter("UPCProm");
        Integer idProduct = Integer.parseInt(request.getParameter("idProduct"));
        Double sellingPrice = Double.parseDouble(request.getParameter("sellingPrice"));
        Integer productsNum = Integer.parseInt(request.getParameter("productsNum"));
        Boolean promotionalProduct = Boolean.parseBoolean(request.getParameter("promotionalProduct"));

        StoreProduct updateStoreProduct = new StoreProduct(UPC, UPCProm, idProduct, sellingPrice,
                productsNum, promotionalProduct);

        StoreProductService storeProductService = new StoreProductServiceImpl();

        storeProductService.update(updateStoreProduct);

        response.sendRedirect("/storeProducts");
    }
}
