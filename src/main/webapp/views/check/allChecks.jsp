<%@ page import="com.naukma.supermarket.model.Check" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Checks</title>
</head>
<body>

<style>
    body {
        background-image: url("/images/background.png");
        background-repeat: no-repeat;
        background-size: cover;
    }

    h1 {
        text-align: center;
        color: rgba(220, 0, 0, 1);;
    }

    .button {
        border: 0;
        line-height: 2.5;
        padding: 0 20px;
        font-size: 1rem;
        text-align: center;
        color: #fff;
        text-shadow: 1px 1px 1px #000;
        border-radius: 10px;
        background-color: rgba(220, 0, 0, 1);
        background-image: linear-gradient(to top left,
        rgba(0, 0, 0, .2),
        rgba(0, 0, 0, .2) 30%,
        rgba(0, 0, 0, 0));
        box-shadow: inset 2px 2px 3px rgba(255, 255, 255, .6),
        inset -2px -2px 3px rgba(0, 0, 0, .6);
    }

    #table {
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #table td, #table th {
        border: 1px solid #000000;
        padding: 8px;
        background-color: rgba(255, 255, 255, 0.7);
    }

    #table th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: rgba(220, 0, 0, 1);
        background-image: linear-gradient(to top left,
        rgba(0, 0, 0, .2),
        rgba(0, 0, 0, .2) 30%,
        rgba(0, 0, 0, 0));
        color: white;
    }

    @media print {

        #printableTable {
            display: block;
        }

        /*tr:last-child {*/
        /*    background-color: lime;*/
        /*}*/

    }

</style>

    <br>
    <div>
        <h1>Всі чеки</h1>
    </div>
    <br>
    <div>
        <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>

        <input class="button" type=button onClick="location.href='/add-check'" value='Додати чек'>
    </div>
    <br>
    <br>

<div id="printableTable">
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
                        out.println("<td><a href=\"/check?checkNumber=" + check.getCheck_number() + "\">"
                                + check.getCheck_number() + "</a></td>");
                        out.println("<td>" + check.getId_employee() + "</td>");
                        out.println("<td>" + check.getCard_number() + "</td>");
                        out.println("<td>" + check.getPrint_date() + "</td>");
                        out.println("<td>" + check.getSum_total() + "</td>");
                        out.println("<td>" + check.getVat() + "</td>");

                        out.println("<td><a href=\"/update-check?checkNumber=" + check.getCheck_number()
                                + "\">Оновити</a></td>");
                        out.println("<td><a href=\"/delete-check?checkNumber=" + check.getCheck_number()
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
</div>

<br>

<div>
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>
    <input class="button" type=button onClick="location.href='/add-check'" value='Додати чек'>
    <br><br>
    <button class="Button Button--outline button" onclick="printDiv()">Друкувати</button>
</div>

<iframe name="print_frame" width="0" height="0" frameborder="0" src="about:blank"></iframe>

<script>
    function printDiv() {
        window.frames["print_frame"].document.body.innerHTML = document.getElementById("printableTable").innerHTML;
        window.frames["print_frame"].window.focus();
        window.frames["print_frame"].window.print();
    }
</script>


</body>
</html>
