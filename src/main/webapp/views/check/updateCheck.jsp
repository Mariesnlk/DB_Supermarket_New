<%@ page import="com.naukma.supermarket.model.Check" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Check</title>
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

    input[type=text], input[type=date], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    .main-div {
        border-radius: 5px;
        background-color: rgba(255, 255, 255, 0.6);
        padding: 20px;
        margin-bottom: 10px;
    }

    input[type=submit], .button {
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

    form {
        text-align: left;
    }

    #container-button {
        text-align: center;
        margin-top: 10px;
    }

</style>
<br>

<div>
    <h1>Оновити інформацію про чек</h1>
</div>

<div class="main-div">
    <%
        Check checkToUpdate = (Check) request.getAttribute("checkToUpdate");
    %>
    <div>

        <form method="post">
            <table id="table">
<%--                <tr>--%>
<%--                    <td>ID працівника:</td>--%>
<%--                    <td>--%>
<%--                        <%--%>
<%--                            out.println("<input type=\"text\" name=\"idEmployee\" value=\"" + checkToUpdate.getId_employee() + "\">");--%>
<%--                        %>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <%--%>
<%--                            out.println("<input type=\"text\" name=\"checkNumber\" value=\"" + checkToUpdate.getCheck_number() + "\" hidden>");--%>
<%--                        %>--%>
<%--                    </td>--%>
<%--                </tr>--%>
                <tr>
                    <td>Дата видачі чеку:</td>
                    <td>
                        <%
                            out.println("<input type=\"date\" name=\"printDate\" value=\"" + checkToUpdate.getPrint_date() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Загальна сума:</td>
                    <td>
<%--                        <%--%>
<%--                            out.println("<input type=\"text\" name=\"sumTotal\" value=\"" + checkToUpdate.getSum_total() + "\">");--%>
<%--                        %>--%>
                    </td>
                </tr>
                <tr>
                    <td>ПДВ:</td>
                    <td>
<%--                        <%--%>
<%--                            out.println("<input type=\"text\" name=\"vat\" value=\"" + checkToUpdate.getVat() + "\">");--%>
<%--                        %>--%>
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
