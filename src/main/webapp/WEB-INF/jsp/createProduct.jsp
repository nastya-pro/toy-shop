<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Славные игрушки</title>
    <link rel="stylesheet" href="/create.css" type="text/css" media="screen"/>
    <jsp:useBean id="product" type="ru.rsreu.toy.shop.dto.ProductDto" scope="request"/>
</head>
<body>
<div>
    <h1>Создание товара</h1>
    <form method="post" action="/createProduct" class="form">
        <div class="line">
            <label for="title">Название товара</label>
            <input id="title" type="text" name="title" value="<c:out value="${product.title}"/>"/>
        </div>
        <div class="line">
            <label for="vendorCode">Артикул</label>
            <input id="vendorCode" type="text" name="vendorCode" value="<c:out value="${product.vendorCode}"/>"/>
        </div>
        <div class="line">
            <label for="description" class="text">Описание</label>
            <input id="description" type="text" name="description" value="<c:out value="${product.description}"/>"/>
        </div>
        <div class="line">
            <label for="imgUrl" class="image_box">Загрузить картинку</label>
            <input id="imgUrl" type="text" name="imgUrl" value="<c:out value="${product.imgUrl}"/>"/>
<!--            <input id="imgUrl" type="file" name="imgUrl" accept="image/*">-->
        </div>
        <div class="line">
            <label for="price">Стоимость</label>
            <input id="price" type="number" name="price" value="<c:out value="${product.price}"/>"/>
        </div>
        <input type="submit" class="create" value="Создать товар"/>
    </form>
</div>
</body>
</html>