<%@ page import="com.naukma.supermarket.model.Sale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quantity of sold products</title>
</head>
<body>

<div>
    <h1>Кількість проданого товару</h1>
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
        Sale sale = (Sale) request.getAttribute("sale");
    %>
    <div>
        <table cellspacing="2" border="1" cellpadding="5" width="300" id="table">
            <tr>
                <td>Кількість:</td>
                <td>
                    <%
                        out.println(sale.getProduct_number());
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

</body>
</html>
