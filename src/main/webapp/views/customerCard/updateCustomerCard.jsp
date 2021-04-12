<%@ page import="com.naukma.supermarket.model.CustomerCard" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update customer card</title>

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

    input[type=text], select {
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
    <h1>Оновити інформацію про клієнта</h1>
</div>

<div class="main-div">
    <%
        CustomerCard customerCardToUpdate = (CustomerCard) request.getAttribute("customerCardToUpdate");
    %>
    <div>

        <form method="post">
            <table id="table">
                <tr>
                    <td>Прізвище:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"custSurname\" value=\"" + customerCardToUpdate.getCust_surname() + "\">");
                        %>
                    </td>
<%--                    <td>--%>
<%--                        <%--%>
<%--                            out.println("<input type=\"text\" name=\"id\" value=\"" + customerCardToUpdate.getCard_number() + "\" hidden>");--%>
<%--                        %>--%>
<%--                    </td>--%>
                </tr>
                <tr>
                    <td>Ім`я:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"custName\" value=\"" + customerCardToUpdate.getCust_name() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>По-батькові:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"custPatronymic\" value=\"" + customerCardToUpdate.getCust_patronymic() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Номер телефону:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"phoneNum\" value=\"" + customerCardToUpdate.getPhone_number() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Місто:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"city\" value=\"" + customerCardToUpdate.getCity() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Вулиця:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"street\" value=\"" + customerCardToUpdate.getStreet() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Індекс:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"zipCode\" value=\"" + customerCardToUpdate.getZip_code() + "\">");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Відсоток знижки:</td>
                    <td>
                        <%
                            out.println("<input type=\"text\" name=\"percent\" value=\"" + customerCardToUpdate.getPercent() + "\">");
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

<input class="button" type=button onClick="location.href='/customerCards'"
       value='Всі картки клієнтів'>

</body>
</html>
