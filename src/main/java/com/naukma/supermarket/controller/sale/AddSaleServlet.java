package com.naukma.supermarket.controller.sale;

import com.naukma.supermarket.model.Sale;
import com.naukma.supermarket.service.impl.SaleServiceImpl;
import com.naukma.supermarket.service.interf.SaleService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddSaleServlet", urlPatterns = {"/add-sale"})
public class AddSaleServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(com.naukma.supermarket.controller
            .sale.AddSaleServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/sale/addSale.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String UPC = request.getParameter("upc");
        String checkNumber = request.getParameter("checkNumber");
        Integer productNum = Integer.parseInt(request.getParameter("productNum"));
        Double sellingPrice = Double.parseDouble(request.getParameter("sellingPrice"));

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
