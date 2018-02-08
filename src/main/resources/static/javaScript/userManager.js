$(document).ready(function () {

    $("#submit").on("click", function(event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

    	$.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/admin/userManager/getUsers",
            
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log("SUCCESS : ", data);

            },
            error: function (e) {
                console.log("ERROR : ", e);
            }
        });

    });

});