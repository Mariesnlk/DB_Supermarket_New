<%@ page import="com.naukma.supermarket.model.StoreProduct" %>
<%@ page import="java.util.List" %>
<%@ page import="com.naukma.supermarket.model.Check" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Sale</title>
</head>
<body>

<div>

    <h1>Продаж</h1>

    <div>
        <form action="/add-sale" method="post">

            <label>Код товару (UPC): </label> <select name="upc">
            <%
                List<StoreProduct> storeProductList = (List<StoreProduct>) request.getAttribute("allStoreProducts");
                for (StoreProduct storeProduct : storeProductList) {
            %>
            <option value=<%=storeProduct.getUPC()%>><%=storeProduct.getUPC()%></option> //такое себе знать что за UPC
            <%}%>
        </select>
            <br>

            <label>Номер чеку:  </label> <select name="checkNumber">
            <%
                List<Check> checkList = (List<Check>) request.getAttribute("allChecks");
                for (Check che : checkList) {
            %>
            <option value=<%=che.getCheck_number()%>><%=che.getCheck_number()%></option>
            <%}%>
        </select>
            <br/>

            <label>Номер продукту: </label><input type="text" name="productNum"
                                                  placeholder="Введіть номер товару.."><br/>
            <label>Ціна: </label><input type="number" min="0" name="sellingPrice"
                                        placeholder="Введіть ціну акційного товару.."><br/>
            <button class="button" type="submit">Підтвердити</button>
        </form>
    </div>
</div>

<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>

</body>
</html>
