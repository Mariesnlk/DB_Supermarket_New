<%@ page import="java.util.List" %>
<%@ page import="com.naukma.supermarket.model.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All Employees</title>
</head>
<body>

<div>
    <h1>Всі працівники</h1>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>

    <input class="button" type=button onClick="location.href='/add-employee'" value='Додати Працівника'>
</div>
<br>
<br>
<div>
    <div>

        <%
            List<Employee> employees = (List<Employee>) request.getAttribute("allEmployees");
            if (employees != null && !employees.isEmpty()) {
        %>

        <table cellspacing="2" border="1" cellpadding="5" width="600" id="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Прізвище</th>
                <th>Ім'я</th>
                <th>По-батькові</th>
                <th>Роль</th>
                <th>Зарплата</th>
                <th>Дата народження</th>
                <th>Дата початку роботи</th>
                <th>Номер телефону</th>
                <th>Місто</th>
                <th>Вулиця</th>
                <th>Індекс</th>
                <th>Логін</th>
                <th>Пароль</th>
            </tr>
            </thead>
            <tbody>

            <%
                for (Employee employee : employees) {
                    out.println("<tr>");
                    out.println("<td><a href=\"/employee?id=" + employee.getId_employee() + "\">"
                            + employee.getId_employee() + "</a></td>");
                    out.println("<td>" + employee.getEmpl_surname() + "</td>");
                    out.println("<td>" + employee.getEmpl_name() + "</td>");
                    out.println("<td>" + employee.getEmpl_patronymic() + "</td>");
                    out.println("<td>" + employee.getRole() + "</td>");
                    out.println("<td>" + employee.getSalary() + "</td>");
                    out.println("<td>" + employee.getDate_of_birth() + "</td>");
                    out.println("<td>" + employee.getDate_of_start() + "</td>");
                    out.println("<td>" + employee.getPhone_number() + "</td>");
                    out.println("<td>" + employee.getCity() + "</td>");
                    out.println("<td>" + employee.getStreet() + "</td>");
                    out.println("<td>" + employee.getZip_code() + "</td>");
                    out.println("<td>" + employee.getLogin() + "</td>");
                    out.println("<td>" + employee.getPassword() + "</td>");

                    out.println("<td><a href=\"/update-employee?id=" + employee.getId_employee()
                            + "\">Оновити</a></td>");
                    out.println("<td><a href=\"/delete-employee?id=" + employee.getId_employee()
                            + "\">Видалити</a></td>");
                    out.println("</tr>");
                }
            %>

            </tbody>
        </table>

        <%
            } else {
                out.println("<p>There are no employees yet!</p>");
            }
        %>

    </div>
</div>

<br>

<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>

    <input class="button" type=button onClick="location.href='/add-employee'" value='Додати Працівника'>
</div>

</body>
</html>
