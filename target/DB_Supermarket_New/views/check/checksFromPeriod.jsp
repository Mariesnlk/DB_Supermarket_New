<%@ page import="com.naukma.supermarket.model.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Checks from period</title>
</head>
<body>

<%
    Employee registeredEmployee = (Employee) session.getAttribute("registeredEmployee");
    String idEmployee = registeredEmployee.getId_employee();

%>

<div>

    <h1>Список чеків, видрукуваних даним касиром за певний період часу</h1>

    <div>
        <form action="/list-check-period" method="post">
            <label>Касир: </label></label><%out.println(idEmployee);%><br/>
            <label>Початкова дата: </label><input type="date" name="dateFrom" value="2021-03-22"><br/>
            <label>Кінцева дата: </label><input type="date" name="dateTo" value="2021-03-22"><br/>

            <button class="button" type="submit">Підтвердити</button>
        </form>
    </div>

</div>

</body>
</html>
