<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Check</title>
</head>
<body>

<div>
    <%--    <%--%>
    <%--        if (request.getAttribute("lastName") != null && request.getAttribute("firstName") != null) {--%>
    <%--            out.println("<p>Працівник '" + request.getAttribute("firstName") + "' '" + request.getAttribute("lastName") + "' зареєстрований!</p>");--%>
    <%--        }--%>
    <%--    %>--%>

    <h1>Додавання чеку</h1>

    <div>
        <form action="/add-check" method="post">
            <%--  added regex --%>
            <label>Номер чеку: </label> <input type="text" name="checkNumber" placeholder="Введіть номер чеку.."><br/>
            <%--  added regex --%>
            <label>ID працівника: </label> <input type="text" name="idEmployee"><br/>
            <%--  added regex --%>
            <label>Номер картки клієнта: </label><input type="text" name="cardNumber"><br/>
            <%--  added regex --%>
            <label>Дата видачі чеку: </label><input type="date" name="printDate" value="2021-03-22"><br/>
            <%--  type = number --%>
            <label>Загальна сума: </label><input type="number" min="0" name="sumTotal" placeholder="Введіть загальну суму.."><br
            <%--  type = number --%>
            <label>ПДВ: </label><input type="text" name="vat" type="number" min="0"
                                       placeholder="Введіть значення ПДВ.."><br/>
            <button class="button" type="submit">Підтвердити</button>
        </form>
    </div>
</div>

<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>

</body>
</html>
