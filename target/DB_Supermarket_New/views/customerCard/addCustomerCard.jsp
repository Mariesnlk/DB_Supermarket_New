<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Customer Card</title>
</head>
<body>

<div>
<%--    <%--%>
<%--        if (request.getAttribute("lastName") != null && request.getAttribute("firstName") != null) {--%>
<%--            out.println("<p>Картка клієнта '" + request.getAttribute("firstName") + "' '" + request.getAttribute("lastName") + "' зареєстрована!</p>");--%>
<%--        }--%>
<%--    %>--%>

    <h1>Додавання картки клієнта</h1>

    <div>
        <form action="/add-customerCard" method="post">
            <label>ID: </label> <input type="text" name="cardNum" placeholder="Введіть номер картки клієнта.."><br/>
            <label>Прізвище: </label> <input type="text" name="custSurname" placeholder="Введіть ваше прізвище.."><br/>
            <label>Ім`я: </label><input type="text" name="custName" placeholder="Введіть ваше ім`я.."><br/>
            <label>По-батькові: </label><input type="text" name="custPatronymic" placeholder="Введіть ваше по-батькові.."><br/>
            <label for="phoneNum">Номер телефону (формат: xxx-xxx-xx-xx): </label>
            <input id="phoneNum" name="phoneNum" type="tel" pattern="^\d{3}-\d{3}-\d{2}-\d{2}$" required><br/>
            <label>Місто: </label><input type="text" name="city" placeholder="Введіть місто.."><br/>
            <label>Вулиця: </label><input type="text" name="street" placeholder="Введіть вулицю.."><br/>
            <label>Індекс: </label><input type="text" name="zipCode" placeholder="Введіть індекс.."><br/>
            <label>Індекс: </label><input type="text" name="percent" placeholder="Введіть відсоток знижки.."><br/>
            <button class="button" type="submit">Підтвердити</button>
        </form>
    </div>
</div>

<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>

</body>
</html>
