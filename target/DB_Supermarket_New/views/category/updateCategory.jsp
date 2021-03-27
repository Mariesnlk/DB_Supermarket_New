<%@ page import="com.naukma.supermarket.model.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Category</title>
</head>
<body>

<div>
    <h1>Оновити інформацію про категорію</h1>
</div>

<div>
    <%
        Category categoryToUpdate = (Category) request.getAttribute("categoryToUpdate");
    %>
    <div>

        <form method="post">
            <table id="table">
                <tr>
                    <td>Номер:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"category_number\" value=\"" + categoryToUpdate.getCategory_number() + "\" hidden>");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Назва:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"category_name\" value=\"" + categoryToUpdate.getCategory_name() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td align="right" colspan="2"><input type="submit" value="Підтвердити"></td>
                </tr>
            </table>
        </form>
    </div>
</div>

<input class="button" type=button onClick="location.href='/categories'" value='Всі категорії'>

</body>
</html>
