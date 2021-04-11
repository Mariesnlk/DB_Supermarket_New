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
            <label>Логін: </label> <input type="text" name="employeeLogin" placeholder="Введіть логін"/>
        </div>
        <div>
            <label>Пароль: </label> <input type="password" name="employeePassword" placeholder="Введіть пароль"/>
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
