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

@WebServlet(name = "AddCustomerCardServlet", urlPatterns = {"/add-customerCard"})
public class AddCustomerCardServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(com.naukma.supermarket.controller
            .customerCard.AddCustomerCardServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/customerCard/addCustomerCard.jsp");
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

        CustomerCard customerCard = new CustomerCard(cardNum, custSurname, custName,
                custPatronymic, phoneNum, city, street, zipCode, percent);

//        if (firstName.length() > 0 && lastName.length() > 0 ) {
//        //if (firstName.length() > 0 && lastName.length() > 0 && FieldsValidator.isCorrectWord(firstName) && FieldsValidator.isCorrectWord(firstName)) {
        CustomerCardService customerCardService = new CustomerCardServiceImpl();
        customerCardService.create(customerCard);

//        request.setAttribute("lastName", lastName);
//        }
        LOGGER.info("doPost process");
        doGet(request, response);
    }

}
