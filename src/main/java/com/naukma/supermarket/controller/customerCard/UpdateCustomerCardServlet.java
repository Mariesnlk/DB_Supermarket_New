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

@WebServlet(name = "UpdateCustomerCardServlet", urlPatterns = {"/update-customerCard"})
public class UpdateCustomerCardServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(com.naukma.supermarket
            .controller.customerCard.UpdateCustomerCardServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerCardService customerCardService = new CustomerCardServiceImpl();

        String cardNum = request.getParameter("cardNum");
        CustomerCard customerCard = customerCardService.findById(cardNum);
        request.setAttribute("customerCardToUpdate", customerCard);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/customerCard/updateCustomerCard.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cardNum = request.getParameter("cardNum");
        String custSurname = request.getParameter("custSurname");
        String custName = request.getParameter("custName");
        String custPatronymic = request.getParameter("custPatronymic");
        String phoneNum = request.getParameter("phoneNum");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String zipCode = request.getParameter("zipCode");
        Integer percent = Integer.parseInt(request.getParameter("percent"));

        CustomerCard updateCustomerCard = new CustomerCard(cardNum, custSurname, custName,
                custPatronymic, phoneNum, city, street, zipCode, percent);

        CustomerCardService customerCardService = new CustomerCardServiceImpl();

        customerCardService.update(updateCustomerCard);

        response.sendRedirect("/customerCards");
    }
}
