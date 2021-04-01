<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager`s page</title>


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

<h1>Сторінка менеджера</h1>

<div>
    <input class="button" type=button onClick="location.href='/add-employee'"
           value='Додати працівника'>
</div>

<br>

<div>
    <input class="button" type=button onClick="location.href='/add-category'"
           value='Додати категорію'>
</div>

<br>

<div>
    <input class="button" type=button onClick="location.href='/add-product'"
           value='Додати продукт'>
</div>

<br>

<div>
    <input class="button" type=button onClick="location.href='/add-customerCard'"
           value='Додати карту клієнта'>
</div>

<br>

<div>
    <input class="button" type=button onClick="location.href='/add-check'"
           value='Додати чек'>
</div>

<br>

<div>
    <input class="button" type=button onClick="location.href='/add-sale'"
           value='Додати акцію'>
</div>

<br>

<div>
    <input class="button" type=button onClick="location.href='/add-storeProduct'"
           value='Додати товар в магазині'>
</div>

<br>

<h1>Запити менеджера</h1>

<div>

    <table cellspacing="2" border="1" cellpadding="5" width="600" id="table">

        <tr>
            <th>Силка на запит</th>
            <th>параметр</th>

        </tr>

        <tr>
            <td><a href="/login"> Скласти список працівників, що займають посаду касира, відсортованих за прізвищем</a>
            </td>
            <td></td>

        </tr>

        <tr>
            <td><a href="/login">Скласти список товарів, що належать певній категорії, відсортованих за назвою</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">За прізвищем працівника знайти його телефон та адресу </a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список усіх товарів, відсортованих за назвою</a></td>
            <td></td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список усіх категорій, відсортованих за назвою</a></td>
            <td></td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список всіх товарів, що належать певній категорії</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список товарів у магазині, що належать певному товару</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">За UPC-товару знайти ціну продажу товару, кількість наявних одиниць товару</a></td>
            <td>параметр</td>

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
            <td><a href="/login">Скласти список чеків, видрукуваних певним касиром за певний період часу (з можливістю перегляду куплених товарів, їх к-сті та ціни)</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список чеків, видрукуваних усіма касирами за певний період часу (з можливістю перегляду куплених товарів, їх к-сті та ціни )</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">Загальна сума проданих товарів з чеків, видрукуваних певним касиром за певний період часу</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">Загальна сума проданих товарів з чеків, видрукуваних усіма касиром за певний період часу</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">Визначити загальну кількість одиниць певного товару, проданого за певний період часу</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список усіх постійних клієнтів, що мають карту клієнта, по полях  ПІБ, телефон, адреса (якщо вказана)</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список усіх постійних клієнтів, що мають карту клієнта із певним відсотком</a></td>
            <td>параметр</td>

        </tr>
        <tr>
            <td><a href="/login">За UPC-товару знайти ціну продажу товару, кількість наявних одиниць товару, назву та характеристики товару</a></td>
            <td>параметр</td>

        </tr>
    </table>
</div>

</body>
</html>
