<%@ page import="com.naukma.supermarket.model.Check" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Check</title>
</head>
<body>

<div>
    <h1>Оновити інформацію про чек</h1>
</div>

<div>
    <%
        Check checkToUpdate = (Check) request.getAttribute("checkToUpdate");
    %>
    <div>

        <form method="post">
            <table id="table">
                <tr>
                    <td>ID працівника:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"idEmpl\" value=\"" + checkToUpdate.getId_employee() + "\">");
                        %>
                    </td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"id\" value=\"" + checkToUpdate.getCheck_number() + "\" hidden>");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Дата видачі чеку:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"printDate\" value=\"" + checkToUpdate.getPrint_date() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Загальна сума:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"sumTotal\" value=\"" + checkToUpdate.getSum_total() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>ПДВ:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"pdv\" value=\"" + checkToUpdate.getVat() + "\">");
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

<input class="button" type=button onClick="location.href='/checks'"
       value='Всі чеки'>


</body>
</html>
