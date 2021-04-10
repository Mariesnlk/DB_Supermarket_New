<%@ page import="java.util.List" %>
<%@ page import="com.naukma.supermarket.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All products</title>
</head>
<body>

<div>
    <h1>Всі продукти</h1>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>
    <input class="button" type=button onClick="location.href='/index-manager'" value='Повернутися на сторінку менеджера'>
</div>
<br>
<br>
<div>
    <div>

        <%
            List<Product> products = (List<Product>) request.getAttribute("allProductNames");
            if (products != null && !products.isEmpty()) {
        %>

        <table cellspacing="2" border="1" cellpadding="5" width="600" id="table">
            <thead>
            <tr>
                <th>Назва Продукту</th>
            </tr>
            </thead>
            <tbody>

            <%
                for (Product product : products) {
                    out.println("<tr>");
                    out.println("<td>" + product.getProduct_name() + "</td>");
                    out.println("</tr>");
                }
            %>

            </tbody>
        </table>

        <%
            } else {
                out.println("<p>There are no products yet!</p>");
            }
        %>
    </div>
</div>
<br>

<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>
    <input class="button" type=button onClick="location.href='/index-manager'" value='Повернутися на сторінрку менеджера'>
</div>
</body>
</html>
