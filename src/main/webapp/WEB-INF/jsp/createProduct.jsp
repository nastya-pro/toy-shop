<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Славные игрушки</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/style/create.css" type="text/css" media="screen"/>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <jsp:useBean id="product" type="ru.rsreu.toy.shop.dto.ProductDto" scope="request"/>
</head>
<body>
<%@include file="menu.jsp"%>
<div class="main">
    <h3 class="header"><c:if test="${product.id==null}">Создание товара</c:if><c:if
            test="${product.id!=null}">Обновление товара</c:if></h3>
    <div class="form">
        <form method="post" enctype="multipart/form-data"
              action="<c:if test="${product.id==null}">/createProduct</c:if><c:if test="${product.id!=null}">/updateProduct</c:if>">
            <c:if test="${product.id!=null}">
                <input type="hidden" name="id" value="<c:out value="${product.id}"/>"/>
            </c:if>
            <div class="form-group">
                <label for="title">Название товара</label>
                <input id="title" type="text" name="title" class="form-control form-control-lg"
                       value="<c:out value="${product.title}"/>" required/>
            </div>
            <div class="form-group">
                <label for="vendorCode">Артикул</label>
                <input id="vendorCode" type="text" name="vendorCode" class="form-control form-control-lg"
                       value="<c:out value="${product.vendorCode}"/>" required/>
            </div>
            <div class="form-group">
                <label for="description">Описание</label>
                <input id="description" type="text" name="description" class="form-control form-control-lg"
                       value="<c:out value="${product.description}"/>" required/>
            </div>
            <div class="form-group">
                <label for="imgUrl">Загрузить картинку</label>
                <div class="custom-file">
                    <label for="imgUrl" class="custom-file-label">Загрузить картинку</label>
                    <input id="imgUrl" class="custom-control-input" type="file" name="img" accept="image/*"<c:if test="${product.id==null}"> required</c:if>>
                </div>
            </div>
            <div class="form-group">
                <label for="price">Стоимость</label>
                <input id="price" type="number" name="price" class="form-control form-control-lg"
                       value="<c:if test="${product.price>=0}"><c:out value="${product.price}"/></c:if>" required/>
            </div>
            <input type="submit" class="btn btn-success btn-lg btn-block"
                   value="<c:if test="${product.id==null}">Создать товар</c:if><c:if test="${product.id!=null}">Изменить товар</c:if>"/>
        </form>
    </div>
</div>
</body>
</html>