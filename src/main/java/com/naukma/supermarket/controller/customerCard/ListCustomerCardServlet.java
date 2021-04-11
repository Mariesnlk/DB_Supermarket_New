package com.naukma.supermarket.controller.customerCard;

import com.naukma.supermarket.model.CustomerCard;
import com.naukma.supermarket.service.impl.CustomerCardServiceImpl;
import com.naukma.supermarket.service.interf.CustomerCardService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListCustomerCardServlet", urlPatterns = {"/list-customer-card"})
public class ListCustomerCardServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(ListCustomerCardServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerCardService customerCardService = new CustomerCardServiceImpl();

        List<CustomerCard> allCustomerCards = customerCardService.listAllCustomers();
        request.setAttribute("allCustomerCards", allCustomerCards);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/customerCard/allCustomerCardsSpecific.jsp");
        LOGGER.info("doPost process");
        requestDispatcher.forward(request, response);
    }
}
