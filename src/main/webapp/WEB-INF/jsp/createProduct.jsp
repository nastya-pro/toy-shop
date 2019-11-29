<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Славные игрушки</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/style/create.css" type="text/css" media="screen"/>
    <jsp:useBean id="product" type="ru.rsreu.toy.shop.dto.ProductDto" scope="request"/>
</head>
<body>
<div>
    <h1>Создание товара</h1>
    <form method="post" action="/createProduct" class="form">
        <c:if test="${product.id!=null}">
            <input type="hidden" name="id" value="<c:out value="${product.id}"/>"/>
        </c:if>
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
            <input id="price" type="number" name="price" value="
<c:if test="${product.price>=0}">
    <c:out value="${product.price}"/>
</c:if>
"/>
        </div>
        <input type="submit" class="create" value="
<c:if test="${product.id==null}">Создать товар</c:if>
<c:if test="${product.id!=null}">Изменить товар</c:if>
"/>
    </form>
</div>
</body>
</html>