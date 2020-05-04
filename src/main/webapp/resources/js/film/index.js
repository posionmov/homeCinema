$(".custom-file-input").on("change", function() {
    var fileName = $(this).val().split("\\").pop();
    $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    $('#fileName').val(fileName);
});

$(".btn-primary").on("click", function () {
    location.reload(true);
})