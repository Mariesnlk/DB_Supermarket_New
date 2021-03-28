<%@ page import="com.naukma.supermarket.model.StoreProduct" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Store Products</title>
</head>
<body>

<div>
    <h1>Всі продукти в магазині</h1>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>
    <input class="button" type=button onClick="location.href='/add-storeProduct'" value='Додати товар в магазині'>
</div>
<br>
<br>
<div>
    <div>

        <%
            List<StoreProduct> storeProducts = (List<StoreProduct>) request.getAttribute("allStoreProducts");
            if (storeProducts != null && !storeProducts.isEmpty()) {
        %>

        <table cellspacing="2" border="1" cellpadding="5" width="600" id="table">
            <thead>
            <tr>
                <th>Код товару</th>
                <th>Код акційного товару</th>
                <th>ID продукту</th>
                <th>Ціна товару</th>
                <th>Кількість товару</th>
                <th>Чи товар акційний</th>
            </tr>
            </thead>
            <tbody>

            <%
                for (StoreProduct storeProduct : storeProducts) {
                    out.println("<tr>");
                    out.println("<td><a href=\"/check?upc=" + storeProduct.getUPC() + "\">"
                            + storeProduct.getUPC() + "</a></td>");
                    out.println("<td>" + storeProduct.getUPC_prom() + "</td>");
                    out.println("<td>" + storeProduct.getId_product() + "</td>");
                    out.println("<td>" + storeProduct.getSelling_price() + "</td>");
                    out.println("<td>" + storeProduct.getProducts_number() + "</td>");
                    out.println("<td>" + storeProduct.getPromotional_product() + "</td>");

                    out.println("<td><a href=\"/update-storeProduct?upc=" + storeProduct.getUPC()
                            + "\">Оновити</a></td>");
                    out.println("<td><a href=\"/delete-storeProduct?upc=" + storeProduct.getUPC()
                            + "\">Видалити</a></td>");
                    out.println("</tr>");
                }
            %>

            </tbody>
        </table>

        <%
            } else {
                out.println("<p>There are no store products yet!</p>");
            }
        %>

    </div>
</div>

<br>

<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>
    <input class="button" type=button onClick="location.href='/add-storeProduct'" value='Додати товар в магазині'>
</div>


</body>
</html>
