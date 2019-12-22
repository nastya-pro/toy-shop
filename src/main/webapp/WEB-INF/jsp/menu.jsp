<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" href="/style/menu.css" type="text/css" media="screen"/>
<div class="menu_container">
    <div class="menu">
        <a href="/" class="title">
            <img src="image\logo.jpg" alt="Логотип"/>
            <span>Славные игрушки</span>
        </a>
        <div class="right_menu">
            <span class="right_menu_item username">Добро пожаловать, <sec:authentication property="principal.firstName"/>!</span>
            <a href="/logout" class="btn btn-outline-danger logout">Выйти</a></span>
        </div>
    </div>
</div>