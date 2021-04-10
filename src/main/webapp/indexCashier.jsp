<%@ page import="com.naukma.supermarket.model.Employee" %>
<%@ page import="com.naukma.supermarket.model.Check" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cashier`s page</title>


    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>

</head>
<body>

<h1>Сторінка касира</h1>

<div>
    <input class="button" type=button onClick="location.href='/logout'" value='Вийти'>
</div>

<br>

<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>

<br>

<h1>Запити касира</h1>


<%
    Employee registeredEmployee = (Employee) session.getAttribute("registeredEmployee");
    String idEmployee = registeredEmployee.getId_employee();

%>

<div>

    <form action="/list-products-in-check" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td>+За номером чека скласти список усіх товарів, інформація про продаж яких є у цьому чеку</td>

            <td><label>Номер чека: </label>
                <select name="checkNum">
                    <%
                        List<Check> checkList = (List<Check>) request.getAttribute("allChecks");
                        for (Check check : checkList) {
                    %>
                    <option value=<%=check.getCheck_number()%>><%=check.getCheck_number()%>
                    </option>
                    <%}%>
                </select>
            </td>
            <td>
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <form action="/checkInfo" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td>За номером чеку вивести усю інформацію про даний чек</td>

            <td><label>Номер чека: </label>
                <select name="checkNumber">
                    <%
                        List<Check> checkList1 = (List<Check>) request.getAttribute("allChecks");
                        for (Check check : checkList1) {
                    %>
                    <option value=<%=check.getCheck_number()%>><%=check.getCheck_number()%>
                    </option>
                    <%}%>
                </select>
            </td>
            <td>
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>

    <table cellspacing="2" border="1" cellpadding="5" width="600" id="table">

        <tr>
            <th>Посилання на запит</th>

        </tr>

        <tr>
            <td><a href="/list-check-period">Скласти список чеків, видрукуваних даним касиром за певний період часу</a></td>

        </tr>
<%--        <tr>--%>
<%--            <td><a href="/login">За номером чеку вивести усю інформацію про даний чек</a></td>--%>
<%--        </tr>--%>
        <tr>
            <td><a href="/login">Вивести усю інформацію про покупця з певним прізвищем, що має карту клієнта</a></td>

        </tr>
        <tr>
            <td><a href="/login">Список усіх постійних клієнтів, що мають карту клієнта з певним відсотком</a></td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список товарів, що належать певній категорії, відсортованих за назвою</a></td>

        </tr>
        <tr>
            <td><a href="/sort-products-name">+Скласти список усіх товарів, відсортований за назвою</a></td>
        </tr>

        <tr>
            <td><a href="/sort-prom-by-name">+Скласти список усіх акційних товарів, відсортованих за назвою</a></td>
        </tr>
        <tr>
            <td><a href="/sort-prom-by-quantity">+Скласти список усіх акційних товарів, відсортованих за кількістю одиниць товару</a></td>
        </tr>
        <tr>
            <td><a href="/sort-non-prom-by-name">+Скласти список усіх не акційних товарів, відсортованих за назвою</a></td>
        </tr>
        <tr>
            <td><a href="/sort-non-prom-by-quantity">+Скласти список усіх не акційних товарів, відсортованих за кількістю одиниць товару</a></td>
        </tr>
        <tr>
            <td><a href="/login">За UPC-товару знайти ціну продажу товару, кількість наявних одиниць товару</a></td>

        </tr>
        <tr>
            <td><a href="/employee?id=<%=idEmployee%>">+За ID працівника знайти всю інформацію про себе</a></td>
        </tr>
    </table>
</div>

<br>
<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>
<br>

</body>
</html>
