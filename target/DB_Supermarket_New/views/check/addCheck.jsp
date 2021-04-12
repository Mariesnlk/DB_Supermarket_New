<%@ page import="com.naukma.supermarket.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.naukma.supermarket.model.CustomerCard" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Check</title>
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

    input[type=text], input[type=date], input[type=number], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=password], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    div {
        border-radius: 5px;
        background-color: rgba(255, 255, 255, 0.5);
        padding: 20px;
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

    form {
        text-align: left;
    }

</style>
<br>

<div>
    <%--    <%--%>
    <%--        if (request.getAttribute("lastName") != null && request.getAttribute("firstName") != null) {--%>
    <%--            out.println("<p>Працівник '" + request.getAttribute("firstName") + "' '" + request.getAttribute("lastName") + "' зареєстрований!</p>");--%>
    <%--        }--%>
    <%--    %>--%>

    <h1>Додавання чеку</h1>

    <div>
        <form action="/add-check" method="post">
            <%--  added regex --%>
            <label>Номер чеку: </label> <input type="text" name="checkNumber" placeholder="Введіть номер чеку.."><br/>
            <label>ID працівника: </label> <select name="idEmployee">
            <%
                List<Employee> employeeList = (List<Employee>) request.getAttribute("allEmployees");
                for (Employee employee : employeeList) {
            %>
            <option value=<%=employee.getId_employee()%>><%=employee.getEmpl_surname()%>
                &nbsp; <%=employee.getEmpl_name()%>
            </option>
            <%}%>
        </select>
            <br>

            <label>Номер картки клієнта: </label> <select name="cardNumber">
            <%
                List<CustomerCard> customerCardList = (List<CustomerCard>) request.getAttribute("allCustomerCards");
                for (CustomerCard customerCard : customerCardList) {
            %>
            <option value=<%=customerCard.getCard_number()%>><%=customerCard.getCust_surname()%>
                &nbsp; <%=customerCard.getCust_name()%>
            </option>
            <%}%>
        </select>
            <br>

            <%--  added regex --%>
            <br>
            <label>Дата видачі чеку: </label><input type="date" name="printDate" value="2021-03-22"><br/>
            <br>
            <label>Загальна сума: </label><input type="number" min="0" name="sumTotal"
                                                 placeholder="Введіть загальну суму.."><br>
            <br>
            <label>ПДВ: </label><input type="number" min="0" name="vat" type="number" min="0"
                                       placeholder="Введіть значення ПДВ.."><br/>
            <br>
            <button class="button" type="submit">Підтвердити</button>
        </form>
    </div>
</div>

<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>

</body>
</html>
