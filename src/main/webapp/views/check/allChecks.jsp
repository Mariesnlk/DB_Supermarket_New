<%@ page import="com.naukma.supermarket.model.Check" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Checks</title>
</head>
<body>


<div>
    <h1>Всі працівники</h1>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>

    <input class="button" type=button onClick="location.href='/add-check'" value='Додати чек'>
</div>
<br>
<br>
<div>
    <div>

        <%
            List<Check> checks = (List<Check>) request.getAttribute("allChecks");
            if (checks != null && !checks.isEmpty()) {
        %>

        <table cellspacing="2" border="1" cellpadding="5" width="600" id="table">
            <thead>
            <tr>
                <th>Номер чека</th>
                <th>ID працівника</th>
                <th>Номер картки клієнта</th>
                <th>Дата</th>
                <th>Загальна сума</th>
                <th>ПДВ</th>
            </tr>
            </thead>
            <tbody>

            <%
                for (Check check : checks) {
                    out.println("<tr>");
                    out.println("<td><a href=\"/check?id=" + check.getCheck_number() + "\">"
                            + check.getId_employee() + "</a></td>");
                    out.println("<td>" + check.getId_employee() + "</td>");
                    out.println("<td>" + check.getCard_number() + "</td>");
                    out.println("<td>" + check.getPrint_date() + "</td>");
                    out.println("<td>" + check.getSum_total() + "</td>");
                    out.println("<td>" + check.getVat() + "</td>");

                    out.println("<td><a href=\"/update-check?id=" + check.getCheck_number()
                            + "\">Оновити</a></td>");
                    out.println("<td><a href=\"/delete-check?id=" + check.getCheck_number()
                            + "\">Видалити</a></td>");
                    out.println("</tr>");
                }
            %>

            </tbody>
        </table>

        <%
            } else {
                out.println("<p>There are no checks yet!</p>");
            }
        %>

    </div>
</div>

<br>

<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>

    <input class="button" type=button onClick="location.href='/add-check'" value='Додати чек'>
</div>


</body>
</html>
