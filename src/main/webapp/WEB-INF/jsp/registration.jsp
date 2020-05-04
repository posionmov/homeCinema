<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Create an account</title>
        <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    </head>
    <body>
        <div class="container">
            <form:form method="POST" modelAttribute="userForm" class="form-signin">
                <h2 class="form-signin-heading">Create new account</h2>
                <spring:bind path="username">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="username" class="form-control" placeholder="login" autofocus="true" minlength="3"/>
                        <form:errors path="username"/>
                    </div>
                </spring:bind>
                <spring:bind path="password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="password" class="form-control" placeholder="password" minlength="3"/>
                        <form:errors path="password"/>
                    </div>
                </spring:bind>
                <spring:bind path="passwordConfirm">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="passwordConfirm" class="form-control" placeholder="confirm password" minlength="3"/>
                        <form:errors path="passwordConfirm"/>
                    </div>
                </spring:bind>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sing in</button>
            </form:form>
        </div>
    </body>
</html>