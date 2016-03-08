var onInterestClick = function (_this) {
    var $this = $('select#intId');

    var address = '/interest/rest/' + $this.val() + '/member';

    $.post(address, function (result) {
        for (var x in result) {
            $('div#interest-relation').html();
            $('div#interest-relation').append('<p>' + result[x].name + '</p>');
        }
    });
};