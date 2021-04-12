<%@ page import="com.naukma.supermarket.model.Check" %>
<%@ page import="java.util.List" %>
<%@ page import="com.naukma.supermarket.model.ProductSellingCheck" %>
<%@ page import="com.naukma.supermarket.model.CheckSaleEmployeeCard" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Print Check</title>
</head>
<body>

<%
    CheckSaleEmployeeCard checkInfo = (CheckSaleEmployeeCard) request.getAttribute("checkInfo");
%>
<div>
    <table cellspacing="2" border="0" cellpadding="5" width="300" class="table">
        <tr>
            <td class="info">Чек №:</td>
            <td class="value">
                <%
                    out.println(checkInfo.getCheck_number());
                %>
            </td>
        </tr>
        <tr>
            <td class="info">Касир:</td>
            <td class="value">
                <%
                    out.println(checkInfo.getEmpl_surname() + "  " + checkInfo.getEmpl_name() + "  " + checkInfo.getEmpl_patronymic());
                %>
            </td>
        </tr>
        <tr>
            <td class="info">Дата:</td>
            <td class="value">
                <%
                    out.println(checkInfo.getPrint_date());
                %>
            </td>
        </tr>
    </table>
</div>
<div>
    <%
        List<ProductSellingCheck> listProducts = (List<ProductSellingCheck>) request.getAttribute("listProducts");
        if (listProducts != null && !listProducts.isEmpty()) {
    %>
    <table cellspacing="2" border="0" cellpadding="5" width="600" class="table">
        <thead>
        <tr>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>

        <%
            for (ProductSellingCheck product : listProducts) {
                out.println("<tr>");
                out.println("<td>" + product.getProduct_name() + "</td>");
                out.println("<td>" + product.getSelling_price() + " грн </td>");
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

<div>
    <table cellspacing="2" border="0" cellpadding="5" width="300" class="table">
        <tr>
            <td class="info">Сума:</td>
            <td class="value">
                <%
                    out.println(checkInfo.getSelling_price() + " грн");
                %>
            </td>
        </tr>
        <tr>
            <td class="info">ПДВ:</td>
            <td class="value">
                <%
                    out.println(checkInfo.getVat() * checkInfo.getSelling_price() + " грн");
                %>
            </td>
        </tr>
        <tr>
            <td class="info">ПДВ:
                <%
                    out.println(checkInfo.getVat() * 100 + " %");
                %>
            </td>
        </tr>
    </table>
</div>



<br>

<input class="button" type=button onClick="location.href='/'" value='Друкувати'>
<input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>

</body>
</html>
