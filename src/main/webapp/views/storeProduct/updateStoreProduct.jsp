<%@ page import="com.naukma.supermarket.model.StoreProduct" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Store Product</title>
</head>
<body>

<style>
    body {
        background-image: url("/images/background.png");
        background-repeat: no-repeat;
        background-size: cover;
    }

    h1 {
        text-align: center;
        color: rgba(220, 0, 0, 1);;
    }

    input[type=text], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    .main-div {
        border-radius: 5px;
        background-color: rgba(255, 255, 255, 0.6);
        padding: 20px;
        margin-bottom: 10px;
    }

    input[type=submit], .button {
        border: 0;
        line-height: 2.5;
        padding: 0 20px;
        font-size: 1rem;
        text-align: center;
        color: #fff;
        text-shadow: 1px 1px 1px #000;
        border-radius: 10px;
        background-color: rgba(220, 0, 0, 1);
        background-image: linear-gradient(to top left,
        rgba(0, 0, 0, .2),
        rgba(0, 0, 0, .2) 30%,
        rgba(0, 0, 0, 0));
        box-shadow: inset 2px 2px 3px rgba(255, 255, 255, .6),
        inset -2px -2px 3px rgba(0, 0, 0, .6);
    }

    form {
        text-align: left;
    }

    #container-button {
        text-align: center;
        margin-top: 10px;
    }

</style>
<br>

<div>
    <h1>Оновити інформацію про товар</h1>
</div>

<div class="main-div">
    <%
        StoreProduct storeProductToUpdate = (StoreProduct) request.getAttribute("storeProductToUpdate");
    %>
    <div>

        <form method="post">
            <table id="table">
<%--                <tr>--%>
<%--                    <td>Код товару:</td>--%>
<%--                    <td>--%>
<%--                        <%--%>
<%--                            out.println("<input type=\"text\" name=\"upc\" value=\"" + storeProductToUpdate.getUPC() + "\" hidden>");--%>
<%--                        %>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td>Код акційного товару:</td>--%>
<%--                    <td>--%>
<%--                        <%--%>
<%--                            out.println("<input type=\"text\" name=\"UPCProm\" value=\"" + storeProductToUpdate.getUPC_prom() + "\" hidden>");--%>
<%--                        %>--%>
<%--                    </td>--%>
<%--                </tr>--%>
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
