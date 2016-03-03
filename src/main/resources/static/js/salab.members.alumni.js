$(function () {
	$.post("/member/rest/alumni", function (response) {

	});
});

var alumniFill = function(year) {
	var address = "/member/alumni/" + year;
	$.post(address, function (response) {
		$('#name-card-target').html(response);
	});
};