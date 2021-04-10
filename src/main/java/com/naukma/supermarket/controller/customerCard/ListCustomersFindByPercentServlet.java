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

@WebServlet(name = "ListCustomersFindByPercentServlet", urlPatterns = {"/list-customers-by-percent"})
public class ListCustomersFindByPercentServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(ListCustomersFindByPercentServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerCardService customerCardService = new CustomerCardServiceImpl();

        Integer percent = Integer.parseInt(request.getParameter("percent"));

        List<CustomerCard> allCustomerCards = customerCardService.customerWithPercent(percent);
        request.setAttribute("allCustomerCards", allCustomerCards);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/customerCard/allCustomerCards.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }
}
