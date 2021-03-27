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
    <input class="button" type=button onClick="location.href='/add-product'" value='Додати Продукт'>
</div>
<br>
<br>
<div>
    <div>

        <%
            List<Product> products = (List<Product>) request.getAttribute("allProducts");
            if (products != null && !products.isEmpty()) {
        %>

        <table cellspacing="2" border="1" cellpadding="5" width="600" id="table">
            <thead>
            <tr>
                <th>ID продукту</th>
                <th>Номер Категорії</th>
                <th>Назва Продукту</th>
                <th>Характеристика</th>
            </tr>
            </thead>
            <tbody>

            <%
                for (Product product : products) {
                    out.println("<tr>");
                    out.println("<td><a href=\"/product?id=" + product.getId_product() + "\">"
                            + product.getId_product() + "</a></td>");

                    out.println("<td>" + product.getCategory_number() + "</td>");
                    out.println("<td>" + product.getProduct_name() + "</td>");
                    out.println("<td>" + product.getCharacteristics() + "</td>");

                    out.println("<td><a href=\"/update-product?id=" + product.getId_product()
                            + "\">Обновити</a></td>");
                    out.println("<td><a href=\"/delete-product?id=" + product.getId_product()
                            + "\">Видалити</a></td>");
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
    <input class="button" type=button onClick="location.href='/add-product'" value='Додати Продукт'>
</div>
</body>
</html>
