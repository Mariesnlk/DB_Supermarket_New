<%@ page import="com.naukma.supermarket.model.Employee" %>
<%@ page import="com.naukma.supermarket.model.Check" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Checks from period</title>
</head>
<body>

<%
    Employee registeredEmployee = (Employee) session.getAttribute("registeredEmployee");
    String idEmployee = registeredEmployee.getId_employee();

%>


<div>
    <div>

        <%
            List<Check> checks = (List<Check>) request.getAttribute("allChecksPeriod");
            if (checks != null && !checks.isEmpty()) {
        %>

        <table cellspacing="2" border="1" cellpadding="5" width="600" id="table">
            <thead>
            <tr>
                <th>ID касира</th>
                <th>Номер чека</th>
            </tr>
            </thead>
            <tbody>

            <%
                for (Check check : checks) {
                    out.println("<tr>");
                    out.println("<td>" + idEmployee + "</td>");
                    out.println("<td><a href=\"/check?checkNumber=" + check.getCheck_number() + "\">"
                            + check.getId_employee() + "</a></td>");
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

</body>
</html>
