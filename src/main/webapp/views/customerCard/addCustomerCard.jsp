<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Customer Card</title>
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

<div>
    <%--    <%--%>
    <%--        if (request.getAttribute("lastName") != null && request.getAttribute("firstName") != null) {--%>
    <%--            out.println("<p>Картка клієнта '" + request.getAttribute("firstName") + "' '" + request.getAttribute("lastName") + "' зареєстрована!</p>");--%>
    <%--        }--%>
    <%--    %>--%>

    <h1>Додавання картки клієнта</h1>

    <div>
        <form action="/add-customerCard" method="post">
            <label>Номер картки: </label> <input type="text" name="cardNum" placeholder="Номер картки клієнта.."><br/>
            <label>Прізвище: </label> <input type="text" name="custSurname" placeholder="Введіть ваше прізвище.."><br/>
            <label>Ім`я: </label><input type="text" name="custName" placeholder="Введіть ваше ім`я.."><br/>
            <label>По-батькові: </label><input type="text" name="custPatronymic"
                                               placeholder="Введіть ваше по-батькові.."><br/>
            <br>
            <label for="phoneNum">Номер телефону (формат: xxx-xxx-xx-xx): </label>
            <input id="phoneNum" name="phoneNum" type="tel" pattern="^\d{3}-\d{3}-\d{2}-\d{2}$" required><br/>
            <br>
            <label>Місто: </label><input type="text" name="city" placeholder="Введіть місто.."><br/>
            <label>Вулиця: </label><input type="text" name="street" placeholder="Введіть вулицю.."><br/>
            <label>Індекс: </label><input type="text" name="zipCode" placeholder="Введіть індекс.."><br/>
            <br>
            <label>Відсоток знижки: </label><input type="number" min="0" name="percent"
                                                   placeholder="Введіть відсоток знижки.."><br/>
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
