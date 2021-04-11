<%@ page import="com.naukma.supermarket.model.StoreProduct" %>
<%@ page import="com.naukma.supermarket.model.StoreProductAndProduct" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Store Product By UPC</title>
</head>
<body>

<div>
    <h1>Інформація про товар в магазині</h1>
</div>
<br>
<br>
<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>

    <input class="button" type=button onClick="location.href='/index-manager'" value='Повернутися на сторінку менеджера'>
</div>
<br>
<br>
<div>
    <%
        StoreProductAndProduct storeProduct = (StoreProductAndProduct) request.getAttribute("storeProductByUpcExtended");
    %>
    <div>
        <table cellspacing="2" border="1" cellpadding="5" width="300" id="table">
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
                <td>Назва товару:</td>
                <td>
                    <%
                        out.println(storeProduct.getProduct_name());
                    %>
                </td>
            </tr>
            <tr>
                <td>Характеристика:</td>
                <td>
                    <%
                        out.println(storeProduct.getCharacteristics());
                    %>
                </td>
            </tr>
        </table>
    </div>
</div>
<br>
<br>
<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>

    <input class="button" type=button onClick="location.href='/index-manager'" value='Повернутися на сторінку менеджера'>
</div>
<br>
<br>
</body>
</html>
