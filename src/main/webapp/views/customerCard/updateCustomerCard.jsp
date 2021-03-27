<%@ page import="com.naukma.supermarket.model.CustomerCard" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update customer card</title>

</head>
<body>
<div>
    <h1>Оновити інформацію про клієнта</h1>
</div>

<div>
    <%
        CustomerCard customerCardToUpdate = (CustomerCard) request.getAttribute("customerCardToUpdate");
    %>
    <div>

        <form method="post">
            <table id="table">
                <tr>
                    <td>Прізвище:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"custSurname\" value=\"" + customerCardToUpdate.getCust_surname() + "\">");
                        %>
                    </td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"id\" value=\"" + customerCardToUpdate.getCard_number() + "\" hidden>");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Ім`я:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"custName\" value=\"" + customerCardToUpdate.getCust_name() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>По-батькові:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"custPatronymic\" value=\"" + customerCardToUpdate.getCust_patronymic() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Номер телефону:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"phoneNum\" value=\"" + customerCardToUpdate.getPhone_number() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Місто:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"city\" value=\"" + customerCardToUpdate.getCity() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Вулиця:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"street\" value=\"" + customerCardToUpdate.getStreet() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Індекс:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"zipCode\" value=\"" + customerCardToUpdate.getZip_code() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Відсоток знижки:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"percent\" value=\"" + customerCardToUpdate.getPercent() + "\">");
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

<input class="button" type=button onClick="location.href='/customerCards'"
       value='Всі картки клієнтів'>

</body>
</html>
