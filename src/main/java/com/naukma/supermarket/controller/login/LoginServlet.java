package com.naukma.supermarket.controller.login;


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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(LoginServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/login/login.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String employeeSurname = request.getParameter("employeeSurname");
        String employeeName = request.getParameter("employeeName");

        EmployeeService employeeService = new EmployeeServiceImpl();
        Employee registeredEmployee = employeeService.getRegisteredEmployee(employeeSurname, employeeName);

        HttpSession session = request.getSession();
        session.setAttribute("registeredEmployee", registeredEmployee);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/login/loginResult.jsp");
        LOGGER.info("doPost process");
        requestDispatcher.forward(request, response);


    }

}
