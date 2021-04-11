<%@ page import="com.naukma.supermarket.model.ProductSellingCheck" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All checks by cashiers</title>
</head>
<body>

<div>
    <h1>Чеки</h1>
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
            List<ProductSellingCheck> checks = (List<ProductSellingCheck>) request.getAttribute("productSellingCheckList");
            if (checks != null && !checks.isEmpty()) {
        %>

        <table cellspacing="2" border="1" cellpadding="5" width="600" id="table">
            <thead>
            <tr>
                <th>Назва продукту</th>
                <th>Кількість продукту</th>
                <th>Ціна продажу</th>
                <th>Номер чеку</th>
                <th>ID касира</th>
            </tr>
            </thead>
            <tbody>

            <%
                for (ProductSellingCheck check : checks) {
                    out.println("<tr>");
                    out.println("<td>" + check.getProduct_name() + "</td>");
                    out.println("<td>" + check.getProduct_number() + "</td>");
                    out.println("<td>" + check.getSelling_price() + "</td>");
                    out.println("<td>" + check.getCheck_number() + "</td>");
                    out.println("<td>" + check.getId_employee() + "</td>");//null

                }
            %>

            </tbody>
        </table>

        <%
            } else {
                out.println("<p>There are no results yet!</p>");
            }
        %>

    </div>
</div>

<br>

<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>

    <input class="button" type=button onClick="location.href='/index-manager'" value='Повернутися на сторінку менеджера'>
</div>


</body>
</html>
