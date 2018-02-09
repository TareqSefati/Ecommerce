$(document).ready(function () {

    $("#submit").on("click", function(event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();
        
//        var addUser = document.getElementById("addUser");
//        var fd = new FormData(addUser);
        //console.log(fd);
        
//        var str = $("form").serializeArray();
//        console.log(str);
//        console.log(JSON.stringify(str));

        var formData = {};
        formData["userId"] = null;
        formData["userFirstName"] = $("#firstName").val();
        formData["userLastName"] = $("#lastName").val();
        formData["userEmail"] = $("#email").val();
        formData["userPassword"] = $("#password").val();
        formData["userContactNumber"] = $("#contactNumber").val();
        formData["userStatus"] = $("#userStatus").val();
        
        formData["userBillingAddress"] = $("#billingAddress").val();
        formData["userBillingCity"] = $("#billingCity").val();
        formData["userBillingZipcode"] = $("#billingZipcode").val();
        formData["userBillingCountry"] = $("#billingCountry").val();
        
        formData["userShippingAddress"] = $("#shippingAddress").val();
        formData["userShippingCity"] = $("#shippingCity").val();
        formData["userShippingZipcode"] = $("#shippingZipcode").val();
        formData["userShippingCountry"] = $("#shippingCountry").val();
        
        formData["userCreatedOn"] = null;
        formData["userUpdatedOn"] = null;
        
        console.log(formData);
        

       // die();
    	$.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/admin/userManager/getUsers",
            //data: JSON.stringify(testData),
            data: formData,
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