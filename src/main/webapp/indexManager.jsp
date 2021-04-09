<%@ page import="com.naukma.supermarket.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="com.naukma.supermarket.model.StoreProduct" %>
<%@ page import="com.naukma.supermarket.model.Product" %>
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
    <input class="button" type=button onClick="location.href='/add-query'"
           value='Мій запит'>
</div>

<br>

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

<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>

<br>

<h1>Запити менеджера</h1>

<div>

    <!-- start -->
    <form action="/list-products-in-category" method="post">
        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
            <td>+Скласти список всіх товарів, що належать певній категорії</td>

            <td><label>Номер категорії: </label>
                <select name="categoryProd">
                    <%
                        List<Category> catList = (List<Category>) request.getAttribute("allCategories");
                        for (Category category : catList) {
                    %>
                    <option value=<%=category.getCategory_name()%>><%=category.getCategory_name()%>
                    </option>
                    <%}%>
                </select>
            </td>
            <td>
                <button class="button" type="submit">Підтвердити</button>
            </td>
        </table>
    </form>
    <!-- end -->

<%--    <form action="/list-store-products" method="post">--%>
<%--        <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">--%>
<%--            <td>Скласти список товарів у магазині, що належать певному товару</td>--%>

<%--            <td><label>Номер категорії: </label>--%>
<%--                <select name="productName">--%>
<%--                    <%--%>
<%--                        List<Product> catList1 = (List<Product>) request.getAttribute("allProducts");--%>
<%--                        for (Product category : catList1) {--%>
<%--                    %>--%>
<%--                    <option value=<%=category.getProduct_name()%>><%=category.getProduct_name()%>--%>
<%--                    </option>--%>
<%--                    <%}%>--%>
<%--                </select>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <button class="button" type="submit">Підтвердити</button>--%>
<%--            </td>--%>
<%--        </table>--%>
<%--    </form>--%>

    <table cellspacing="2" border="1" cellpadding="5" width="600" id="table">

        <tr>
            <th>Посилання на запит</th>

        </tr>

        <tr>
            <td><a href="/sorted-cashier-name">+Скласти список працівників, що займають посаду касира, відсортованих за
                прізвищем</a></td>

        </tr>

        <tr>
            <td><a class="query" href="/catServlet/?category=">Скласти список товарів, що належать певній категорії,
                відсортованих за назвою</a></td>
            <td><input class="query-field" type="text"></td>

        </tr>
        <tr>
            <td><a href="/login">!!За прізвищем працівника знайти його телефон та адресу </a></td>

        </tr>
        <tr>
            <td><a href="/sort-products-name">+Скласти список усіх товарів, відсортованих за назвою</a></td>

        </tr>
        <tr>
            <td><a href="/sorted-categories-name">+Скласти список усіх категорій, відсортованих за назвою</a></td>

        </tr>
        <tr>

        </tr>
        <tr>
            <td><a href="/list-store-products">Скласти список товарів у магазині, що належать певному товару</a></td>

        </tr>
        <tr>
            <td><a href="/storeProductByUpc">За UPC-товару знайти ціну продажу товару, кількість наявних одиниць товару</a></td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список усіх акційних товарів, відсортованих за кількістю одиниць товару/ за
                назвою</a></td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список усіх не акційних товарів, відсортованих за кількістю одиниць товару/ за
                назвою</a></td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список чеків, видрукуваних певним касиром за певний період часу (з можливістю
                перегляду куплених товарів, їх к-сті та ціни)</a></td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список чеків, видрукуваних усіма касирами за певний період часу (з можливістю
                перегляду куплених товарів, їх к-сті та ціни )</a></td>

        </tr>
        <tr>
            <td><a href="/login">Загальна сума проданих товарів з чеків, видрукуваних певним касиром за певний період
                часу</a></td>

        </tr>
        <tr>
            <td><a href="/login">Загальна сума проданих товарів з чеків, видрукуваних усіма касиром за певний період
                часу</a></td>

        </tr>
        <tr>
            <td><a href="/login">Визначити загальну кількість одиниць певного товару, проданого за певний період
                часу</a></td>

        </tr>
        <tr>
            <td><a href="/list-customer-card">+Скласти список усіх постійних клієнтів, що мають карту клієнта, по полях
                ПІБ, телефон, адреса (якщо вказана)</a></td>

        </tr>
        <tr>
            <td><a href="/login">Скласти список усіх постійних клієнтів, що мають карту клієнта із певним відсотком</a>
            </td>

        </tr>
        <tr>
            <td><a href="/login">За UPC-товару знайти ціну продажу товару, кількість наявних одиниць товару, назву та
                характеристики товару</a></td>

        </tr>
    </table>
</div>

<br>
<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>
<br>


<!-- <tr>
            <td><a class="query"   href="/catServlet/category=">Скласти список товарів, що належать певній категорії, відсортованих за назвою</a></td>
            <td><input class="query-field" type="text"></td>

        </tr>-->
<script>
    document.querySelectorAll('.query-field').forEach((elem) => elem.addEventListener('input', addParameter))

    function addParameter() {
        let value = this.value;
        let a = this.parentNode.parentNode.querySelector('a');
        a.setAttribute('href', a.getAttribute('href') + value);

    }


</script>

</body>
</html>
