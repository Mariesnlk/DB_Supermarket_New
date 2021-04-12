<%@ page import="java.util.List" %>
<%@ page import="com.naukma.supermarket.model.CustomerCard" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All Customer Cards</title>
</head>
<body>

<style>
    body {
        background-image: url("/images/background.png");
        background-repeat: no-repeat;
        background-size: cover;
    }

    h1 {
        text-align: center;
        color: rgba(220, 0, 0, 1);;
    }

    .button {
        border: 0;
        line-height: 2.5;
        padding: 0 20px;
        font-size: 1rem;
        text-align: center;
        color: #fff;
        text-shadow: 1px 1px 1px #000;
        border-radius: 10px;
        background-color: rgba(220, 0, 0, 1);
        background-image: linear-gradient(to top left,
        rgba(0, 0, 0, .2),
        rgba(0, 0, 0, .2) 30%,
        rgba(0, 0, 0, 0));
        box-shadow: inset 2px 2px 3px rgba(255, 255, 255, .6),
        inset -2px -2px 3px rgba(0, 0, 0, .6);
    }
    #table {
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #table td, #table th {
        border: 1px solid #000000;
        padding: 8px;
        background-color: rgba(255, 255, 255, 0.7);
    }

    #table th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: rgba(220, 0, 0, 1);
        background-image: linear-gradient(to top left,
        rgba(0, 0, 0, .2),
        rgba(0, 0, 0, .2) 30%,
        rgba(0, 0, 0, 0));
        color: white;
    }

</style>
<br>

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
                <th>Прізвище</th>
                <th>Ім`я</th>
                <th>По-батькові</th>
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
                    out.println("<td>" + customerCard.getCust_surname() + "</td>");
                    out.println("<td>" + customerCard.getCust_name() + "</td>");
                    out.println("<td>" + customerCard.getCust_patronymic() + "</td>");
                    out.println("<td>" + customerCard.getPhone_number() + "</td>");
                    out.println("<td>" + customerCard.getCity() + "</td>");
                    out.println("<td>" + customerCard.getStreet() + "</td>");
                    out.println("<td>" + customerCard.getZip_code() + "</td>");

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
