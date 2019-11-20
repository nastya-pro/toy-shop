<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Славные игрушки</title>
    <link rel="stylesheet" href="style.css" type="text/css" media="screen"/>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/lodash@4.17.15/lodash.min.js"></script>
    <script src="script.js"></script>
</head>
<body>
<div class="menu_container">
    <ul class="menu">
        <li class="title menu_item">
            <div>
                <img src="img\logo.jpg" alt="Логотип"/>
                <span>Славные игрушки</span>
            </div>
        </li>
        <li class="menu_item"><a href="../../../../resources/static/index.html">Главная</a></li>
        <li class="menu_item"><a href="stocks.html">Акции</a></li>
        <li class="menu_item"><a href="">Контакты</a></li>
        <li class="menu_item"><a href="entrance.html">Авторизация</a></li>
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
        <div id="products">
            <div class="tile">
              <h2>Мишка</h2>
              <div class="image_box">
                  <img src="img\Мишка.jpg" class="image"/>
              </div>
              <div class="text"> Милый плюшевый мишка станет лучшим другом вашему ребенку.</div>
              <div>Артикул:023498</div>
              <div class="cost">1700 руб.</div>
              <button class="a_button delete">Удалить</button>
              <button class="a_button edit">Редактировать</button>
          </div>
            <!--<div class="tile">
                <h2>Пикачу</h2>
                <div class="image_box">
                    <img src="img\Пикачу.jpg" class="image"/>
                </div>
                <div class="text"> Детектив Пикачу поможет найти сладости и конечно же кофе.</div>
                <div>Артикул:190384</div>
                <div class="cost">987 руб.</div>
                <button class="a_button delete">Удалить</button>
                <button class="a_button edit">Редактировать</button>
            </div>
            <div class="tile">
                <h2>Пингвинёнок</h2>
                <div class="image_box">
                    <img src="img\Пингвинёнок.jpg" class="image"/>
                </div>
                <div class="text"> Мягкий пингвинёнок скрасит холодные и грустные вечера.</div>
                <div>Артикул:193278</div>
                <div class="cost">1500 руб.</div>
                <button class="a_button delete">Удалить</button>
                <button class="a_button edit">Редактировать</button>
            </div>
            <div class="tile">
                <h2>Крот</h2>
                <div class="image_box">
                    <img src="img\Крот.jpg" class="image"/>
                </div>
                <div class="text"> Все же помнят этого замечательного Крота? Как его не взять к себе домой?</div>
                <div>Артикул:075683</div>
                <div class="cost">1200 руб.</div>
                <button class="a_button delete">Удалить</button>
                <button class="a_button edit">Редактировать</button>
            </div>
            <div class="tile">
                <h2>Панда</h2>
                <div class="image_box">
                    <img src="img\Панда.jpg" class="image"/>
                </div>
                <div class="text"> Все панды милые и смешные.</div>
                <div>Артикул:038394</div>
                <div class="cost">2200 руб.</div>
                <button class="a_button delete">Удалить</button>
                <button class="a_button edit">Редактировать</button>
            </div> -->
        </div>
    </div>
</div>

<%--<script type="text/html" id="product">--%>
<%--    <div class="tile">--%>
<%--        <h2><%= title %></h2>--%>
<%--        <div class="image_box">--%>
<%--            <img src="<%= imgUrl %>" class="image"/>--%>
<%--        </div>--%>
<%--        <div class="text"><%= description %></div>--%>
<%--        <div>Артикул:<%= vendorCode %></div>--%>
<%--        <div class="cost"><%= price %> руб.</div>--%>
<%--        <button class="a_button delete" onclick="deleteProduct('<%= id %>')">Удалить</button>--%>
<%--        <button class="a_button edit">Редактировать</button>--%>
<%--    </div>--%>
<%--</script>--%>
</body>
</html>