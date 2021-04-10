package com.naukma.supermarket.controller.check;

import com.naukma.supermarket.model.Check;
import com.naukma.supermarket.service.impl.CheckServiceImpl;
import com.naukma.supermarket.service.interf.CheckService;
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

@WebServlet(name = "TotalSumOfChecksAllEmployeesServlet", urlPatterns = {"/checks-by-allEmployees-from-period"})
public class TotalSumOfChecksAllEmployeesServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(TotalSumOfChecksAllEmployeesServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CheckService checkService = new CheckServiceImpl();

        String availableFirstDate = request.getParameter("dateStart");
        String availableSecondDate = request.getParameter("dateFinish");
        java.util.Date d = null;
        java.util.Date d1 = null;
        try {
            d = new SimpleDateFormat("yyyy-MM-dd").parse(availableFirstDate);
            d1 = new SimpleDateFormat("yyyy-MM-dd").parse(availableSecondDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date dateStart = new java.sql.Date(d.getTime());
        java.sql.Date dateFinish = new java.sql.Date(d1.getTime());


        Check sumCheck = checkService.totalSumOfChecksAllEmployees(dateStart,dateFinish);
        request.setAttribute("sumCheck", sumCheck);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/check/showSumCheck.jsp");
        LOGGER.info("doPost process");
        requestDispatcher.forward(request, response);

    }
}
