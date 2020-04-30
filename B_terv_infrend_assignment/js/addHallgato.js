jQuery(document).ready(function () {
    jQuery.getJSON("hallgatoNevek", function (data) {
        var select = jQuery('<select name="hallgato" required = "required"></select>');
        jQuery.each(data, function (key, value) {
            var option = jQuery('<option value="' + value + '">' + value + '</option>');
            select.append(option);
        });
        jQuery(".select").append(select);
    });
});

jQuery(function () {
    jQuery('form').on('submit', function (submit) {
        submit.preventDefault();

        jQuery.ajax( {
            type: 'post', url: 'addHallgato', data: jQuery('form').serialize(), success: function () {
                confirm("Hozzáadva az adatbázishoz")

            },
            error: function () {
                window.alert("Nem sikerült felvinni az adatbázisba valamiért.")
            }
        })
    })
});