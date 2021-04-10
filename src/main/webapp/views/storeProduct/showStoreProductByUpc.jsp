<%@ page import="com.naukma.supermarket.model.StoreProduct" %>
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
<div>
    <%
        StoreProduct storeProduct = (StoreProduct) request.getAttribute("storeProductByUpc");
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
        </table>
    </div>
</div>
<br>

<input class="button" type=button onClick="location.href='/index-manager'" value='Повернутися на сторінку менеджера'>

</body>
</html>
