jQuery(document).ready(function () {
    jQuery.getJSON('oktatoNevek', function (data) {
        var select = jQuery('<select id="selector"></select>');
        var optionAll = jQuery('<option value="all">All</option>');
        select.append(optionAll);
        jQuery.each(data, function (key, value) {
            var option = jQuery('<option value="' + value + '">' + value + '</option>');
            select.append(option);
        });
        jQuery(".select").append(select);
    });
});


function list() {
    jQuery("table").remove();
    var element = document.getElementById("selector");
    var selectorValue = element.options[element.selectedIndex].value;
    document.cookie = 'name=' + selectorValue;
    if(selectorValue === 'all') {
        jQuery.getJSON('oktatok', function (data) {
            lister(data);
        });
    } else {
        jQuery.getJSON('/oktato', function (data) {
            lister(data);
        });
    }
}

function lister(data) {
    var table = jQuery('<table id="tables"></table>');
    table.append(
        "<tr>" +
        "<th id='th'>Név</th>" +
        "<th id='th'>Tanszék</th>" +
        "<th id='th'>Oktatott tárgyak</th>" +
        "</tr>"
    );

    jQuery.each(data, function (key, value) {
        var row = jQuery('<tr></tr>');
        var nevCell = jQuery('<td id="td">' + value.nev + '</td>');
        var tanszekCell = jQuery('<td id="td">' + value.tanszek + '</td>');
        var okt_tCell = jQuery('<td id="td">' + value.oktatott_targyak + '</td>');

        row.append(nevCell);
        row.append(tanszekCell);
        row.append(okt_tCell);

        table.append(row);

    });

    jQuery(".oktatolist").append(table);


}