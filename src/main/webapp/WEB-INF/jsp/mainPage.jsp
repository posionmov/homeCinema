<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="../resources/css/main/main.css">
        <script src="../resources/js/main/index.js" type="text/javascript"></script>
    </head>
    <body class="body">

    <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="navRoute()">&times;</a>
        <h2 class="sideUsername">${pageContext.request.userPrincipal.name}</h2>
        <a href="#" onclick="onBarClick('list')">Список фильмов</a>
        <a href="#" onclick="onBarClick('upload')">Добавить фильм</a>
        <a href="#" onclick="onChatClick()">Открыть чат</a>
        <a href="#" onclick="document.forms['logoutForm'].submit()">Выйти</a>
    </div>
    <div id="main">
        <span class="elemSpan" onclick="navRoute()">&#9776; Меню</span>
        <div id="menu.items" class="menuItems">
            <c:forEach items="${pages}" var="item">
                <div class="menuElem" id="${item.key}">
                    <c:import url="${contextPath}${item.value}" />
                </div>
            </c:forEach>
        </div>
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
    <script>
        $(document).ready(function() {
            $("#list").css("display", "initial");
        });
    </script>
    </body>
</html>