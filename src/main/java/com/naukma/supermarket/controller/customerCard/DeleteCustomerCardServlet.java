package com.naukma.supermarket.controller.customerCard;

import com.naukma.supermarket.model.CustomerCard;
import com.naukma.supermarket.service.impl.CustomerCardServiceImpl;
import com.naukma.supermarket.service.interf.CustomerCardService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCustomerCardServlet", urlPatterns = {"/delete-customerCard"})
public class DeleteCustomerCardServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(com.naukma.supermarket
            .controller.customerCard.DeleteCustomerCardServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("doGet process");
        doDelete(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cardNum = request.getParameter("cardNum");

        CustomerCardService customerCardService = new CustomerCardServiceImpl();
        CustomerCard customerCardToDelete = customerCardService.findById(cardNum);
        customerCardService.delete(customerCardToDelete);

        response.sendRedirect("/customerCards");
    }
}
