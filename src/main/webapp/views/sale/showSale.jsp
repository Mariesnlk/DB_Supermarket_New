<%@ page import="com.naukma.supermarket.model.Sale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Sale</title>
</head>
<body>


<div>
    <h1>Інформація про продаж</h1>
</div>
<br>
<div>
    <%
        Sale sale = (Sale) request.getAttribute("sale");
    %>
    <div>
        <table cellspacing="2" border="1" cellpadding="5" width="300" id="table">
            <tr>
                <td>Код товару:</td>
                <td>
                    <%
                        out.println(sale.getUPC());
                    %>
                </td>
            </tr>
            <tr>
                <td>Номер чеку:</td>
                <td>
                    <%
                        out.println(sale.getCheck_number());
                    %>
                </td>
            </tr>
            <tr>
                <td>Номер продукту:</td>
                <td>
                    <%
                        out.println(sale.getProduct_number());
                    %>
                </td>
            </tr>
            <tr>
                <td>Ціна:</td>
                <td>
                    <%
                        out.println(sale.getSelling_price());
                    %>
                </td>
            </tr>
        </table>
    </div>
</div>
<br>

<input class="button" type=button onClick="location.href='/sales'" value='Всі акції'>

</body>
</html>
