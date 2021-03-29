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

@WebServlet(name = "GetSaleByIdServlet", urlPatterns = {"/sale"})
public class GetSaleByIdServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(GetSaleByIdServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SaleService saleService = new SaleServiceImpl();

        String upc = request.getParameter("upc");
        Sale sale = saleService.findById(upc);
        request.setAttribute("sale", sale);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/sale/showSale.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);

    }
}
