<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>

<div>
    <%
        if (request.getAttribute("lastName") != null && request.getAttribute("firstName") != null) {
            out.println("<p>Працівник '" + request.getAttribute("firstName") + "' '" + request.getAttribute("lastName") + "' зареєстрований!</p>");
        }
    %>

    <h1>Реєстрація працівника</h1>

    <div>
        <form action="/add-employee" method="post">
            <%--  added regex --%>
            <label>ID: </label> <input type="text" name="id" placeholder="Введіть ID працівника.."><br/>
            <%--  added regex --%>
            <label>Прізвище: </label> <input type="text" name="lastName" placeholder="Введіть ваше прізвище.."><br/>
            <%--  added regex --%>
            <label>Ім`я: </label><input type="text" name="firstName" placeholder="Введіть ваше ім`я.."><br/>
            <%--  added regex --%>
            <label>По-батькові: </label><input type="text" name="patronymicName" placeholder="по-батькові.."><br/>
            <label>Роль: </label>
            <select name="role">
                <option value="manager">менеджер</option>
                <option value="cashier">касир</option>
            </select><br/>
            <label>Зарплата: </label><input type="text" type="number" min="0" placeholder="Введіть зарплату.."><br/>
            <label>Дата народження: </label><input type="date" name="birthDate"
                                                   value="2021-03-22"
                                                   max="2003-01-01"><br/>
            <label>Дата початку роботи: </label><input type="date" name="startDate" value="2021-03-22"><br/>
            <label for="phoneNum">Номер телефону (формат: +xxx-xxx-xx-xx): </label>
            <%--  should start with + and consists not more than 13 symbols --%>
            <input id="phoneNum" name="phoneNum" type="tel" pattern="^\d{3}-\d{3}-\d{2}-\d{2}$" required><br/>
            <%--  added regex --%>
            <label>Місто: </label><input type="text" name="city" placeholder="Введіть місто.."><br/>
            <%--  added regex --%>
            <label>Вулиця: </label><input type="text" name="street" placeholder="Введіть вулицю.."><br/>
            <%--  added regex --%>
            <label>Індекс: </label><input type="text" name="zipCode" placeholder="Введіть індекс.."><br/>
            <button class="button" type="submit">Підтвердити</button>
        </form>
    </div>
</div>

<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>

</body>
</html>
