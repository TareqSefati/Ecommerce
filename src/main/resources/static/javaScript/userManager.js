$(document).ready(function () {

    $("#submit").on("click", function(event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();
        var addUser = document.getElementById("addUser");
        var fd = new FormData(addUser);
        //console.log(fd);
        var str = $("form").serialize();
        console.log(str);
        console.log(JSON.stringify(str));
       // die();
    	$.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/admin/userManager/getUsers",
            //data: JSON.stringify(str),
            data: str,
            processData: false,
            contentType: false,
           
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