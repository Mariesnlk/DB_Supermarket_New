<%@ page import="com.naukma.supermarket.model.Check" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show sum of checks</title>
</head>
<body>


<div>
    <h1>Загальна сума з чеку </h1>
</div>
<br>
<div>
    <%
        Check check = (Check) request.getAttribute("sumCheck");
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

<input class="button" type=button onClick="location.href='/index-manager'" value='Повернутися на сторінку менеджера'>



</body>
</html>
