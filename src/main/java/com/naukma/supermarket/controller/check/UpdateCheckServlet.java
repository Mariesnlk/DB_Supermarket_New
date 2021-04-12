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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "UpdateCheckServlet", urlPatterns = {"/update-check"})
public class UpdateCheckServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(UpdateCheckServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CheckService saleService = new CheckServiceImpl();

        String checkNumber = request.getParameter("checkNumber");
        Check check = saleService.findById(checkNumber);
        request.setAttribute("checkToUpdate", check);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/check/updateCheck.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String checkNumber = request.getParameter("checkNumber");
        String idEmployee = request.getParameter("idEmployee");
        String cardNumber = request.getParameter("cardNumber");
        Date printDate = Date.valueOf(request.getParameter("printDate"));
        //Double sumTotal = Double.parseDouble(request.getParameter("sumTotal"));
        //Double vat = Double.parseDouble(request.getParameter("vat"));

        Double sumTotal = Double.valueOf(0);
        Double vat = Double.valueOf(0);

        Check updateCheck = new Check(checkNumber, idEmployee, cardNumber, printDate, sumTotal, vat);

        CheckService checkService = new CheckServiceImpl();

        checkService.update(updateCheck);

        response.sendRedirect("/checks");
    }
}
