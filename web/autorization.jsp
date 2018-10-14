<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.10.2018
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/autorizationServlet" method="post">
    <div class="row">

        <label for="login">Ваш логин:</label>

        <input type="text" class="text" name="login" id="login"/>

    </div>

    <div class="row">

        <label for="password">Ваш пароль:</label>

        <input type="password" class="text" name="password" id="password"/>

    </div>

    <div class="row">

        <input type="submit" name="submit" id="btn-submit" value="Авторизоваться"/>

    </div>

</form>
<p class="to_reg">Если вы не зарегистрированы в системе, <a href="/registration.jsp">зарегистрируйтесь</a>.</p>
</body>
</html>
