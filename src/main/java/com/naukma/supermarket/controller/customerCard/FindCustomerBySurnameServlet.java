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

@WebServlet(name = "FindCustomerBySurnameServlet", urlPatterns = {"/"})
public class FindCustomerBySurnameServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(com.naukma.supermarket.controller
            .customerCard.GetAllCustomerCardsServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerCardService customerCardService = new CustomerCardServiceImpl();

        String surname = request.getParameter("cust_surname");
        CustomerCard customerCard = customerCardService.customerWithSurname(surname);
        request.setAttribute("customerCard", customerCard);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/customerCard/showCustomerCard.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }
}
