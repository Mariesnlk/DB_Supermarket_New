<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Store Product</title>
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

    input[type=text], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=password], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    div {
        border-radius: 5px;
        background-color: rgba(255, 255, 255, 0.5);
        padding: 20px;
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

    form {
        text-align: left;
    }

</style>
<br>

<div>
    <%--    <%--%>
    <%--        if (request.getAttribute("lastName") != null && request.getAttribute("firstName") != null) {--%>
    <%--            out.println("<p>Працівник '" + request.getAttribute("firstName") + "' '" + request.getAttribute("lastName") + "' зареєстрований!</p>");--%>
    <%--        }--%>
    <%--    %>--%>

    <h1>Додавання товару в магазині</h1>

    <div>
        <form action="/add-storeProduct" method="post">
            <label>Код товару: </label> <input type="text" name="upc" placeholder="Введіть код товару.."><br/>
            <label>Код акційного товару: </label> <input type="text" name="UPCProm"
                                                         placeholder="Введіть код акційного товару.."><br/>
            <label>ID товару: </label> <input type="text" name="idProduct" placeholder="Введіть номер товару.."><br/>
            <br>
            <label>Ціна товару: </label><input type="number" min="0" name="sellingPrice"
                                               placeholder="Введіть ціну товару.."><br/>
            <br>
            <label>Кількість товару: </label><input type="number" min="0" name="productsNum"
                                                    placeholder="Введіть кількість товару.."><br/>
            <br>
            <label>Чи товар акційний: </label>
            <select name="promotionalProduct">
                <option value=true>Так</option>
                <option value=false>Ні</option>
            </select><br>
            <br>
            <button class="button" type="submit">Підтвердити</button>
        </form>
    </div>
</div>

<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>

</body>
</html>
