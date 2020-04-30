jQuery(document).ready(function () {
    jQuery.each(jQuery(".menuButton"), function (mbIndex, mbValue) {
        jQuery(mbValue).click(function event() {
            event.preventDefault();
            if (!(jQuery(this).find('a').attr("href") === "index.html")) {
                jQuery("#content").load(jQuery(this).find('a').attr("href"));

            }
            else
            {
                open("index.html", "_self"); // saját ablakban nyitja meg
            }
        });
    })
});

function Show(click) {
    var txt = document.getElementById(click);
    var x = document.getElementById("Description");
    if(txt.firstChild.data == "click me!")
    {
        txt.firstChild.data = "Hide";
        x.style.display = "block";
    }
    else
    {
        txt.firstChild.data = "click me!";
        x.style.display = "none";
    }
}