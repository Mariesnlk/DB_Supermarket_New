<%@ page import="com.naukma.supermarket.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Categories</title>
</head>
<body>

<div>
    <h1>Всі категорії</h1>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/DB_Supermarket_war_exploded/'" value='Повернутися на головну'>

    <input class="button" type=button onClick="location.href='/DB_Supermarket_war_exploded/add-category'" value='Додати Категорію'>
</div>
<br>
<br>
<div>
    <div>

        <%
            List<Category> categories = (List<Category>) request.getAttribute("allCategories");
            if (categories != null && !categories.isEmpty()) {
        %>

        <table cellspacing="2" border="1" cellpadding="5" width="600" id="table">
            <thead>
            <tr>
                <th>Номер</th>
                <th>Назва</th>
            </tr>
            </thead>
            <tbody>

            <%
                for (Category category : categories) {
                    out.println("<tr>");
                    out.println("<td><a href=\"/DB_Supermarket_war_exploded/category?id=" + category.getCategory_number() + "\">"
                            + category.getCategory_number() + "</a></td>");
                    out.println("<td>" + category.getCategory_name() + "</td>");

                    out.println("<td><a href=\"/DB_Supermarket_war_exploded/update-category?id=" + category.getCategory_number()
                            + "\">Обновити</a></td>");
                    out.println("<td><a href=\"/DB_Supermarket_war_exploded/delete-category?id=" + category.getCategory_number()
                            + "\">Видалити</a></td>");
                    out.println("</tr>");
                }
            %>

            </tbody>
        </table>

        <%
            } else {
            out.println("<p>There are no categories yet!</p>");
            }
        %>
    </div>
</div>
<br>

<div>
    <input class="button" type=button onClick="location.href='/DB_Supermarket_war_exploded/'" value='Повернутися на головну'>

    <input class="button" type=button onClick="location.href='/DB_Supermarket_war_exploded/add-category'" value='Додати Категорію'>
</div>
</body>
</html>
