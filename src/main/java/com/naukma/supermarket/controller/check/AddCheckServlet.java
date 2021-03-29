package com.naukma.supermarket.controller.check;

import com.naukma.supermarket.model.Check;
import com.naukma.supermarket.service.impl.CheckServiceImpl;
import com.naukma.supermarket.service.interf.CheckService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "AddCheckServlet", urlPatterns = {"/add-check"})
public class AddCheckServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(AddCheckServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/check/addCheck.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String checkNumber = request.getParameter("checkNumber");
        String idEmployee = request.getParameter("idEmployee");
        String cardNumber = request.getParameter("cardNumber");

        String availablePrintDate = request.getParameter("printDate");
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        try {
            d = new SimpleDateFormat("yyyy-MM-dd").parse(availablePrintDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date printDate = new java.sql.Date(d.getTime());

        Double sumTotal = Double.parseDouble(request.getParameter("sumTotal"));
        Double vat = Double.parseDouble(request.getParameter("vat"));

        Check check = new Check(checkNumber, idEmployee, cardNumber, printDate, sumTotal, vat);

//        if (firstName.length() > 0 && lastName.length() > 0 ) {
//        //if (firstName.length() > 0 && lastName.length() > 0 && FieldsValidator.isCorrectWord(firstName) && FieldsValidator.isCorrectWord(firstName)) {
        CheckService checkService = new CheckServiceImpl();
        checkService.create(check);

//        request.setAttribute("lastName", lastName);
//        }
        LOGGER.info("doPost process");
        doGet(request, response);
    }

}
