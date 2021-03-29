<%@ page import="com.naukma.supermarket.model.StoreProduct" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Store Product</title>
</head>
<body>

<div>
    <h1>Оновити інформацію про товар</h1>
</div>

<div>
    <%
        StoreProduct storeProductToUpdate = (StoreProduct) request.getAttribute("storeProductToUpdate");
    %>
    <div>

        <form method="post">
            <table id="table">
                <tr>
                    <td>Код акційного товару:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"UPCProm\" value=\"" + storeProductToUpdate.getUPC_prom() + "\" hidden>");
                        %>
                    </td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"upc\" value=\"" + storeProductToUpdate.getUPC() + "\" hidden>");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>ID товару:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"idProduct\" value=\"" + storeProductToUpdate.getId_product() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Ціна товару:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"sellingPrice\" value=\"" + storeProductToUpdate.getSelling_price() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Кількість товару:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"productsNum\" value=\"" + storeProductToUpdate.getProducts_number() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Чи товар акційний:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"promotionalProduct\" value=\"" + storeProductToUpdate.getPromotional_product() + "\">");
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

<input class="button" type=button onClick="location.href='/storeProducts'"
       value='Всі товари в магазині'>

</body>
</html>
