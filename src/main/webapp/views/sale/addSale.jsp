<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Sale</title>
</head>
<body>

<div>
    <%--    <%--%>
    <%--        if (request.getAttribute("lastName") != null && request.getAttribute("firstName") != null) {--%>
    <%--            out.println("<p>Працівник '" + request.getAttribute("firstName") + "' '" + request.getAttribute("lastName") + "' зареєстрований!</p>");--%>
    <%--        }--%>
    <%--    %>--%>

    <h1>Додавання акції</h1>

    <div>
        <form action="/add-sale" method="post">
            <label>Код товару: </label> <input type="text" name="upc" placeholder="Введіть код товару.."><br/>
            <label>Номер чеку: </label> <input type="text" name="checkNumber" placeholder="Введіть номер чеку.."><br/>
            <label>Номер продукту: </label><input type="text" name="productNum" placeholder="Введіть номер товару.."><br/>
            <label>Ціна: </label><input type="text" name="sellingPrice" placeholder="Введіть ціну акційного товару.."><br/>
            <button class="button" type="submit">Підтвердити</button>
        </form>
    </div>
</div>

<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>

</body>
</html>
