package com.naukma.supermarket.controller.filters;

import com.naukma.supermarket.model.Employee;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
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

        String[] urlAccessCashier = {"/", "/login", "/indexCashier.jsp", "/index-cashier", "/add-check",
                "/add-customerCard", "/employee/**", "/sort-products-name", "/list-products-in-check",
                "/sort-non-prom-by-name", "/sort-prom-by-name", "/sort-non-prom-by-quantity", "/sort-prom-by-quantity",
                "/checkInfo"
        };

        String[] urlAccessManager = {"/", "/login", "/index-manager", "/indexManager.jsp", "/add-employee", "/add-category",
                "/add-product", "/add-customerCard", "/add-check", "/add-sale", "/add-storeProduct", "/add-query",
                "/sorted-categories-name", "/sort-cashiers-by-surname", "/list-products-in-category", "/list-store-products",
                "/show-employee-info", "/storeProductByUpc", "/list-sorted-products-in-category",
                "/sort-non-prom-by-name", "/sort-prom-by-name", "/sort-non-prom-by-quantity", "/sort-prom-by-quantity"};

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

      /*   /employee/**
         /employee/111
        */

        for (String strUrl : accessUrls) {
            if (strUrl.equals(url)) {
                return true;
            }

            if (strUrl.contains("**")) {
                String[] pathUserElems = url.split("/");
                String[] parthsElems = strUrl.split("/");
                String strWithout = "";
                String strUserWithout = "";
                int count = 0;
                for (String elem : parthsElems) {
                    if (!elem.equalsIgnoreCase("**")) {
                        strWithout += elem;
                        strUserWithout += pathUserElems[count];
                    }
                    count++;

                }
                if (strWithout.equalsIgnoreCase(strUserWithout)) {
                    return true;
                }
            }
        }

        return false;
    }

}
