<%@ page import="com.naukma.supermarket.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Product</title>
</head>
<body>

<div>
    <h1>Інформація про продукт</h1>
</div>
<br>
<div>
    <%
        Product product = (Product) request.getAttribute("product");
    %>
    <div>

        <table cellspacing="2" border="1" cellpadding="5" width="300" id="table">
            <tr>
                <td>ID продукту:</td>
                <td>
                    <%
                        out.println(product.getId_product());
                    %>
                </td>
            </tr>
            <tr>
                <td>Номер категорії:</td>
                <td>
                    <%
                        out.println(product.getCategory_number());
                    %>
                </td>
            </tr>
            <tr>
                <td>Назва продукту:</td>
                <td>
                    <%
                        out.println(product.getProduct_name());
                    %>
                </td>
            </tr>
            <tr>
                <td>Характеристика:</td>
                <td>
                    <%
                        out.println(product.getCharacteristics());
                    %>
                </td>
            </tr>
        </table>
    </div>
</div>
<br>

<input class="button" type=button onClick="location.href='/products'" value='Всі продукти'>

</body>
</html>
