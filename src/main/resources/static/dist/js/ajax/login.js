$(document).ready(function () {
    $("#btn-login").click(function () {

        $("form").unbind("submit");
        $("form").submit(function (e) { 
            // Prevent page load when form submit
            e.preventDefault();
            let destination = "/admin/panel"

            $.ajax({
                type: "POST",
                url: $(this).attr("action"),
                data: $(this).serialize(),
                statusCode: {
                    403: function() {;
                        alertify.notify('Wrong username or password!', 'custom-error', 5);
                    },
                    200: function() {
                        $(location).attr("href", destination);
                    }           
                }
            });
        });
    });
});