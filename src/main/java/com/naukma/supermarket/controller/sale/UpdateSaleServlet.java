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

@WebServlet(name = "UpdateSaleServlet", urlPatterns = {"/update-sale"})
public class UpdateSaleServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(UpdateSaleServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SaleService saleService = new SaleServiceImpl();

        String upc = request.getParameter("upc");
        Sale sale = saleService.findById(upc);
        request.setAttribute("saleToUpdate", sale);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/sale/updateSale.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String newUPC = request.getParameter("upc");
        String newCheckNumber = request.getParameter("checkNumber");
        Integer newProductNum = Integer.parseInt(request.getParameter("productNum"));
//        Double newSellingPrice = Double.parseDouble(request.getParameter("sellingPrice"));
        Double newSellingPrice = Double.valueOf(0);


        Sale updateSale = new Sale(newUPC, newCheckNumber, newProductNum, newSellingPrice);

        SaleService saleService = new SaleServiceImpl();

        saleService.update(updateSale);

        response.sendRedirect("/sales");
    }
}
