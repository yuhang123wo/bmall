$(function() {
	$('.time-item').each(function() {
		laydate.render({
			elem : this,
			trigger : 'click'
		});
	});
})