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

@WebServlet(name = "GetCheckInfoByCheckNumServlet", urlPatterns = {"/checkInfo"})
public class GetCheckInfoByCheckNumServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(GetCheckInfoByCheckNumServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CheckService checkService = new CheckServiceImpl();

        String checkNumber = request.getParameter("checkNumber");
        Check check = checkService.findById(checkNumber);
        request.setAttribute("check", check);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/check/showCheck.jsp");
        LOGGER.info("doPost process");
        requestDispatcher.forward(request, response);

    }
}
