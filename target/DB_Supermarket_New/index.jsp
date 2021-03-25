<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>

<h1>Наш Супермаркет</h1>

<%--<%--%>
<%--//  User registeredUser = (User) session.getAttribute("registeredUser");--%>
<%--//  if (registeredUser != null) {--%>
<%--//    if (registeredUser.getRole().equals("ADMIN")) {--%>
<%--%>--%>

<div>
    <input class="button" type=button onClick="location.href='/DB_Supermarket_New_war_exploded/add-employee'"
           value='Додати працівника'>
</div>

<div>
    <input class="button" type=button onClick="location.href='/employees'"
           value='Всі працівникі'>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/add-category'"
           value='Додати категорію'>
</div>

<div>
    <input class="button" type=button onClick="location.href='/categories'"
           value='Всі категорії'>
</div>


<%--<div>--%>
<%--  <input class="button" type=button onClick="location.href='/add-user'" value='Реєстрація'>--%>
<%--</div>--%>

<%--<div>--%>
<%--  <input class="button" type=button onClick="location.href='/login'" value='Login'>--%>
<%--</div>--%>

<%--<div>--%>
<%--  <input class="button" type=button onClick="location.href='/users'" value='All Users'>--%>
<%--</div>--%>

<%--<div>--%>
<%--  <input class="button" type=button onClick="location.href='/autos'" value='All Autos'>--%>
<%--</div>--%>

<%--<div>--%>
<%--  <input class="button" type=button onClick="location.href='/add-auto'" value='Add Auto'>--%>
<%--</div>--%>

<%--<div>--%>
<%--  <input class="button" type=button onClick="location.href='/orders'" value='All Orders'>--%>
<%--</div>--%>

<%--<div>--%>
<%--  <input class="button" type=button onClick="location.href='/add-order'" value='Add Order'>--%>
<%--</div>--%>

<%--<%--%>
<%--//} else if (registeredUser.getRole().equals("CLIENT")) {--%>
<%--%>--%>

<%--<div>--%>
<%--  <input class="button" type=button onClick="location.href='/login'" value='Login'>--%>
<%--</div>--%>

<%--<div>--%>
<%--  <input class="button" type=button onClick="location.href='/add-order'" value='Add Order'>--%>
<%--</div>--%>


<%--<%--%>
<%--//  }--%>
<%--//} else {--%>
<%--  //out.println("Please register!" + registeredUser);--%>

<%--%>--%>
<%--<div>--%>
<%--  <input class="button" type=button onClick="location.href='/add-user'" value='Реєстрація'>--%>
<%--</div>--%>

<%--<div>--%>
<%--  <input class="button" type=button onClick="location.href='/login'" value='Login'>--%>
<%--</div>--%>
<%--<%--%>
<%--//  }--%>
<%--%>--%>
</body>
</html>
