<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<h1>Please Login</h1>

<div class="container">
    <form action="/login" method="POST">
        <div>
            <label>Прізвище: </label> <input type="text" name="employeeSurname" placeholder="Введіть ваше прізвище"/>
        </div>
        <div>
            <label>І`мя: </label> <input type="text" name="employeeName" placeholder="Введіть ваше ім`я"/>
        </div>
        <br>
        <div>
            <button class="button" type="submit">Підтвердити</button>
        </div>
    </form>
</div>

<div>
    <input class="button" type=button onClick="location.href='../..'" value='Повернутися на головну'>
</div>

</body>
</html>
