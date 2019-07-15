$(function() {
	$('.time-item').each(function() {
		laydate.render({
			elem : this,
			trigger : 'click'
		});
	});
})

function initCate(selectId, data) {
	$("#" + selectId).append("<option value=''>请选择</option>");
	for (var i = 0; i < data.length; i++) {
		var m = data[i];
		$("#" + selectId).append(
				"<option value=" + m.id + ">" + m.name + "</option>");
		for (var j = 0; j < m.list.length; j++) {
			var n = m.list[j];
			$("#" + selectId).append(
					"<option value=" + n.id + ">&nbsp;&nbsp;&nbsp;" + n.name
							+ "</option>");
			for (var k = 0; k < n.list.length; k++) {
				var z = n.list[k];
				$("#" + selectId)
						.append(
								"<option value="
										+ z.id
										+ ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
										+ z.name + "</option>");
			}
		}
	}
}

function initUpload(id,uploadUrl) {
	var $list = $("#"+id); // 这几个初始化全局的百度文档上没说明，好蛋疼
	var thumbnailWidth = 100; // 缩略图高度和宽度
								// （单位是像素），当宽高度是0~1的时候，是按照百分比计算，具体可以看api文档
	var thumbnailHeight = 100;
	var uploader = WebUploader.create({
		// 选完文件后，是否自动上传。
		auto : true,
		// swf文件路径
		swf : '/webuploader-0.1.5/uploader.swf', // 加载swf文件，路径一定要对
		// 文件接收服务端。
		server : uploadUrl,
		// 选择文件的按钮。可选。
		// 内部根据当前运行是创建，可能是input元素，也可能是flash.
		pick : '#filePicker',
		// 只允许选择图片文件。
		accept : {
			title : 'Images',
			extensions : 'gif,jpg,jpeg,bmp,png',
			mimeTypes : 'image/'
		}
	});
	// 上传完成事件监听
//	uploader.on('fileQueued', function(file) {
//		var $li = $('<div id="' + file.id + '" class="file-item thumbnail">'
//				+ '<img>' + '<div class="info">' + file.name + '</div>'
//				+ '</div>'), $img = $li.find('img');
//		$list.append($li);
//		uploader.makeThumb(file, function(error, src) {
//			if (error) {
//				$img.replaceWith('<span>不能预览</span>');
//				return;
//			}
//		  $img.attr('src', src);
//		}, thumbnailWidth, thumbnailHeight);
//	});
	uploader.on( 'uploadSuccess', function( file,response ) {
		    if(response.code ==0){
		    	 $("#img").attr("src",response.data);
		    	 $("#imgPath").attr("value",response.data);
		    }else{
		    	 swal({
						title : "上传失败",
						type : "error"// error
					});
		    }
	 });
}
