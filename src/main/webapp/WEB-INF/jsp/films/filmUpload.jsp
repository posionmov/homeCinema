<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="../resources/css/film/index.css">
    </head>
    <body>
        <div class="container">
            <form method="POST" action="film/upload" enctype="multipart/form-data">
                <div class="custom-file mb-3">
                    <input type="file" class="custom-file-input" id="customFile" name="file" accept=".mp4">
                    <label class="custom-file-label" for="customFile">Select file for upload</label>
                    <input type="text" id="fileName" name="name" class="fileName">
                    <div class="form-group">
                        <label for="comment">Description:</label>
                        <textarea class="form-control" rows="5" id="comment" name="description"></textarea>
                    </div>
                    <input type="submit" class="btn btn-primary" value="Upload"/>
                </div>
            </form>
        </div>
        <script>
            $(".custom-file-input").on("change", function() {
                var fileName = $(this).val().split("\\").pop();
                $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
                $('#fileName').val(fileName);
            });

            $(".btn-primary").on("click", function () {
                location.reload(true);
            })
        </script>
    </body>
</html>