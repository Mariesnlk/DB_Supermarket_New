package com.naukma.supermarket.controller.employee;

import com.naukma.supermarket.model.Employee;
import com.naukma.supermarket.service.impl.EmployeeServiceImpl;
import com.naukma.supermarket.service.interf.EmployeeService;
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

@WebServlet(name = "AddEmployeeServlet", urlPatterns = {"/add-employee"})
public class AddEmployeeServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(AddEmployeeServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/employee/addEmployee.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String patronymicName = request.getParameter("patronymicName");
        String role = request.getParameter("role");
        double salary = Double.parseDouble(request.getParameter("salary"));


        // Date birthDate = Date.valueOf(request.getParameter("birthDate"));
        String availableBirthDate = request.getParameter("birthDate");

        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null; //converted String to date in the desired format
        try {
            d = new SimpleDateFormat("yyyy-MM-dd").parse(availableBirthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Date d1 = new java.sql.Date(d.getTime());//formatted to java.sql.date format to store in database

        Date startDate = Date.valueOf(request.getParameter("startDate"));

        String phoneNum = request.getParameter("phoneNum");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String zipCode = request.getParameter("zipCode");


        Employee employee = new Employee(id, lastName, firstName, patronymicName, role, salary, d1, startDate,
                phoneNum, city, street, zipCode);

//        if (firstName.length() > 0 && lastName.length() > 0 ) {
//        //if (firstName.length() > 0 && lastName.length() > 0 && FieldsValidator.isCorrectWord(firstName) && FieldsValidator.isCorrectWord(firstName)) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        employeeService.create(employee);

//        request.setAttribute("lastName", lastName);
//        }
        LOGGER.info("doPost process");
        doGet(request, response);
    }

}
