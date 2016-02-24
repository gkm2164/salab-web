members = {};

$(function () {
	$.post (SALab.rootPath + "/xmls/members.list.alumni.xml", function (response) {
		var $members = $(response);
		var $archives = $members.find("archive");
		var $first = $($archives[0]);
		var firstyear = $first.attr('year');
		
		$archives.each(function () {
			var litag = $('<li></li>');
			litag.attr('id', 'archive-' + $(this).attr('year'))
				 .addClass('archive-list')
				 .text($(this).attr('year'))
			     .click(function () {
			    	 members.archiveList.onClick(this);
			     });
			$("ul#archives-year").append(litag);
			
		});
		
		members.alumniXML = $members;

		
		//$('li#archive-' + firstyear).click();
	});
});

members.archiveList = {};
members.archiveList.onClick = function(year) {

	var currentYear = $(year).html();
	var archives = $(members.alumniXML)
						.find("archive[year=" + currentYear + "]");
	
	$('li.archive-list').css("font-weight", "normal");
	$(year).css("font-weight", "bold");
	
	$("div#name-card-target").html("");
	
	archives.each(function () {
		var $person = $(this).find('person');
		$person.each(function () {
			var namecard = $('<div></div>').addClass('name-card');
			var personal = $('<div></div>').addClass('name-card-personal');
			var personal_info = $('<div></div>').addClass('name-card-personal-info');
			var name = $('<span></span>').addClass('name-card-name');
			var currentwork = $('<span></span>').addClass('name-card-current-work');
			var interest = $('<span></span>').addClass('name-card-interest');
			var interest_h2 = $('<h2>Research Interests</h2>');
			var interest_ul = $('<ul></ul>');
			var career = $('<div></div>').addClass('name-card-career');
			var career_h2 = $('<h2>Publiations</h2>');
			var career_ul = $('<ul></ul>');
			
			name.html($(this).find('name').text());
			
			if ($(this).attr('link') != undefined) {
				var anchor = $('<a href="' + $(this).attr('link') + '"></a>');
				name = anchor.append(name);
			}
			
			currentwork.html($(this).find('current-works').text());
			
			var attachFunction = function (source, tag, appendTo) {
				var things = $(source).find(tag);
				var i = 0,
					imax = things.length;
				
				
				for (; i < imax; i++) {
					var li = $('<li></li>').html ($(things[i]).text());
					appendTo.append(li);
				}
			};
			
			attachFunction (this, 'interest', interest_ul);
			attachFunction (this, 'publication', career_ul);
			
			
			namecard.append(personal);
			namecard.append(career);
			personal.append(personal_info);
			personal_info.append(name);
			
			personal_info.append(currentwork);
			personal_info.append(interest);
			
			interest.append(interest_h2);
			interest.append(interest_ul);
			career.append(career_h2);
			career.append(career_ul);
			
			$('div#name-card-target').append(namecard);
		});
	});
	
	$('div#name-card-target').css('visibility', 'visible');
};
