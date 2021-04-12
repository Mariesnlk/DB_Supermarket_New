<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>


<style>
    body {
        background-image: url("images/background.png");
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
    <input class="button" type=button onClick="location.href='/login'" value='Ввійти'>
</div>
<div>
    <input class="button" type=button onClick="location.href='/logout'" value='Вийти'>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/employees'"
           value='Всі працівники'>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/categories'"
           value='Всі категорії'>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/products'"
           value='Всі продукти'>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/customerCards'"
           value='Всі карти клієнтів'>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/checks'"
           value='Всі чеки'>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/sales'"
           value='Всі акції'>
</div>
<br>
<div>
    <input class="button" type=button onClick="location.href='/storeProducts'"
           value='Всі товари в магазині'>
</div>
</body>
</html>
