package com.naukma.supermarket.controller.filters;

import com.naukma.supermarket.model.Employee;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/*"})
public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String userRole = null;

        Employee emp = (Employee) session.getAttribute("registeredEmployee");

        String[] urlAccessCashier = {"/", "/add-check", "/add-customerCard", "/login", "/indexCashier.jsp", "/employee/**"};

        String[] urlAccessManager = {"/", "/login", "/indexManager.jsp", "/add-employee", "/add-category",
                "/add-product", "/add-customerCard", "/add-check", "/add-sale", "/add-storeProduct", "/add-query", "/catServlet/**"};

        if (emp != null) {
            userRole = emp.getRole();
        }
        String currentUrl = httpRequest.getRequestURI();

        if (currentUrl.equals("/login")) {
            chain.doFilter(request, response);

        } else if (userRole == null) {
            httpResponse.sendRedirect("/login");

        } else if (userRole.equals("cashier") && !checkAccess(currentUrl, urlAccessCashier)) {
            httpResponse.sendRedirect("/login");

        } else if (userRole.equals("manager") && !checkAccess(currentUrl, urlAccessManager)) {
            httpResponse.sendRedirect("/login");

        } else {
            chain.doFilter(request, response);

        }

    }

    @Override
    public void destroy() {

    }

    boolean checkAccess(String url, String[] accessUrls) {
        for (String strUrl : accessUrls) {
            if (strUrl.equals(url)) {
                return true;
            }
        }
        return false;
    }

}
