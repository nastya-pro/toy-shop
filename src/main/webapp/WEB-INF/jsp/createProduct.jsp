<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Славные игрушки</title>
    <link rel="stylesheet" href="/create.css" type="text/css" media="screen"/>
    <jsp:useBean id="test" type="java.lang.String"/>
</head>
<body>
<div>
    <h1>Создание товара</h1>
    <h1><c:out value="${test}"/></h1>
    <form method="post" action="/createProduct" class="form">
        <div class="line">
            <label for="title">Название товара</label>
            <input id="title" type="text" name="title"/>
        </div>
        <div class="line">
            <label for="vendorCode">Артикул</label>
            <input id="vendorCode" type="text" name="vendorCode"/>
        </div>
        <div class="line">
            <label for="description" class="text">Описание</label>
            <input id="description" type="text" name="description"/>
        </div>
        <div class="line">
            <label for="imgUrl" class="image_box">Загрузить картинку</label>
            <input id="imgUrl" type="text" name="imgUrl"/>
<!--            <input id="imgUrl" type="file" name="imgUrl" accept="image/*">-->
        </div>
        <div class="line">
            <label for="price">Стоимость</label>
            <input id="price" type="number" name="price"/>
        </div>
        <input type="submit" class="create" value="Создать товар"/>
    </form>
</div>
</body>
</html>