<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Славные игрушки</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/style/style.css" type="text/css" media="screen"/>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/lodash@4.17.15/lodash.min.js"></script>
    <script src="/script/url.js"></script>
    <script src="/script/script.js"></script>
</head>
<body>
<div class="menu_container">
    <ul class="menu">
        <li class="title menu_item">
            <div>
                <img src="image\logo.jpg" alt="Логотип"/>
                <span>Славные игрушки</span>
            </div>
        </li>
        <li class="menu_item"><a href="/">Главная</a></li>
        <li class="menu_item"><a href="stocks.jsp">Акции</a></li>
        <li class="menu_item"><a href="">Контакты</a></li>
        <li class="menu_item">Добро пожаловать, <sec:authentication property="principal.firstName"/>!</li>
        <a href="/logout" class="btn btn-outline-danger">Выйти</a>
    </ul>
</div>
<div class="main">
    <div class="search">
        <ul>
            <!--<li class="menu_right">-->
            <!--<label>Поиск: <input type="text" class="top_right"/></label>-->
            <!--</li>-->
        </ul>
    </div>
    <div class="content">
        <h1>Товары</h1>
        <div class="top_menu">
            <label for="sort">Сортировать:</label>
            <select id="sort" onchange="">
                <option value="default" <c:if test="${param.sort=='default'}">selected</c:if>>по умолчанию</option>
                <option value="name" <c:if test="${param.sort=='name'}">selected</c:if>>по имени</option>
                <option value="priceAsc" <c:if test="${param.sort=='priceAsc'}">selected</c:if>>по возрастанию цены</option>
                <option value="priceDesc" <c:if test="${param.sort=='priceDesc'}">selected</c:if>>по убыванию цены</option>
            </select>
            <sec:authorize access="hasAuthority('ADMIN')">
                <div>
                    <a class="btn-success btn create btn-lg" href="/create">Добавить товар</a>
                </div>
            </sec:authorize>
        </div>
        <div id="products">
        </div>
    </div>
</div>
<script type="text/html" id="product">
    <div class="tile">
        <h2><\%= title %></h2>
        <div class="image_box">
            <img src="<\%= imgUrl %>" class="image"/>
        </div>
        <div class="text"><\%= description %></div>
        <div>Артикул:<\%= vendorCode %></div>
        <div class="cost"><\%= price %> руб.</div>
        <sec:authorize access="hasAuthority('ADMIN')">
            <button class="btn btn-danger button" onclick="deleteProduct('<\%= id %>')">Удалить</button>
            <a class="btn btn-success button" href="/edit?id=<\%= id %>">Редактировать</a>
        </sec:authorize>
    </div>
</script>
</body>
</html>