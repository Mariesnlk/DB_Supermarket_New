<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>

<div>
    <h1>Додавання категорії</h1>

    <div>
        <form action="/add-category" method="post">
            <label>Назва: </label> <input type="text" name="categoryName" placeholder="Введіть назву категорії.."><br/>
            <button class="button" type="submit">Підтвердити</button>
        </form>
    </div>
</div>

<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>

</body>
</html>
