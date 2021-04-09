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

@WebServlet(name = "GetEmployeeInfoBySurnameServlet", urlPatterns = {"/show-employee-info"})
public class GetEmployeeInfoBySurnameServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(GetEmployeeInfoBySurnameServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeeService employeeService = new EmployeeServiceImpl();

        String surname = request.getParameter("lastName");
        Employee employee = employeeService.getEmployeeBySurname(surname);
        request.setAttribute("employeeSpecific", employee);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/employee/showEmployeeInfo.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);

    }
}