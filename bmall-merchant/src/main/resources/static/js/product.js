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
		var m = "<div>";
		for (var i = 0; i < props.length; i++) {
			var pps = props[i].data.split(",");
			m += "<div class='form-group'>";
			m += "<label class='control-label col-xs-12 col-sm-4 no-padding-right'>"
					+ props[i].name + "</label>";
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
		}
		m += "</div>";
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
			m += "<label class='control-label col-xs-12 col-sm-3 no-padding-right'>"+attrs[i].name+"</label>";
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
	m += "<table id='sample-table-1'	class='table table-striped table-bordered table-hover'>";
	m += "<tbody>";
	m += "</tbody>";
	m += "</table>";
	m += "</div>";
	m += "</div>";
	$("#step4").append(m);
    
}