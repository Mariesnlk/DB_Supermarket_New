<%@ page import="com.naukma.supermarket.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>

<div>

    <h1>Додавання продукту</h1>

    <div>
        <form action="/add-product" method="post">
            <!-- <label>Номер категорії: </label> <input type="text" name="categoryProd" placeholder="Введіть номер категорії.."><br/>-->
            <label>Назва: </label> <input type="text" name="nameProd" placeholder="Введіть назву продукту.."><br/>
            <label>Характеристика: </label> <input type="text" name="charsProd"
                                                   placeholder="Введіть характеристику продукту.."><br/>
            <label>Номер категорії: </label> <select name="categoryProd">
            <%
                List<Category> catList = (List<Category>) request.getAttribute("allCategories");
                for (Category category : catList) {
            %>
            <option value=<%=category.getCategory_number()%>><%=category.getCategory_name()%>
            </option>
            <%}%>

        </select>
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
