$(function() {
	$('#categoryId').change(function() {
		var v = $(this).val();
		 $.ajax({
				type : "GET",
				url : "/product/getProductPros",
				data : {categoryId:v},
				dataType : 'json',
				success : function(result) {
					if (result.code == 0) {
						var data = result.data;
						setBrand(data.brands,data.cateBrands);
						setProps(data.props);
						setAttr(data.attrs);
						setSpec(data.specs);
						
					}  
				}
		})

	});
})

function setBrand(brands, cateBrand) {
	$("#brandId").empty();
	if (cateBrand.length > 0) {
		$("#brandId").append("<option value=''>请选择</option>");
		for (var i = 0; i < cateBrand.length; i++) {
			var m = cateBrand[i];
			for (var k = 0; k < brands.length; k++) {
				if (m.brandId == brands[k].id) {
					$("#brandId").append(
							"<option value=" + brands[k].id + ">" + brands[k].name
									+ "</option>");
				}
			}
		}
	}
}

function setProps(props) {
	$("#step2d").empty();
	if (props.length > 0) {
		var m="";
		for (var i = 0; i < props.length; i++) {
			var pps = props[i].data.split(",");
			m += "<div class='props'><div class='form-group'>";
			m += "<label class='control-label col-xs-12 col-sm-4 no-padding-right'>"
					+ props[i].name + "<input type='hidden' value="+props[i].id+"></input></label>";
			m += "</div>";
			for (var j = 0; j < pps.length; j++) {
				m += "<div class='form-group'>";
				m += "<label class='control-label col-xs-12 col-sm-3 no-padding-right'>"+pps[j]+":</label>";
				m += "<div class='col-xs-12 col-sm-6'>";
				m += "<div class='clearfix'>";
				m += "<input class='col-xs-12 col-sm-6' type='text'></input>";
				m += "</div>";
				m += "</div>";
				m += "<div class='col-xs-12 col-sm-3'>";
				m += "<div class='clearfix'>";
				m += "添加 删除</div></div>";
				m += "</div>";
			}
			m+="</div>";
		}
		$("#step2d").append(m);
	}

}

function setAttr(attrs) {
	$("#step3>div").empty();
	if (attrs.length > 0) {
		var m = "<div>";
		for (var i = 0; i < attrs.length; i++) {
			var attr = attrs[i].data.split(",");
			m += "<div class='form-group'>";
			m += "<label class='control-label col-xs-12 col-sm-3 no-padding-right'>"+attrs[i].name+"<input type='hidden' value="+attrs[i].id+"></input></label>";
			m += "<div class='col-xs-12 col-sm-9'>";
			m += "<div class='clearfix'>";
			m += "<select class='col-xs-12 col-sm-3' name='categoryId'>";
			m+="<option>请选择</option>";
			for (var j = 0; j < attr.length; j++) {
				m+="<option>"+attr[j]+"</option>";
			}
			m += "</select>";
			m += "</div>";
			m += "</div>";
			m += "</div>";
		}
		m += "</div>";
		$("#step3>div").append(m);
	}
}

function setSpec(specs) {
	$("#step4>div").empty();
	if (specs.length > 0) {
		var m = "<div>";
		for (var i = 0; i < specs.length; i++) {
			var spec = specs[i].data.split(",");
			m += "<div class='form-group'>";
			m += "<label class='col-sm-3 control-label no-padding-right'>"+specs[i].name+"</label>";
			m += "<div class='col-sm-9'>";
			for (var j = 0; j < spec.length; j++) {
			 m += "<label  class='col-sm-2'>";
			 m += "<input name='brand' type='checkbox' class='ace' onclick='getCheck()' value="+spec[j]+">";
			 m += "<span class='lbl'>"+spec[j]+" </span>";
			 m += "</label>";
			}
			m += "</div>";
			m += "</div>";
		}
		m += "</div>";
		$("#step4>div").append(m);
	}
}

function getCheck() {
	var ary = new Array();
	var i=0;
	$("#step4").find("div[class='form-group']").each(function() {
		var siz = $(this).find("input:checkbox:checked").length;
		if (siz > 0) {
			ary[i] = new Array();
			$(this).find("input:checkbox:checked").each(function(j) {
				ary[i][j] = $(this).val();
			});
			i++;
		}
	})
	$("#step4").find("div[class='row']").empty();
	var m="<div class='row'>";
	m += "<div class='col-xs-12'>";
	var len=0;
	if(ary.length>0){
	m += "<table  id='step4data' class='table table-striped table-bordered table-hover'>";
	m += "<tbody><tr><th width='30%'>SKU</th><th width='10%'>商品价格</th><th width='10%'>市场价</th><th width='10%'>库存</th><th width='40%'>图片</th></tr> ";
	let allArr =cartesianProductOf(...ary);
	len = allArr.length;
	for (var i = 0 ; i < allArr.length; i++) {
		m += "<tr>";
		m += "<td>" + allArr[i] + "</td>";
		m += "<td><input type='text'></input></td>";
		m += "<td><input type='text'></input></td>";
		m += "<td><input type='text'></input></td>";
		m += "<td><div class='col-xs-12' id=fileList"+i+"><img class='col-xs-3' name='img' width='40px;' height='40px;'><input type='hidden' name='logo'><div class='col-xs-6' style='padding: 0px;' id='filePicker"+i+"'>选择</div></div></td>";
		m += "</tr>";
	     }
	m += "</tbody>";
	}
	m += "</table>";
	m += "</div>";
	m += "</div>";
	$("#step4").append(m);
	for (var i = 0 ; i < len; i++) {
		 initUpload("filePicker"+i,"fileList"+i,"/upload/fileUpload");
	}
	
	
}


function cartesianProductOf() {
	return Array.prototype.reduce.call(arguments, function(a, b) {
		var ret = [];
		a.forEach(function(a) {
			b.forEach(function(b) {
				ret.push(a.concat([ b ]));
			});
		});
		return ret;
	}, [ [] ]);
}