<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="../resources/css/film/index.css">
        <script src="../resources/js/film/index.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <h2>List of films</h2>
            <input type="text" class="form-control" id="numFilter" placeholder="search in all fields"/>
            <table class="table table-hover">
                <colgroup>
                    <col span="1" style="width: 10%;">
                    <col span="1" style="width: 10%;">
                    <col span="1" style="width: 10%;">
                    <col span="1" style="width: 10%;">
                    <col span="1" style="width: 40%;">
                </colgroup>
                <thead>
                    <tr>
                        <th>№</th>
                        <th>Name</th>
                        <th>Film date</th>
                        <th>Owner</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${filmList}" var="item">
                    <tr class="data">
                        <td class="fileId">${item.id}</td>
                        <td>${item.filmName}</td>
                        <td><fmt:formatDate value="${item.filmDate}" pattern="yyyy-MM-dd"/></td>
                        <td>${item.uploader}</td>
                        <td>
                            <textarea class="txtArea form-control " rows="5" readonly>${item.description}</textarea>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <script>
            $("table tr.data").click(function() {
                var value = $(this).find('td.fileId').html();
                <c:set var="filePath" value="${pageContext.request.contextPath}"/>
                window.location.replace("${contextPath}/film/view?filmId=" + value)
            });
            $(document).ready(function() {
                $("#numFilter").on("keyup", function() {
                    var value = $(this).val().toLowerCase();
                    if (value.length === 0 || value.length > 2) {
                        $("table tr.data").filter(function() {
                            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                        });
                    }
                });
            });
        </script>
    </body>
</html>