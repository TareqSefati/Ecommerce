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
        formData["userFirstName"] = $("#userFirstName").val();
        formData["userLastName"] = $("#lastName").val();
        formData["userEmail"] = $("#email").val();
        formData["userPassword"] = $("#password").val();
        formData["userContactNumber"] = $("#contactNumber").val();
        //formData["userStatus"] = $("#userStatus").val(); //not working code
        formData["userStatus"] = $('input[name=userStatus]:checked').val(); //works fine
        //formData["userStatus"] = $('form input[type=radio]:checked').val(); //works fine
        
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
        console.log(JSON.stringify(formData));

       // die();
    	$.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/admin/userManager/getUsers",
            //data: JSON.stringify(testData),
            data: JSON.stringify(formData),
            processData: false,
           // contentType: false,
           
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log("SUCCESS : ", data.userFirstName);

            },
            error: function (e) {
                console.log("ERROR : ", e);
            }
        });

    });
    
    $('.table .eBtn').on('click', function(event){
    	event.preventDefault();
    	var href = $(this).attr('href');
    	
    	jQuery.get(href, function(user, status){
    		$('.myForm #userFirstName').val(user.userFirstName);
    	});
    	
    	$('.myForm #addUserModal').modal();
    });

});