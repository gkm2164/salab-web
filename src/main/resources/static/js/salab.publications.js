$(function () { $.extend(SALab.Publications, {
	/* read bibliograhy */
	readFromWeb: function(DOI) {
		var ret = $.ajax ({
			type: 'GET',
			async: false,
			url: "http://dx.doi.org/" + DOI,
			headers: {
				"Accept": "text/bibliography; style=bibtex"
			},
		}).responseText;
		
		alert (ret);
		return ret;
	},
	/*Book
		Author(s). Book title. Location: Publishing company, year, pp. 
		Example: */
	getReferenceStyle: function (DOI, styleName) {
		request.setCharacterEncoding("UTF-8");
		var ret;
		var ajaxRet = readFromWeb (DOI);
		alert (ajaxRet);
	}
});});