var $curs = {};
$(function() {
	var param = {};
	query(param);
});
function query(params) {
	var targetUrl = $('#searchForm').attr("url");
	$curs = params;

	console.log($curs);
	$.ajax({
		type : "GET",
		url : targetUrl,
		data : params,
		dataType : 'json',
		success : function(result) {
			$('#myData').empty();
			var template = Handlebars.compile($("#dataTemplate").html());
			var $tr = template(result.data);
			$('#myData').append($tr);
			new Page({
				id : 'pagination',
				pageTotal : result.data.total, // 必填,总页数
				pageAmount : result.data.size, // 每页多少条
				dataTotal : result.data.total, // 总共多少条数据
				curPage : result.data.current, // 初始页码,不填默认为1
				pageSize : result.data.pages, // 分页个数,不填默认为5
				showPageTotalFlag : true, // 是否显示数据统计,不填默认不显示
				showSkipInputFlag : true, // 是否支持跳转,不填默认不显示
				getPage : function(page) {
					$curs.pageNo = page;
					query($curs);
				}
			})
		}
	});
}

function jumpPage(page) {
	$curs.pageNo = page;
	query($curs);
}

function startQuery() {
	var pArray = $('#searchForm').serializeArray();
	var params = {};
	for(var i = 0;i < pArray.length;i++){
		if($.trim(pArray[i].value) != ''){
			params[pArray[i].name] = pArray[i].value;
		}
	}
	query(params);
}