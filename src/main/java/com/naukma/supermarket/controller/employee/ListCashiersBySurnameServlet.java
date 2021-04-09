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

//@WebServlet(name = "ListCashiersBySurnameServlet", urlPatterns = {"/employees"})
public class ListCashiersBySurnameServlet extends HttpServlet {

//    private final Logger LOGGER = Logger.getLogger(ListCashiersBySurnameServlet.class);
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        EmployeeService employeeService = new EmployeeServiceImpl();
//
//        List<Employee> employees = employeeService.listCashiersBySurname();
//        request.setAttribute("allProducts", employees);
//
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/employee/allEmployees.jsp");
//        LOGGER.info("doGet process");
//        requestDispatcher.forward(request, response);
//
//    }
}