<%@ page import="com.naukma.supermarket.model.CustomerCard" %>
<%@ page import="java.util.List" %>
<%@ page import="com.naukma.supermarket.model.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result of my query</title>
</head>
<body>

<div>

    <h1>Result of my query</h1>

    <div>
        <form action="/add-query" method="post">
            <label>Виберіть ID працівника: </label> <select name="idEmployee">
            <%
                List<Employee> employeeList = (List<Employee>) request.getAttribute("allEmployees");
                for (Employee employee : employeeList) {
            %>
            <option value=<%=employee.getId_employee()%>><%=employee.getEmpl_surname()%>
                &nbsp; <%=employee.getEmpl_name()%>
            </option>
            <%}%>
        </select>
            <br>
        </select>
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
