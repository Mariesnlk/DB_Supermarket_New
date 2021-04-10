<%@ page import="com.naukma.supermarket.model.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show employee</title>
</head>
<body>

<div>
    <h1>Інформація про працівника </h1>
</div>
<br>
<div>
    <%
        Employee employee = (Employee) request.getAttribute("employeeSpecific");
    %>
    <div>

        <table cellspacing="2" border="1" cellpadding="5" width="300" id="table">
            <tr>
                <td>Прізвище:</td>
                <td>
                    <%
                        out.println(employee.getEmpl_surname());
                    %>
                </td>
            </tr>
            <tr>
                <td>Номер телефону:</td>
                <td>
                    <%
                        out.println(employee.getPhone_number());
                    %>
                </td>
            </tr>
            <tr>
                <td>Місто:</td>
                <td>
                    <%
                        out.println(employee.getCity());
                    %>
                </td>
            </tr>
            <tr>
                <td>Вулиця:</td>
                <td>
                    <%
                        out.println(employee.getStreet());
                    %>
                </td>
            </tr>
            <tr>
                <td>Індекс:</td>
                <td>
                    <%
                        out.println(employee.getZip_code());
                    %>
                </td>
            </tr>
        </table>
    </div>
</div>
<br>

<input class="button" type=button onClick="location.href='/index-manager'" value='Повернутися на сторінку менеджера'>

</body>
</html>
