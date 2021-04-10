<%@ page import="com.naukma.supermarket.model.Check" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Check</title>
</head>
<body>

<div>
    <h1>Інформація про чек </h1>
</div>
<br>
<div>
    <%
        Check check = (Check) request.getAttribute("check");
    %>
    <div>

        <table cellspacing="2" border="1" cellpadding="5" width="300" id="table">
            <tr>
                <td>Загальна сума:</td>
                <td>
                    <%
                        out.println(check.getSum_total());
                    %>
                </td>
            </tr>
        </table>
    </div>
</div>
<br>

<input class="button" type=button onClick="location.href='/checks'" value='Всі чеки'>


</body>
</html>
