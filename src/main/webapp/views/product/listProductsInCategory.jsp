<%@ page import="com.naukma.supermarket.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Products in category</title>
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

    <h1>Список всіх товарів, що належать певній категорії</h1>

    <div>
        <form action="/list-products-in-category" method="post">
            <label>Номер категорії: </label>
            <select name="categoryProd">
            <%
                List<Category> catList = (List<Category>) request.getAttribute("allCategories");
                for (Category category : catList) {
            %>
            <option value=<%=category.getCategory_name()%>><%=category.getCategory_name()%>
            </option>
            <%}%>
        </select>
            <br>

            <button class="button" type="submit">Підтвердити</button>
        </form>
    </div>

</div>

<div class="container-button">
    <input class="button" type=button onClick="location.href='/indexManager'" value='Повернутися сторінку запитів менеджера'>
</div>


</body>
</html>
