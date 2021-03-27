<%@ page import="com.naukma.supermarket.model.Sale" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Sales</title>
</head>
<body>

<div>
    <h1>Всі акції</h1>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>
    <input class="button" type=button onClick="location.href='/add-sale'" value='Додати акцію'>
</div>
<br>
<br>
<div>
    <div>

        <%
            List<Sale> sales = (List<Sale>) request.getAttribute("allSales");
            if (sales != null && !sales.isEmpty()) {
        %>

        <table cellspacing="2" border="1" cellpadding="5" width="600" id="table">
            <thead>
            <tr>
                <th>Код товару</th>
                <th>Номер чеку</th>
                <th>Номер продукту</th>
                <th>Ціна</th>
            </tr>
            </thead>
            <tbody>

            <%
                for (Sale sale : sales) {
                    out.println("<tr>");
                    out.println("<td><a href=\"/check?upc=" + sale.getUPC() + "\">"
                            + sale.getUPC() + "</a></td>");
                    out.println("<td>" + sale.getCheck_number() + "</td>");
                    out.println("<td>" + sale.getProduct_number() + "</td>");
                    out.println("<td>" + sale.getSelling_price() + "</td>");

                    out.println("<td><a href=\"/update-sale?upc=" + sale.getUPC()
                            + "\">Оновити</a></td>");
                    out.println("<td><a href=\"/delete-sale?upc=" + sale.getUPC()
                            + "\">Видалити</a></td>");
                    out.println("</tr>");
                }
            %>

            </tbody>
        </table>

        <%
            } else {
                out.println("<p>There are no sales yet!</p>");
            }
        %>

    </div>
</div>

<br>

<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>

    <input class="button" type=button onClick="location.href='/add-sale'" value='Додати акцію'>
</div>


</body>
</html>
