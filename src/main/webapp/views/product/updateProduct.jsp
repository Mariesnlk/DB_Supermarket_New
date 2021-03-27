<%@ page import="com.naukma.supermarket.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update product</title>

</head>
<body>
<div>
    <h1>Оновити інформацію про продукт</h1>
</div>

<div>
    <%
        Product productToUpdate = (Product) request.getAttribute("productToUpdate");
    %>
    <div>

        <form method="post">
            <table id="table">
<%--                <tr>--%>
<%--                    <td>ID продукту:</td>--%>
<%--                    <td>--%>
<%--                        <%--%>
<%--                            out.println("<input type=\"text\" name=\"id\" value=\"" + productToUpdate.getId_product() + "\" hidden>");--%>
<%--                        %>--%>
<%--                    </td>--%>
<%--                </tr>--%>
                <tr>
                    <td>Номер категорії:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"category_number\" value=\"" + productToUpdate.getCategory_number() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Назва продукту:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"product_name\" value=\"" + productToUpdate.getProduct_name() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Характеристика:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"characteristics\" value=\"" + productToUpdate.getCharacteristics() + "\">");
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

<input class="button" type=button onClick="location.href='/products'"
       value='Всі продукти'>

</body>
</html>
