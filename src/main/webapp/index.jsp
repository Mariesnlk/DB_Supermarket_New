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
    <input class="button" type=button onClick="location.href='/add-employee'"
           value='Додати працівника'>
</div>

<div>
    <input class="button" type=button onClick="location.href='/employees'"
           value='Всі працівники'>
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
<br>
<div>
    <input class="button" type=button onClick="location.href='/add-product'"
           value='Додати продукт'>
</div>

<div>
    <input class="button" type=button onClick="location.href='/products'"
           value='Всі продукти'>
</div>

<br>
<div>
    <input class="button" type=button onClick="location.href='/add-customerCard'"
           value='Додати карту клієнта'>
</div>

<div>
    <input class="button" type=button onClick="location.href='/customerCards'"
           value='Всі карти клієнтів'>
</div>

<br>
<div>
    <input class="button" type=button onClick="location.href='/add-check'"
           value='Додати карту клієнта'>
</div>

<div>
    <input class="button" type=button onClick="location.href='/checks'"
           value='Всі карти клієнтів'>
</div>

<br>
<div>
    <input class="button" type=button onClick="location.href='/add-sale'"
           value='Додати акцію'>
</div>

<div>
    <input class="button" type=button onClick="location.href='/sales'"
           value='Всі акції'>
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
