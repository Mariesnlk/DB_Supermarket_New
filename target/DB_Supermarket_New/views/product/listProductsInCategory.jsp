<%@ page import="com.naukma.supermarket.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Products in category</title>
</head>
<body>

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
