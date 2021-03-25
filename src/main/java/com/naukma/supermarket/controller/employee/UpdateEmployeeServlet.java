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

@WebServlet(name = "UpdateEmployeeServlet", urlPatterns = {"/update-employee"})
public class UpdateEmployeeServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(UpdateEmployeeServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeeService employeeService = new EmployeeServiceImpl();

        String idEmployee = request.getParameter("id_employee");
        Employee employee = employeeService.findById(idEmployee);
        request.setAttribute("employeeToUpdate", employee);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/employee/updateEmployee.jsp");
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
        Date birthDate = Date.valueOf(request.getParameter("birthDate"));
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        String phoneNum = request.getParameter("phoneNum");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String zipCode = request.getParameter("zipCode");

        Employee updateEmployee = new Employee(id, lastName, firstName, patronymicName, role, salary, birthDate, startDate,
                phoneNum, city, street, zipCode);

        EmployeeService employeeService = new EmployeeServiceImpl();

        employeeService.update(updateEmployee);

        response.sendRedirect("/employees");

    }
}
