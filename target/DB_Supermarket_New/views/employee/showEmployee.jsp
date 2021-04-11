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
        Employee employee = (Employee) request.getAttribute("employee");
    %>
    <div>

        <table cellspacing="2" border="1" cellpadding="5" width="300" id="table">
            <tr>
                <td>ID:</td>
                <td>
                    <%
                        out.println(employee.getId_employee());
                    %>
                </td>
            </tr>
            <tr>
                <td>Прізвище:</td>
                <td>
                    <%
                        out.println(employee.getEmpl_surname());
                    %>
                </td>
            </tr>
            <tr>
                <td>Ім`я:</td>
                <td>
                    <%
                        out.println(employee.getEmpl_name());
                    %>
                </td>
            </tr>
            <tr>
                <td>По-батькові:</td>
                <td>
                    <%
                        out.println(employee.getEmpl_patronymic());
                    %>
                </td>
            </tr>
            <tr>
                <td>Роль:</td>
                <td>
                    <%
                        out.println(employee.getRole());
                    %>
                </td>
            </tr>
            <tr>
                <td>Зарплата:</td>
                <td>
                    <%
                        out.println(employee.getSalary());
                    %>
                </td>
            </tr>
            <tr>
                <td>Дата народження:</td>
                <td>
                    <%
                        out.println(employee.getDate_of_birth());
                    %>
                </td>
            </tr>
            <tr>
                <td>Дата початку роботи:</td>
                <td>
                    <%
                        out.println(employee.getDate_of_start());
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

<input class="button" type=button onClick="location.href='/employees'" value='Всі працівники'>
<input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>

</body>
</html>
