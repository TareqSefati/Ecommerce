$(document).ready(function () {

    $("#cancel").on("click", function() {

        //stop submit the form, we will post it manually.
        //event.preventDefault();

    	$.ajax({
            type: "GET",
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