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
    
    //***Pop up editing form with populated data
    $(document).on('click','.table .eBtn', function(event){
    	event.preventDefault();
    	var href = $(this).attr('href');
    	//console.log(href);
    	jQuery.get(href, function(user, status){
    		//console.log(user.userFirstName);
    		$('.myForm #userId').val(user.userId);
    		//console.log(user.userId);
    		$('.myForm #userFirstName').val(user.userFirstName);
    		$('.myForm #userLastName').val(user.userLastName);
    		$('.myForm #userEmail').val(user.userEmail);
    		$('.myForm #userContactNumber').val(user.userContactNumber);
    		if(user.userStatus == 'active'){
    			$('.myForm select').val('active');
    		}else{
    			$('.myForm select').val('inactive');
    		}
    		$('.myForm #userBillingAddress').val(user.userBillingAddress);
    		$('.myForm #userBillingCity').val(user.userBillingCity);
    		$('.myForm #userBillingZipcode').val(user.userBillingZipcode);
    		$('.myForm #userBillingCountry').val(user.userBillingCountry);

    		$('.myForm #userShippingAddress').val(user.userShippingAddress);
    		$('.myForm #userShippingCity').val(user.userShippingCity);
    		$('.myForm #userShippingZipcode').val(user.userShippingZipcode);
    		$('.myForm #userShippingCountry').val(user.userShippingCountry);
    	});
//    	
    	$('.myForm #addUserModal').modal();
    });
    
    //ajax login
    //working on it
    $('#loginForm #submit').on('click', function(event){
    	event.preventDefault();
    	$.ajax({
    		type: "POST",
    		contentType: "application/json",
            url: "/admin/userManager/getUsers",
    	});
    });
    
    //***ajax pagination
    $(document).on('click','#pNav .pNavLink', function(event){
    	event.preventDefault();
    	var clickedPage = $(this).data("page");
    	$.ajax({
    		type: "GET",
    		contentType: "application/json",
    		url: "/admin/userManagerAjax",
    		data: {
    			page: clickedPage
    		},
    		success: function(result){
    			console.log(result);
    			var userList = result.pageUser.content;
    			console.log(userList);
    			var str = "";
    			for(let i=0; i<userList.length; i++){
    				let obj = userList[i];
    				console.log(obj);
    				//$('#tBody').empty();
    				str += "<tr id='user-"+obj.userId+"'>" +
    						"<th scope='row'>"+obj.userId+"</span></th>" +
    						"<td>"+obj.userFirstName+"</td>" +
    						"<td>"+obj.userLastName+"</td>" +
    						"<td>"+obj.userEmail+"</td>" +
    						"<td>"+obj.userContactNumber+"</td>" +
    						"<td>"+obj.userStatus+"</td>" +
    						   
    						"<td>"+obj.userBillingAddress+"</td>" +
    						"<td>"+obj.userBillingCity+"</td>" +
    						"<td>"+obj.userBillingZipcode+"</td>" +
    						"<td>"+obj.userBillingCountry+"</td>" +
    						   
    						"<td>"+obj.userShippingAddress+"</td>" +
    						"<td>"+obj.userShippingCity+"</td>" +
    						"<td>"+obj.userShippingZipcode+"</td>" +
    						"<td>"+obj.userShippingCountry+"</td>" +
    						   
    						"<td>"+new Date(obj.userCreatedOn)+"</td>" +
    						"<td>"+new Date(obj.userUpdatedOn)+"</td>" +
    						
    						"<td>" +
    							"<a class='btn btn-sm btn-info eBtn'" +
    							"href='/getUserById/?userId="+obj.userId+"'>Update </a>" +
    							"<p><a href='/deletingUser/"+obj.userId+"'" +
    							"class='btn btn-sm btn-danger'> Delete </a></p>"+
    						
    						+"</td>" +
    						
    						"</tr>";
    				
    			}
    			//console.log(result.currentPage);
    			//var p = result.pageUser.totalPages;
//    			console.log(isNaN(p));
//    			var navStr = "<ul class='pagination justify-content-center'>" +
//    					"<li class='page-item'" +
//    					"th:each='i : ${#numbers.sequence(0,2)}'" +
//    					"th:classappend=\" ${"+result.currentPage+"}==${i}?'active':''\"><a" +
//    					"class='page-link pNavLink' th:href='@{/admin/userManager/(page=${i})}' th:data-page='${i}'" +
//    					"th:text='${i}'> </a></li>" +
//    					"</ul>";
    			
//    			var pillStr = "<ul class=\"pagination justify-content-center\"> " +
//		    					"<li class=\"page-item\" th:each=\"i : ${#numbers.sequence(0,"+p+")}\" th:classappend=\"${currentPage}==${i}?'active':''\">" +
//		    						"<a class=\"page-link pNavLink\" th:href=\"@{/admin/userManager/(page=${i})}\" th:data-page=\"${i}\" th:text=\"${i}\"> </a>" +
//		    					"</li>" +
//		    				  "</ul>";
//    			
    			//$(this).addClass('active');
    			$('#tBody').html(str);
    			//$('.card #pNav').html(pillStr);
    			
    			//$('#pNav').empty();
    			//***Highlight active pagination
    			for(let i=0; i<result.pageUser.totalPages; i++){
    				if(i == clickedPage){
    					$("#pNav #nav-"+i+"").addClass("active");
    				}else{
    					$("#pNav #nav-"+i+"").removeClass("active");
    				}
    			}
    			
    		},
    		error: function(e){
    			console.log("ERROR: ",e);
    		}
    	});
    });
    
    //***Update a user using Ajax
    $('.myForm #update').on('click', function(event){
    	event.preventDefault();
    	//alert("updated");
    	//$('input').next().remove();
    	var updatingUser = $('form[name=updateUser]').serializeArray();
    	//var updateUser = document.getElementById("updateUser");
    	//var fd = new FormData(addUser);
    	var id = $("#userId").val();
    	console.log(id);
    	console.log("Updating User", updatingUser);
    	
    	$.ajax({
    		type: "POST",
    		url: "/update",
    		data : $('form[name=updateUser]').serialize(),
    		success: function(result){
//    			console.log("SUCCESS", result);
//    			var updatedUser = "";
//    			$('#tBody #user-'+id).html(updatedUser);
    			if(result.validated){
    				console.log("SUCCESS", result.user);
    			}else{
    				//Setting error messages
    				console.log("SUCCESS BUT ERROR");
    				$.each(result.errorMessages,function(key,value){
    					if(key != "userId" || key != "userPassword" || key != "userCreatedOn" || key != "userUpdatedOn"){
    						$('input[name='+key+']').after('<span class="text-danger">'+value+'</span>');
    						//$('input[name='+key+']').after( '<span class="text-danger" th:if="${#fields.hasErrors('+key+')}" th:errors="*{'+value+'}"></span>)');
    					}
					});
    			}
    			
    		},
    		error: function(e){
    			console.log("ERROR: ", e);
    		}
    	});
    });

});


