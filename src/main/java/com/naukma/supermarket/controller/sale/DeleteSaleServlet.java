package com.naukma.supermarket.controller.sale;

import com.naukma.supermarket.model.Sale;
import com.naukma.supermarket.service.impl.SaleServiceImpl;
import com.naukma.supermarket.service.interf.SaleService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteSaleServlet", urlPatterns = {"/delete-sale"})
public class DeleteSaleServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(com.naukma.supermarket
            .controller.sale.DeleteSaleServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("doGet process");
        doDelete(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String upc = request.getParameter("upc");

        SaleService saleService = new SaleServiceImpl();
        Sale saleToDelete = saleService.findById(upc);
        saleService.delete(saleToDelete);

        response.sendRedirect("/sales");
    }
}
