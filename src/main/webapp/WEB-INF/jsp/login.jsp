<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Славные игрушки</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/style/login.css" type="text/css" media="screen"/>
</head>
<body class="text-center mb-4">
<div class="form">
    <h1>Пожалуйста,войдите</h1>
    <form method="post" action="/login" class="form-signin">
        <label for="inputEmail" class="sr-only">Логин</label>
        <input type="text" id="inputEmail" class="form-control" name="username" placeholder="Введите логин" required autofocus>
        <label for="inputPassword" class="sr-only">Пароль</label>
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Введите пароль" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form>
</div>
</body>