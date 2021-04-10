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
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "CountSoldProductByPeriodServlet", urlPatterns = {"/count-sold-product-by-period"})
public class CountSoldProductByPeriodServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(CountSoldProductByPeriodServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SaleService saleService = new SaleServiceImpl();

        String productName = request.getParameter("nameProd");

        String availableFirstDate = request.getParameter("dateStart");
        String availableSecondDate = request.getParameter("dateFinish");
        java.util.Date d = null;
        java.util.Date d1 = null;
        try {
            d = new SimpleDateFormat("yyyy-MM-dd").parse(availableFirstDate);
            d1 = new SimpleDateFormat("yyyy-MM-dd").parse(availableSecondDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date dateStart = new java.sql.Date(d.getTime());
        java.sql.Date dateFinish = new java.sql.Date(d1.getTime());


        Sale sale = saleService.productCount(productName, dateStart, dateFinish);
        request.setAttribute("sale", sale);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/sale/showSale.jsp");
        LOGGER.info("doPost process");
        requestDispatcher.forward(request, response);

    }
}