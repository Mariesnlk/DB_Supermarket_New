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

@WebServlet(name = "TotalSumChecksFromAllEmpServlet", urlPatterns = {"/sum-check-all-empl"})
public class TotalSumChecksFromAllEmpServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(TotalSumChecksFromAllEmpServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CheckService checkService = new CheckServiceImpl();

        String dateFrom = request.getParameter("checkNumber");
        String dateTo = request.getParameter("checkNumber");

        String checkNumber = request.getParameter("checkNumber");
        Check check = checkService.findById(checkNumber); //totalSumOfChecksAllEmployees()
        request.setAttribute("check", check);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/check/showCheckSum.jsp");
        LOGGER.info("doPost process");
        requestDispatcher.forward(request, response);

    }
}