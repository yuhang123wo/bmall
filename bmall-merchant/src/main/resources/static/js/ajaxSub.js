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

function dataSubmit(urls, params) {
  bootbox.confirm("确认操作？",function(result){
	  if(result){
	  $.ajax({
		type : "POST",
		url : urls,
		data : params,
		dataType : 'json',
		success : function(result) {
			if (result.code == 0) {
				swal({
					title : "成功",
					type : "success"// error
				});
			} else {
				swal({
					title : result.msg,
					type : "error"// error
				});

			}
		}
	});}
	})
}

function dataSubmitJSON(urls, params) {
	  bootbox.confirm("确认操作？",function(result){
		  if(result){
		  $.ajax({
			type : "POST",
			url : urls,
			data : params,
			contentType: "application/json;charset=utf-8",
			dataType : 'json',
			success : function(result) {
				if (result.code == 0) {
					swal({
						title : "成功",
						type : "success"// error
					});
				} else {
					swal({
						title : result.msg,
						type : "error"// error
					});

				}
			}
		});}
		})
	}
