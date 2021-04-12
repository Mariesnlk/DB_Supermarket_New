<%@ page import="com.naukma.supermarket.model.StoreProduct" %>
<%@ page import="java.util.List" %>
<%@ page import="com.naukma.supermarket.model.Check" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Sale</title>
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

    input[type=text], input[type=number], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=password], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    div {
        border-radius: 5px;
        background-color: rgba(255, 255, 255, 0.5);
        padding: 20px;
    }

    .button {
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

</style>
<br>

<%
    if (request.getAttribute("sellingPrice") != null) {
        out.println("<p>Ціна становить '" + request.getAttribute("sellingPrice") + "'</p>");
    }
%>

<div>

    <h1>Додавання продаж товару</h1>

    <div>
        <form action="/add-sale" method="post">

            <label>Код товару (UPC): </label> <select name="upc">
            <%
                List<StoreProduct> storeProductList = (List<StoreProduct>) request.getAttribute("allStoreProducts");
                for (StoreProduct storeProduct : storeProductList) {
            %>
            <option value=<%=storeProduct.getUPC()%>><%=storeProduct.getUPC()%>
            </option>
            //такое себе знать что за UPC
            <%}%>
        </select>
            <br>

            <label>Номер чеку: </label> <select name="checkNumber">
            <%
                List<Check> checkList = (List<Check>) request.getAttribute("allChecks");
                for (Check che : checkList) {
            %>
            <option value=<%=che.getCheck_number()%>><%=che.getCheck_number()%>
            </option>
            <%}%>
        </select>
            <br/>

            <label>Кількість продукту: </label><input type="text" name="productNum"
                                                      placeholder="Введіть номер товару.."><br/>
            <br>
            <label>Ціна: </label><input type="number" min="0" name="sellingPrice"
                                        placeholder="Введіть ціну акційного товару.."><br/>
            <br>
            <button class="button" type="submit">Підтвердити</button>
        </form>
    </div>
</div>

<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>

</body>
</html>
