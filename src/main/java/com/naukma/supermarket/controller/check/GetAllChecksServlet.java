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
import java.util.List;

@WebServlet(name = "GetAllChecksServlet", urlPatterns = {"/checks"})
public class GetAllChecksServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(GetAllChecksServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CheckService checkService = new CheckServiceImpl();

        List<Check> allChecks = checkService.findAll();
        request.setAttribute("allChecks", allChecks);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/check/allChecks.jsp");
        LOGGER.info("doGet process");
        requestDispatcher.forward(request, response);
    }
}
