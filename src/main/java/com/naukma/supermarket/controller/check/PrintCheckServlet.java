package com.naukma.supermarket.controller.check;

import com.naukma.supermarket.dao.impl.CheckSaleEmployeeCardDAOImpl;
import com.naukma.supermarket.dao.interf.CheckSaleEmployeeCardDAO;
import com.naukma.supermarket.model.CheckSaleEmployeeCard;
import com.naukma.supermarket.model.ProductSellingCheck;
import com.naukma.supermarket.service.impl.ProductSellingCheckServiceImpl;
import com.naukma.supermarket.service.interf.ProductSellingCheckService;
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
import java.util.List;

@WebServlet(name = "PrintCheckServlet", urlPatterns = {"/print-check"})
public class PrintCheckServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(PrintCheckServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String checkNumber = request.getParameter("checkNum");

        ProductSellingCheckService productSellingCheckDAO = new ProductSellingCheckServiceImpl();
        List<ProductSellingCheck> listProducts = productSellingCheckDAO.listProductsByCheck(checkNumber);
//        System.out.println("list of products in 1 check" + listProducts);

        request.setAttribute("listProducts", listProducts);

        CheckSaleEmployeeCardDAO checkSaleEmployeeCardDAO = new CheckSaleEmployeeCardDAOImpl();
        CheckSaleEmployeeCard checkInfo = checkSaleEmployeeCardDAO.checkInfo(checkNumber);
        request.setAttribute("checkInfo", checkInfo);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/check/printCheck.jsp");
        LOGGER.info("doPost process");
        requestDispatcher.forward(request, response);
    }
}
