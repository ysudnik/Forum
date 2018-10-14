<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.10.2018
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация пользователей</title>
</head>
<body>
<form action="/registrationServlet" method="post">
    <div class="row">

        <label for="login">Придумайте Ваш логин:</label>

        <input type="text" class="text" name="login" id="login"/>

    </div>

    <div class="row">

        <label for="password">Ваш пароль:</label>

        <input type="password" class="text" name="password" id="password"/>
        <label for="password">Повторите пароль:</label>

        <input type="password" class="text" name="password_again" id="password_again"/>

    </div>

    <div class="row">

        <input type="submit" name="submit" id="btn-submit" value="Зарегистрироваться"/>

    </div>

</form>
</body>

</html>
