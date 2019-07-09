function ajaxSubmit(targetFormId){
	var target = $("#"+targetFormId);
	var targetUrl = target.attr("action");
	var pArray = target.serializeArray();
	$.ajax({
	    type : "POST",
		url : targetUrl,
		data : pArray,
		dataType : 'json',
		success : function(result) {
			if (result.code == 0) {
				swal({
					title : "成功",
					type : "success"// error
				});
		   }else{
			   swal({
					title : result.msg,
					type : "error"// error
				});

			}
		}
	});
}