<%@ page import="java.util.List" %>
<%@ page import="com.naukma.supermarket.model.ProductSellingCheck" %>
<%@ page import="com.naukma.supermarket.model.CheckSaleEmployeeCard" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Print Check</title>
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
        width: 40%;
    }

    .custom-table {
        border: 1px solid #000000;
        padding: 8px;
        background-color: rgba(255, 255, 255, 0.9);
    }

    .bold {
        font-weight: bolder;
    }

    td {
        width: 70px;
    }

    @media print {
        * {
            display: none;
        }

        #printableTable {
            display: block;
        }
    }

</style>

<div id="printableTable">

    <br>
    <h1>Друк чеку</h1>
    <br>

    <%
        CheckSaleEmployeeCard checkInfo = (CheckSaleEmployeeCard) request.getAttribute("checkInfo");
    %>
    <div>
        <table cellspacing="2" border="0" cellpadding="5" width="300" class="table">
            <tr>
                <td class="bold">Чек №:</td>
                <td class="bold">
                    <%
                        out.println(checkInfo.getCheck_number());
                    %>
                </td>
            </tr>
            <tr>
                <td class="bold">Касир:</td>
                <td class="bold">
                    <%
                        out.println(checkInfo.getEmpl_surname() + "  " + checkInfo.getEmpl_name() + "  " + checkInfo.getEmpl_patronymic());
                    %>
                </td>
            </tr>
            <tr>
                <td class="bold">Дата:</td>
                <td class="bold">
                    <%
                        out.println(checkInfo.getPrint_date());
                    %>
                </td>
            </tr>
        </table>
    </div>

    <br>

    <div>
        <%
            List<ProductSellingCheck> listProducts = (List<ProductSellingCheck>) request.getAttribute("listProducts");
            if (listProducts != null && !listProducts.isEmpty()) {
        %>
        <table cellspacing="2" border="0" cellpadding="5" width="300" class="table">
            <tbody>

            <%
                for (ProductSellingCheck product : listProducts) {
                    out.println("<tr>");
                    out.println("<td>" + product.getProduct_name() + "</td>");
                    out.println("<td>" + product.getSelling_price() + " грн </td>");
                    out.println("</tr>");
                }
            %>

            </tbody>
        </table>

        <%
            } else {
                out.println("<p>There are no products yet!</p>");
            }
        %>
    </div>

    <p class="bold">------------------------------------------------------------</p>

    <div>
        <table cellspacing="2" border="0" cellpadding="5" width="300" class="table">
            <tr>
                <td class="bold">Сума:</td>
                <td class="bold">
                    <%
                        out.println(checkInfo.getSelling_price() + " грн");
                    %>
                </td>
            </tr>
            <tr>
                <td class="bold">ПДВ:</td>
                <td class="bold">
                    <%
                        out.println(checkInfo.getVat() * checkInfo.getSelling_price() + " грн");
                    %>
                </td>
            </tr>
            <tr>
                <td></td>
                <td class="info">ПДВ:
                    <%
                        out.println(checkInfo.getVat() * 100 + " %");
                    %>
                </td>
            </tr>
        </table>
    </div>

</div>

<br>
<br>
<button class="Button Button--outline button" onclick="printDiv()">Друкувати</button>
<br><br>
<input class="button" type=button onClick="location.href='/'" value='Повернутися на головну'>

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
