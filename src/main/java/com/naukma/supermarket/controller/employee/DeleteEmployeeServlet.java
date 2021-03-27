package com.naukma.supermarket.controller.employee;

import com.naukma.supermarket.model.Employee;
import com.naukma.supermarket.service.impl.EmployeeServiceImpl;
import com.naukma.supermarket.service.interf.EmployeeService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteEmployeeServlet", urlPatterns = {"/delete-employee"})
public class DeleteEmployeeServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(DeleteEmployeeServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("doGet process");
        doDelete(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idEmployee = request.getParameter("id");

        EmployeeService employeeService = new EmployeeServiceImpl();
        Employee employeeToDelete = employeeService.findById(idEmployee);
        employeeService.delete(employeeToDelete);

        response.sendRedirect("/employees");
    }
}
