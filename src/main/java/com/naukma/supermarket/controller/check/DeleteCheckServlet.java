package com.naukma.supermarket.controller.check;

import com.naukma.supermarket.model.Check;
import com.naukma.supermarket.service.impl.CheckServiceImpl;
import com.naukma.supermarket.service.interf.CheckService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCheckServlet", urlPatterns = {"/delete-check"})
public class DeleteCheckServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(DeleteCheckServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("doGet process");
        doDelete(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkNumber = request.getParameter("checkNumber");

        CheckService checkService = new CheckServiceImpl();
        Check checkToDelete = checkService.findById(checkNumber);
        checkService.delete(checkToDelete);

        response.sendRedirect("/checks");
    }
}
