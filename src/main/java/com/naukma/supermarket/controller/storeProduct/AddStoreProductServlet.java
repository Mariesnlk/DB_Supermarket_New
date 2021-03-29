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

@WebServlet(name = "AddStoreProductServlet", urlPatterns = {"/add-storeProduct"})
public class AddStoreProductServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(AddStoreProductServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/storeProduct/addStoreProduct.jsp");
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

        StoreProduct storeProduct = new StoreProduct(UPC, UPCProm, idProduct, sellingPrice,
                productsNum, promotionalProduct);

//        if (firstName.length() > 0 && lastName.length() > 0 ) {
//        //if (firstName.length() > 0 && lastName.length() > 0 && FieldsValidator.isCorrectWord(firstName) && FieldsValidator.isCorrectWord(firstName)) {
        StoreProductService storeProductService = new StoreProductServiceImpl();
        storeProductService.create(storeProduct);

//        request.setAttribute("lastName", lastName);
//        }
        LOGGER.info("doPost process");
        doGet(request, response);
    }

}
