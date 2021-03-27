<%@ page import="com.naukma.supermarket.model.CustomerCard" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show customer card</title>
</head>
<body>

<div>
    <h1>Інформація про клієнта</h1>
</div>
<br>
<div>
    <%
        CustomerCard customerCard = (CustomerCard) request.getAttribute("customerCard");
    %>
    <div>

        <table cellspacing="2" border="1" cellpadding="5" width="300" id="table">
            <tr>
                <td>Номер картки:</td>
                <td>
                    <%
                        out.println(customerCard.getCard_number());
                    %>
                </td>
            </tr>
            <tr>
                <td>Прізвище:</td>
                <td>
                    <%
                        out.println(customerCard.getCust_surname());
                    %>
                </td>
            </tr>
            <tr>
                <td>Ім`я:</td>
                <td>
                    <%
                        out.println(customerCard.getCust_name());
                    %>
                </td>
            </tr>
            <tr>
                <td>По-батькові:</td>
                <td>
                    <%
                        out.println(customerCard.getCust_patronymic());
                    %>
                </td>
            </tr>
            <tr>
                <td>Номер телефону:</td>
                <td>
                    <%
                        out.println(customerCard.getPhone_number());
                    %>
                </td>
            </tr>
            <tr>
                <td>Місто:</td>
                <td>
                    <%
                        out.println(customerCard.getCity());
                    %>
                </td>
            </tr>
            <tr>
                <td>Вулиця:</td>
                <td>
                    <%
                        out.println(customerCard.getStreet());
                    %>
                </td>
            </tr>
            <tr>
                <td>Індекс:</td>
                <td>
                    <%
                        out.println(customerCard.getZip_code());
                    %>
                </td>
            </tr>
            <tr>
                <td>Знижка:</td>
                <td>
                    <%
                        out.println(customerCard.getPercent());
                    %>
                </td>
            </tr>

        </table>
    </div>
</div>
<br>

<input class="button" type=button onClick="location.href='/customerCards'" value='Всі картки клієнтів'>

</body>
</html>
