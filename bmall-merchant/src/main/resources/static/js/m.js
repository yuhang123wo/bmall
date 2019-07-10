$(function() {
	$('.time-item').each(function() {
		laydate.render({
			elem : this,
			trigger : 'click'
		});
	});
})

function initCate(selectId,data){
		 $("#"+selectId).append("<option value=''>请选择</option>"); 
	    	for(var i=0;i<data.length;i++){
	    		var m = data[i];
	    	     $("#"+selectId).append("<option value="+m.id+">"+m.name+"</option>"); 
	    		 for(var j=0;j<m.list.length;j++){
	    			 var n = m.list[j];
	    			 $("#"+selectId).append("<option value="+n.id+">&nbsp;&nbsp;&nbsp;"+n.name+"</option>"); 
	    			 for(var k=0;k<n.list.length;k++){
	        			 var z = n.list[k];
	        			 $("#"+selectId).append("<option value="+z.id+">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+z.name+"</option>"); 
	        		 }
	    		 }
	    	}
} 

