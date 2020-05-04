<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Авторизация</title>
        <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <form method="POST" action="/login" class="form-signin">
                <h2 class="form-heading">Login form</h2>
                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <span>${message}</span>
                    <input name="username" type="text" class="form-control" placeholder="login" autofocus="true"/>
                    <input name="password" type="password" class="form-control" placeholder="password"/>
                    <span>${error}</span>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sing in</button>
                    <h4 class="text-center">
                        <a href="${contextPath}/registration">Create account</a>
                    </h4>
                </div>
            </form>
        </div>
    </body>
</html>