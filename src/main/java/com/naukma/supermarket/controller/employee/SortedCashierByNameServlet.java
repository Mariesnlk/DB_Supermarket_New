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
import java.util.List;

@WebServlet(name = "SortedCashierByNameServlet", urlPatterns = {"/sorted-cashier-name"})
public class SortedCashierByNameServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(GetAllEmployeesServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeeService employeeService = new EmployeeServiceImpl();

        List<Employee> allEmployees = employeeService.findAll();//
        request.setAttribute("allEmployees", allEmployees);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/employee/allEmployees.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }

}
