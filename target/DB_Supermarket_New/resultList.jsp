<%@ page import="com.naukma.supermarket.model.CustomerCard" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>

    <%
        List<CustomerCard> customerCards = (List<CustomerCard>) request.getAttribute("allCustomerWithCashierCheck");
        if (customerCards != null && !customerCards.isEmpty()) {
    %>

    <table cellspacing="2" border="1" cellpadding="5" width="600" id="table">
        <thead>
        <tr>
            <th>Номер картки</th>
            <th>Прізвище</th>
            <th>Ім`я</th>
            <th>По-батькові</th>
            <th>Номер телефону</th>
            <th>Місто</th>
            <th>Вулиця</th>
            <th>Індекс</th>
            <th>Відсоток знижки</th>
        </tr>
        </thead>
        <tbody>

        <%
            for (CustomerCard customerCard : customerCards) {
                out.println("<tr>");
                out.println("<td>" + customerCard.getCard_number() + "</td>");
                out.println("<td>" + customerCard.getCust_surname() + "</td>");
                out.println("<td>" + customerCard.getCust_name() + "</td>");
                out.println("<td>" + customerCard.getCust_patronymic() + "</td>");
                out.println("<td>" + customerCard.getPhone_number() + "</td>");
                out.println("<td>" + customerCard.getCity() + "</td>");
                out.println("<td>" + customerCard.getStreet() + "</td>");
                out.println("<td>" + customerCard.getZip_code() + "</td>");
                out.println("<td>" + customerCard.getPercent() + "</td>");

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


</body>
</html>
