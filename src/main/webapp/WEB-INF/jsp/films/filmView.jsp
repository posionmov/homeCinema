<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="../resources/css/film/index.css">
    </head>
    <body class="body">
        <div class="container">
            <button type="button" class="btn btn-primary btn-lg btn-block btnBack">Back to main</button>
            <div class="content-wrapper btnBack">
                <section class="content">
                    <div class="container">
                        <div class="row align-items-center justify-content-center">
                            <video width="700" height="280" controls>
                                <source src="byterange?filmId=<%= request.getParameter("filmId") %>" type="video/mp4">
                            </video>
                        </div>
                    </div>
                </section>
            </div>
            <div class="form-group">
                <label for="usr">Film name:</label>
                <input type="text" class="form-control" id="usr" value="${name}" readonly>
            </div>
            <div class="form-group">
                <label for="comment">Description:</label>
                <textarea class="txt-area form-control" rows="5" id="comment" readonly>"${description}"</textarea>
            </div>
        </div>
        <script>
            $("button").click(function () { window.location.replace("/") });
        </script>
    </body>
</html>