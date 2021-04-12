<%@ page import="com.naukma.supermarket.model.Check" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Print Check</title>
</head>
<body>
<div>
    <h1>Виписаний чек </h1>
</div>
<br>

<form action="/print-check" method="post">
    <table cellspacing="2" border="1" cellpadding="5" width="600" class="table">
        <td class="td-filled-left">Виберіть чек, який бажаєте друкувати</td>

        <td class="my-row td-filled-right"><label>Номер чека: </label>
            <select name="checkNum">
                <%
                    List<Check> checkList = (List<Check>) request.getAttribute("allChecks");
                    for (Check check : checkList) {
                %>
                <option value=<%=check.getCheck_number()%>><%=check.getCheck_number()%>
                </option>
                <%}%>
            </select>
        </td>
        <td class="sub-but-row my-td-cust">
            <button class="button" type="submit">Підтвердити</button>
        </td>
    </table>
</form>


<div>
    <%
        Check check = (Check) request.getAttribute("check");
    %>
    <div>

        <table cellspacing="2" border="1" cellpadding="5" width="300" id="table">
            <tr>
                <td>Номер чеку:</td>
                <td>
                    <%
                        out.println(check.getCheck_number());
                    %>
                </td>
            </tr>
            <tr>
                <td>ID працівника:</td>
                <td>
                    <%
                        out.println(check.getId_employee());
                    %>
                </td>
            </tr>
            <tr>
                <td>Дата видачі чеку:</td>
                <td>
                    <%
                        out.println(check.getPrint_date());
                    %>
                </td>
            </tr>
            <tr>
                <td>Загальна сума:</td>
                <td>
                    <%
                        out.println(check.getSum_total());
                    %>
                </td>
            </tr>
            <tr>
                <td>ПДВ:</td>
                <td>
                    <%
                        out.println(check.getVat());
                    %>
                </td>
            </tr>
        </table>
    </div>
</div>
<br>

<input class="button" type=button onClick="location.href='/checks'" value='Всі чеки'>
<input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>

</body>
</html>
