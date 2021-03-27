<%@ page import="java.util.List" %>
<%@ page import="com.naukma.supermarket.model.CustomerCard" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All Customer Cards</title>
</head>
<body>

<div>
    <h1>Всі картки клієнтів</h1>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>
    <input class="button" type=button onClick="location.href='/add-customerCard'" value='Додати Картку Клієнта'>
</div>
<br>
<br>
<div>
    <div>

        <%
            List<CustomerCard> customerCards = (List<CustomerCard>) request.getAttribute("allCustomerCards");
            if (customerCards != null && !customerCards.isEmpty()) {
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
            </tr>
            </thead>
            <tbody>

            <%
                for (CustomerCard customerCard : customerCards) {
                    out.println("<tr>");
                    out.println("<td><a href=\"/customerCard?cardNum=" + customerCard.getCard_number() + "\">"
                            + customerCard.getCard_number() + "</a></td>");
                    out.println("<td>" + customerCard.getCust_surname() + "</td>");
                    out.println("<td>" + customerCard.getCust_name() + "</td>");
                    out.println("<td>" + customerCard.getCust_patronymic() + "</td>");
                    out.println("<td>" + customerCard.getPhone_number() + "</td>");
                    out.println("<td>" + customerCard.getCity() + "</td>");
                    out.println("<td>" + customerCard.getStreet() + "</td>");
                    out.println("<td>" + customerCard.getZip_code() + "</td>");
                    out.println("<td>" + customerCard.getPercent() + "</td>");

                    out.println("<td><a href=\"/update-customerCard?cardNum=" + customerCard.getCard_number()
                            + "\">Оновити</a></td>");
                    out.println("<td><a href=\"/delete-customerCard?cardNum=" + customerCard.getCard_number()
                            + "\">Видалити</a></td>");
                    out.println("</tr>");
                }
            %>

            </tbody>
        </table>

        <%
            } else {
                out.println("<p>There are no customer cards yet!</p>");
            }
        %>

    </div>
</div>

<br>

<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>
    <input class="button" type=button onClick="location.href='/add-customerCard'" value='Додати Картку Клієнта'>
</div>

</body>
</html>
