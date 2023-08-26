$(document).ready(function() {
	//alert("hello jquery")


	$('.btn-xoa').click(function() {

		var id = $(this).attr("id-role")
		//alert("hello xóa"+id)
		var This = $(this)
		$.ajax({
			method: "GET",
			url: "http://localhost:8080/CRM_project_22/api/role/delete?id=${id}", //string template
			//data: { name: "John", location: "Boston" }
		})
			.done(function(result) {
				console.log(result, " data ", result.data)
				if (result.data == true) {
					//This.parent().parent.remove()
					This.closest('tr').remove();
				}
			});
	})


})