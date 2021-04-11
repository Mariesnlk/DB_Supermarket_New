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

@WebServlet(name = "GetCurrEmplServlet", urlPatterns = {"/employeeCurr"})
public class GetCurrEmplServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(GetCurrEmplServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeeService employeeService = new EmployeeServiceImpl();

        String idEmployee = request.getParameter("id");
        Employee employee = employeeService.findById(idEmployee);
        request.setAttribute("employeeCurr", employee);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/employee/showCurrEmployee.jsp");
        LOGGER.info("doPost process");
        requestDispatcher.forward(request, response);

    }
}
