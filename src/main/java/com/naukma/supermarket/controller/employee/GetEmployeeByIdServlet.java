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

@WebServlet(name = "GetEmployeeByIdServlet", urlPatterns = {"/employee"})
public class GetEmployeeByIdServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(GetEmployeeByIdServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeeService employeeService = new EmployeeServiceImpl();

        String idEmployee = request.getParameter("id");
        Employee employee = employeeService.findById(idEmployee);
        request.setAttribute("employee", employee);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/employee/showEmployee.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);

    }
}
