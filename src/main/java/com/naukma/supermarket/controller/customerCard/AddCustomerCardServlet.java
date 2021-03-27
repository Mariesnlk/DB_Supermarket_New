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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//@WebServlet(name = "AddEmployeeServlet", urlPatterns = {"/add-employee"})
//public class AddCustomerCardServlet extends HttpServlet {
//
//    private final Logger LOGGER = Logger.getLogger(com.naukma.supermarket.controller.employee.AddEmployeeServlet.class);
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/employee/addEmployee.jsp");
//        LOGGER.info("doGet process");
//        requestDispatcher.forward(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String id = request.getParameter("id");
//        String lastName = request.getParameter("lastName");
//        String firstName = request.getParameter("firstName");
//        String patronymicName = request.getParameter("patronymicName");
//        String role = request.getParameter("role");
//        String phoneNum = request.getParameter("phoneNum");
//        String city = request.getParameter("city");
//        String street = request.getParameter("street");
//        String zipCode = request.getParameter("zipCode");
//        Integer percent = Integer.parseInt(request.getParameter("percent"));
//
//        CustomerCard сustomerCard = new CustomerCard(id, lastName, firstName, patronymicName, role, salary, d1, startDate,
//                phoneNum, city, street, zipCode, percent);
//
////        if (firstName.length() > 0 && lastName.length() > 0 ) {
////        //if (firstName.length() > 0 && lastName.length() > 0 && FieldsValidator.isCorrectWord(firstName) && FieldsValidator.isCorrectWord(firstName)) {
//        CustomerCardService сustomerCardService = new CustomerCardServiceImpl();
//        сustomerCardService.create(сustomerCard);
//
////        request.setAttribute("lastName", lastName);
////        }
//        LOGGER.info("doPost process");
//        doGet(request, response);
//    }
//
//}
