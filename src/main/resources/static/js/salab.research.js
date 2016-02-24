$(function () {
	$.extend(SALab.Research, {
		showFieldDesc: function (link) {
			var fieldID = $(link).attr('id');
			var attach = $("explain-field#" + fieldID).html();
			$("#research-explain-field").html(attach);
		}
	});
	
	document.createElement("explain-field");
	this.actor = SALab.Research;
});