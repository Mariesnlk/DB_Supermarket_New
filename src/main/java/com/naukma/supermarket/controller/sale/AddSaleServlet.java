package com.naukma.supermarket.controller.sale;

import com.naukma.supermarket.model.Check;
import com.naukma.supermarket.model.Sale;
import com.naukma.supermarket.model.StoreProduct;
import com.naukma.supermarket.service.impl.CheckServiceImpl;
import com.naukma.supermarket.service.impl.SaleServiceImpl;
import com.naukma.supermarket.service.impl.StoreProductServiceImpl;
import com.naukma.supermarket.service.interf.CheckService;
import com.naukma.supermarket.service.interf.SaleService;
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

@WebServlet(name = "AddSaleServlet", urlPatterns = {"/add-sale"})
public class AddSaleServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(AddSaleServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StoreProductService storeProductService = new StoreProductServiceImpl();

        List<StoreProduct> allStoreProducts = storeProductService.findAll();
        request.setAttribute("allStoreProducts", allStoreProducts);

        CheckService checkService = new CheckServiceImpl();

        List<Check> allChecks = checkService.findAll();
        request.setAttribute("allChecks", allChecks);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/sale/addSale.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String UPC = request.getParameter("upc");
        String checkNumber = request.getParameter("checkNumber");
        Integer productNum = Integer.parseInt(request.getParameter("productNum"));
//        Double sellingPrice = Double.parseDouble(request.getParameter("sellingPrice"));
        Double sellingPrice = Double.valueOf(0);

        Sale sale = new Sale(UPC, checkNumber, productNum, sellingPrice);

//        if (firstName.length() > 0 && lastName.length() > 0 ) {
//        //if (firstName.length() > 0 && lastName.length() > 0 && FieldsValidator.isCorrectWord(firstName) && FieldsValidator.isCorrectWord(firstName)) {
        SaleService saleService = new SaleServiceImpl();
        saleService.create(sale);

//        request.setAttribute("lastName", lastName);
//        }
        LOGGER.info("doPost process");
        doGet(request, response);
    }

}
