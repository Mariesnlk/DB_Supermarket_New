<%@ page import="com.naukma.supermarket.model.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Category</title>
</head>
<body>

<div>
    <h1>Інформація про категорію </h1>
</div>
<br>
<div>
    <%
        Category category = (Category) request.getAttribute("category");
    %>
    <div>

        <table cellspacing="2" border="1" cellpadding="5" width="300" id="table">
            <tr>
                <td>Номер:</td>
                <td>
                    <%
                        out.println(category.getCategory_number());
                    %>
                </td>
            </tr>
            <tr>
                <td>Назва:</td>
                <td>
                    <%
                        out.println(category.getCategory_name());
                    %>
                </td>
            </tr>
        </table>
    </div>
</div>
<br>

<input class="button" type=button onClick="location.href='/categories'" value='Всі категорії'>

</body>
</html>
