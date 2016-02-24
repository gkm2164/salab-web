$(function() {
	var $li = $('li.event-list');
	$li.each(function () {
		$(this).click(function() {
			var index = $(this).attr('index');
			var call = "event-content-" + index;
			$("div.event-content").css({
				"display": "none",
				"visibility": "hidden"
			});
			
			$("div#" + call).css({
				"display": "block",
				"visibility": "visible"
			}).hide(0)
			  .show(100);
		});
	});
});