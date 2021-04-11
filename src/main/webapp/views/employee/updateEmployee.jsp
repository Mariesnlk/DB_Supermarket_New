<%@ page import="com.naukma.supermarket.model.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update employee</title>

</head>
<body>

<div>
    <h1>Оновити інформацію про працівника</h1>
</div>

<div>
    <%
        Employee employeeToUpdate = (Employee) request.getAttribute("employeeToUpdate");
    %>
    <div>

        <form method="post">
            <table id="table">
                <tr>
                    <td>Прізвище:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"lastName\" value=\"" + employeeToUpdate.getEmpl_surname() + "\">");
                        %>
                    </td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"id\" value=\"" + employeeToUpdate.getId_employee() + "\" hidden>");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Ім`я:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"firstName\" value=\"" + employeeToUpdate.getEmpl_name() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>По-батькові:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"patronymicName\" value=\"" + employeeToUpdate.getEmpl_patronymic() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Роль:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"role\" value=\"" + employeeToUpdate.getRole() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Зарплата:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"salary\" value=\"" + employeeToUpdate.getSalary() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Дата народження:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"birthDate\" value=\"" + employeeToUpdate.getDate_of_birth() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Дата початку роботи:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"startDate\" value=\"" + employeeToUpdate.getDate_of_start() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Номер телефону:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"phoneNum\" value=\"" + employeeToUpdate.getPhone_number() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Місто:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"city\" value=\"" + employeeToUpdate.getCity() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Вулиця:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"street\" value=\"" + employeeToUpdate.getStreet() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Індекс:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"zipCode\" value=\"" + employeeToUpdate.getZip_code() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Логін:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"login\" value=\"" + employeeToUpdate.getLogin() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Пароль:</td>
                    <td>
                        <%
                            out.println("<input type=\"password\" name=\"password\" value=\"" + employeeToUpdate.getPassword() + "\">");
                        %>
                    </td>
                </tr>

                <tr>
                    <td align="right" colspan="2"><input type="submit" value="Підтвердити"></td>
                </tr>
            </table>
        </form>
    </div>
</div>

<input class="button" type=button onClick="location.href='/employees'"
       value='Всі працівники'>

</body>
</html>
