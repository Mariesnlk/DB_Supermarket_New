<%@ page import="com.naukma.supermarket.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.naukma.supermarket.model.CustomerCard" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Check</title>
</head>
<body>

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
            <label>Дата видачі чеку: </label><input type="date" name="printDate" value="2021-03-22"><br/>
            <label>Загальна сума: </label><input type="number" min="0" name="sumTotal"
                                                 placeholder="Введіть загальну суму.."><br>
            <label>ПДВ: </label><input type="number" min="0" name="vat" type="number" min="0"
                                       placeholder="Введіть значення ПДВ.."><br/>
            <button class="button" type="submit">Підтвердити</button>
        </form>
    </div>
</div>

<div class="container-button">
    <input class="button" type=button onClick="location.href='/'" value='Повернутися на головну сторінку'>
</div>

</body>
</html>
