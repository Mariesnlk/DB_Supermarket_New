<%@ page import="com.naukma.supermarket.model.Sale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Sale</title>
</head>
<body>

<div>
    <h1>Оновити інформацію про прожаж</h1>
</div>

<div>
    <%
        Sale saleToUpdate = (Sale) request.getAttribute("saleToUpdate");
    %>
    <div>

        <form method="post">
            <table id="table">
                <tr>
                    <td>Номер чеку:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"checkNumber\" value=\"" + saleToUpdate.getCheck_number() + "\" hidden>");
                        %>
                    </td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"upc\" value=\"" + saleToUpdate.getUPC() + "\" hidden>");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Номер продукту:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"productNum\" value=\"" + saleToUpdate.getProduct_number() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Ціна:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"sellingPrice\" value=\"" + saleToUpdate.getSelling_price() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td align="right" colspan="2"><input type="submit" value="Підтвердити"></td>
                </tr>
            </table>
        </form>
    </div>
</div>

<input class="button" type=button onClick="location.href='/sales'"
       value='Всі акції'>

</body>
</html>
