package com.naukma.supermarket.controller.check;

import com.naukma.supermarket.model.Check;
import com.naukma.supermarket.model.CustomerCard;
import com.naukma.supermarket.model.Employee;
import com.naukma.supermarket.service.impl.CheckServiceImpl;
import com.naukma.supermarket.service.impl.CustomerCardServiceImpl;
import com.naukma.supermarket.service.impl.EmployeeServiceImpl;
import com.naukma.supermarket.service.interf.CheckService;
import com.naukma.supermarket.service.interf.CustomerCardService;
import com.naukma.supermarket.service.interf.EmployeeService;
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
import java.util.List;

@WebServlet(name = "AddCheckServlet", urlPatterns = {"/add-check"})
public class AddCheckServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(AddCheckServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeeService employeeService = new EmployeeServiceImpl();

        List<Employee> allEmployees = employeeService.findAll();
        request.setAttribute("allEmployees", allEmployees);

        CustomerCardService customerCardService = new CustomerCardServiceImpl();

        List<CustomerCard> allCustomerCards = customerCardService.findAll();
        request.setAttribute("allCustomerCards", allCustomerCards);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/check/addCheck.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String checkNumber = request.getParameter("checkNumber");
        String idEmployee = request.getParameter("idEmployee");
        String cardNumber = request.getParameter("cardNumber");

        String availablePrintDate = request.getParameter("printDate");
        java.util.Date d = null;
        try {
            d = new SimpleDateFormat("yyyy-MM-dd").parse(availablePrintDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date printDate = new java.sql.Date(d.getTime());

        //Double sumTotal = Double.parseDouble(request.getParameter("sumTotal"));
        //Double vat = Double.parseDouble(request.getParameter("vat"));

        Double sumTotal = Double.valueOf(0);
        Double vat = Double.valueOf(0);

        Check check = new Check(checkNumber, idEmployee, cardNumber, printDate, sumTotal, vat);

        CheckService checkService = new CheckServiceImpl();
        checkService.create(check);

        LOGGER.info("doPost process");
        doGet(request, response);
    }

}
