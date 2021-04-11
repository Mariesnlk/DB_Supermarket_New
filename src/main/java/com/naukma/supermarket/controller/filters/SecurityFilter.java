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
                "/checkInfo", "/list-sorted-products-in-category", "/storeProductByUpc",
                "/list-customers-by-percent", "/show-customer-info-by-surname", "/list-check-period", "/sort-prom",
                "/sort-non-prom", "/images/**", "/css/**"
        };

        String[] urlAccessManager = {"/", "/login", "/index-manager", "/add-query",
                "/sorted-categories-name", "/sort-cashiers-by-surname", "/list-products-in-category", "/list-store-products",
                "/show-employee-info", "/storeProductByUpc", "/list-sorted-products-in-category",
                "/sort-non-prom-by-name", "/sort-prom-by-name", "/sort-non-prom-by-quantity", "/sort-prom-by-quantity",
                "/sum-check-one-empl", "/sum-check-all-empl", "/list-customers-by-percent", "/sort-products-name",
                "/checks-by-allEmployees-from-period", "/checks-by-employee-from-period", "/list-customer-card",
                "/list-all-checks-by-period", "/list-checks-by-cashier-and-period", "/count-sold-product-by-period",
                "/find-lot-info-by-upc", "/sort-prom", "/sort-non-prom",
                "/add-employee", "/delete-employee", "/employees", "/employee", "/update-employee",
                "/add-category", "/delete-category","/categories", "/category", "/update-category",
                "/add-check", "/delete-check", "/checks", "/check", "/update-check",
                "/add-customerCard", "/delete-customerCard", "/customerCards", "/customerCard", "/update-customerCard",
                "/add-product", "/delete-product", "/products", "/product", "/update-product",
                "/add-sale", "/delete-sale", "/sales", "/sale", "/update-sale",
                "/add-storeProduct", "/delete-storeProduct", "/storeProducts", "/storeProduct", "/update-storeProduct",
                "/images/**", "/css/**"

        };

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
