<%@ page import="com.naukma.supermarket.model.StoreProduct" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Store Product</title>
</head>
<body>

<div>
    <h1>Інформація про товар в магазині</h1>
</div>
<br>
<div>
    <%
        StoreProduct storeProduct = (StoreProduct) request.getAttribute("storeProduct");
    %>
    <div>
        <table cellspacing="2" border="1" cellpadding="5" width="300" id="table">
            <tr>
                <td>Код товару:</td>
                <td>
                    <%
                        out.println(storeProduct.getUPC());
                    %>
                </td>
            </tr>
            <tr>
                <td>Код акційного товару:</td>
                <td>
                    <%
                        out.println(storeProduct.getUPC_prom());
                    %>
                </td>
            </tr>
            <tr>
                <td>ID товару:</td>
                <td>
                    <%
                        out.println(storeProduct.getId_product());
                    %>
                </td>
            </tr>
            <tr>
                <td>Ціна товару:</td>
                <td>
                    <%
                        out.println(storeProduct.getSelling_price());
                    %>
                </td>
            </tr>
            <tr>
                <td>Кількість товару:</td>
                <td>
                    <%
                        out.println(storeProduct.getProducts_number());
                    %>
                </td>
            </tr>
            <tr>
                <td>Чи товар акційний:</td>
                <td>
                    <%
                        out.println(storeProduct.getPromotional_product());
                    %>
                </td>
            </tr>
        </table>
    </div>
</div>
<br>

<input class="button" type=button onClick="location.href='/storeProducts'" value='Всі товари в магазині'>

</body>
</html>
