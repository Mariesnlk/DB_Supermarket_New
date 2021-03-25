<%@ page import="com.mariia.syne.taxi_service.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Марія
  Date: 13.02.2021
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Result </title>
</head>
<body>

<style>
    body {
        background-image: url("/images/background.jpeg");
        background-repeat: no-repeat;
        background-size: cover;
    }

    h1 {
        text-align: center;
        color: rgba(220, 0, 0, 1);;
    }
    div{
        margin-top: 5px;
        margin-bottom: 5px;
        text-align: center;
    }


    input.button {
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

</style>

<div>

    <%
        User registeredUser = (User) session.getAttribute("registeredUser");

        if (registeredUser != null) {
            out.println("<h1>You have successfully log in!</h1>");
//            out.println(registeredUser);
//            out.println("userRole="+registeredUser.getRole());
    %>

    <div>
        <input class="button" type=button onClick="location.href='/logout'" value='Logout'>
    </div>
    <div>
        <input class="button" type=button onClick="location.href='../..'" value='Back to main page'>
    </div>
    <%
    } else {
        out.println("<h1>Error! Try one more time!</h1>");

    %>
    <div>
        <input class="button" type=button onClick="location.href='/login'" value='Login'>
    </div>
    <div>
        <input class="button" type=button onClick="location.href='../..'" value='Back to main page'>
    </div>
    <%
        }
    %>
</div>

</body>
</html>