<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>

<div>
    <h1>Додавання категорії</h1>

    <div>
        <form action="${pageContext.request.contextPath}/add-category" method="post">
<%--            <label>Номер: </label> <input type="text" name="category_number" placeholder="Введіть номер категорії.."><br/>--%>
            <label>Назва: </label> <input type="text" name="category_name" placeholder="Введіть назву категорії.."><br/>
            <button class="button" type="submit">Підтвердити</button>
        </form>
    </div>
</div>

<div class="container-button">
    <input class="button" type=button onClick="location.href='/DB_Supermarket_war_exploded/'" value='Повернутися на головну сторінку'>
</div>

</body>
</html>
