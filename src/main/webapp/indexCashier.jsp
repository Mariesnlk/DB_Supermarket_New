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

<br>

<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>

<br>

<h1>Запити касира</h1>

<div>

    <table cellspacing="2" border="1" cellpadding="5" width="600" id="table">

        <tr>
            <th>Посилання на запит</th>
            <th>параметр</th>

        </tr>

        <tr>
            <td><a href="/login">Скласти список чеків, видрукуваних даним касиром за певний період часу</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">За номером чеку вивести усю інформацію про даний чек</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">Вивести усю інформацію про покупця з певним прізвищем, що має карту клієнта</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">Список усіх постійних клієнтів, що мають карту клієнта з певним відсотком</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список товарів, що належать певній категорії, відсортованих за назвою</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список усіх товарів, відсортований за назвою</a></td>
            <td></td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список усіх акційних товарів, відсортованих за кількістю одиниць товару/ за назвою</a></td>
            <td></td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список усіх не акційних товарів, відсортованих за кількістю одиниць товару/ за назвою</a></td>
            <td></td>

        </tr>
        <tr>
            <td><a href="/login">За номером чека скласти список усіх товарів, інформація про продаж яких є у цьому чеку</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">За UPC-товару знайти ціну продажу товару, кількість наявних одиниць товару</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">За ID_працівника знайти всю інформацію про себе</a></td>
            <td>параметр</td>

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