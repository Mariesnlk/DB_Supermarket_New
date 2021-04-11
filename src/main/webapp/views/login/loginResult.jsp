<%@ page import="com.naukma.supermarket.model.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Result </title>
</head>
<body>

<div>

    <%
        Employee registeredEmployee = (Employee) session.getAttribute("registeredEmployee");

        if (registeredEmployee != null) {
            out.println("<h1>Ви успіщно залогінились!</h1>");

    %>

    <div>
        <input class="button" type=button onClick="location.href='/logout'" value='Logout'>
    </div>
    <div>
        <input class="button" type=button onClick="location.href='../..'" value='Back to main page'>
    </div>
    <%
    } else {
        out.println("<h1>Помилка! Спробуйте ще раз!</h1>");

    %>
    <div>
        <input class="button" type=button onClick="location.href='/login'" value='Залогінитись'>
    </div>
    <div>
        <input class="button" type=button onClick="location.href='../..'" value='Повернутися на головну'>
    </div>
    <%
        }
    %>
</div>

</body>
</html>