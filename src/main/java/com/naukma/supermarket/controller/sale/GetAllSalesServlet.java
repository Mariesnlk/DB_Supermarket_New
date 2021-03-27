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
import java.util.List;

@WebServlet(name = "GetAllSalesServlet", urlPatterns = {"/sales"})
public class GetAllSalesServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(com.naukma.supermarket.controller
            .sale.GetAllSalesServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SaleService saleService = new SaleServiceImpl();

        List<Sale> allSales = saleService.findAll();
        request.setAttribute("allSales", allSales);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/sale/allSales.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }
}
