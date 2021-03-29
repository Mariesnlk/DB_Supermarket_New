<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Store Product</title>
</head>
<body>

<div>
    <%--    <%--%>
    <%--        if (request.getAttribute("lastName") != null && request.getAttribute("firstName") != null) {--%>
    <%--            out.println("<p>Працівник '" + request.getAttribute("firstName") + "' '" + request.getAttribute("lastName") + "' зареєстрований!</p>");--%>
    <%--        }--%>
    <%--    %>--%>

    <h1>Додавання товару в магазині</h1>

    <div>
        <form action="/add-storeProduct" method="post">
            <label>Код товару: </label> <input type="text" name="upc" placeholder="Введіть код товару.."><br/>
            <label>Код акційного товару: </label> <input type="text" name="UPCProm" placeholder="Введіть код акційного товару.."><br/>
            <label>ID товару: </label> <input type="text" name="idProduct" placeholder="Введіть номер товару.."><br/>
            <label>Ціна товару: </label><input type="text" name="sellingPrice" placeholder="Введіть ціну товару.."><br/>
            <label>Кількість товару: </label><input type="text" name="productsNum" placeholder="Введіть кількість товару.."><br/>
            <label>Чи товар акційний: </label><input type="text" name="promotionalProduct" placeholder="Введіть чи товар є акційним.."><br/>
            <button class="button" type="submit">Підтвердити</button>
        </form>
    </div>
</div>

<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>

</body>
</html>
