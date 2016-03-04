var onPubChange = function(_this) {
    var pubId = $(_this).val();

    var url = '/pubs/rest/' + pubId + '/authors';

    $.post(url, function(response) {
        $('div#author-list').html("");
        for (var x in response) {
            $('div#author-list').append(
                '<p> Author #' + x + ": " + response[x].name + '</p>'
            );
        }
    });
};
