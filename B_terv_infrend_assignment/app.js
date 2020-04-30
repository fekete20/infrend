var express = require('express');
var bodyParser = require("body-parser");
var cookieParser = require('cookie-parser');
var app = express();

var targyak =
    [
        {"nev": "targy1"}, {"nev": "targy2"}, {"nev": "targy3"}, {"nev": "targy4"}
    ];
var oktatok =
    [
        {"nev": "onev1",                "tanszek": "tanszek1",       "oktatott_targyak": "targy1"},
        {"nev": "onev2",                "tanszek": "tanszek2",       "oktatott_targyak": "targy2"},
        {"nev": "onev3",                "tanszek": "tanszek3",       "oktatott_targyak": "targy3"},
        {"nev": "onev4",                "tanszek": "tanszek4",       "oktatott_targyak": "targy4"}
    ];

var hallgatok =
    [
        {"nev": "hnev1",                "tankor": "tankor1",       "hallgatott_targyak": "targy1", "jegy": 5 },
        {"nev": "hnev2",                "tankor": "tankor2",       "hallgatott_targyak": "targy2", "jegy": 1 },
        {"nev": "hnev3",                "tankor": "tankor2",       "hallgatott_targyak": "targy1", "jegy": 3 },
        {"nev": "hnev4",                "tankor": "tankor1",       "hallgatott_targyak": "targy3", "jegy": 1 },
        {"nev": "hnev5",                "tankor": "tankor1",       "hallgatott_targyak": "targy4", "jegy": 4 }
    ];

app.use(express.static(__dirname));
app.use(cookieParser());
app.use(bodyParser.urlencoded({
    extended: false
}));
app.use(bodyParser.json());

app.get('/oktatok', function (req, res) {
    res.send(oktatok);
});
app.get('/oktatoNevek', function (req, res) {
    var oktatoNevek = ["onev1","onev2","onev3","onev4"];
    for (var o of oktatok) {
        if (!oktatoNevek.includes(o.nev)) {
            oktatoNevek.push(o.nev);
        }
    }
    res.send(oktatoNevek);
});
app.get('/oktatok', function (req, res) {
    res.send(oktatok);
});
app.get('/oktato', function (req, res) {
    var ok = false;
    for (var o of oktatok) {
        if (o.nev === req.cookies.name) {
            ok = true;
            break;
        }
    }
    if (!ok) {
        alert("Nem létezik ilyen nevű oktató, és a listában sincs benne!")
        res.status(409).end();
        return;
    }
    var oktatoNev = [];
    for (var o of oktatok) {
        if (req.cookies.name === o.nev) {
            oktatoNev.push(o);
        }
    }
    res.send(oktatoNev);
});
app.post('/addOktato', function (req, res) {
    for (var oktato of oktatok) {
        if (oktato.nev === req.body.nev) {
            res.status(409).end();
            return;
        }
    }
    var oktatoJSON = {
        "nev":req.body.nev,
        "tanszek":req.body.tanszek,
        "oktatott_targyak":req.body.oktatott_targyak
    };
    oktatok.push(oktatoJSON);
    res.send(oktatok);
});

app.post('/addHallgato', function (req, res) {
    for (var h of hallgatok) {
        if (h.nev === req.body.nev) {
            res.status(409).end();
            return;
        }
    }
    var hallgato ={
        "nev": req.body.nev,
        "tankor": req.body.tankor,
        "hallgatott_targyak": req.body.hallgatott_targyak
    };
    hallgatok.push(hallgato);
    res.send(hallgatok);
});

app.get('/hallgatok', function (req, res) {
    res.send(hallgatok);
});
app.get('/hallgatoNevek', function (req, res) {
    var hallgatoNevek = ["hnev1","hnev2","hnev3","hnev4","hnev5"];
    for (var h of hallgatok) {
        if (!hallgatoNevek.includes(h.nev)) {
            hallgatoNevek.push(h.nev);
        }
    }
    res.send(hallgatoNevek);
});
app.get('/hallgatok', function (req, res) {
    res.send(hallgatok);
});
app.get('/hallgato', function (req, res) {
    var ok = false;
    for (var h of hallgatok) {
        if (h.nev === req.cookies.name) {
            ok = true;
            break;
        }
    }

    if (!ok) {
        alert("Nem létezik ilyen nevű hallgató, és a listában sincs benne!")
        res.status(409).end();
        return;
    }

    var hallgatoNev = [];
    for (var h of hallgatok) {
        if (req.cookies.name === h.nev) {
            hallgatoNev.push(h);
        }
    }
    res.send(hallgatoNev);
});
app.post('/addHallgato', function (req, res) {
    for (var h of hallgatok) {
        if (h.nev === req.body.nev) {
            res.status(409).end();
            return;
        }
    }
    var hallgatoJSON = {
        "nev":req.body.nev,
        "tankor":req.body.tankor,
        "hallgatott_targyak":req.body.hallgatott_targyak
    };
    hallgatok.push(hallgatoJSON);
    res.send(hallgatok);
});


app.get('/', function (req, res) {
    res.sendFile(__dirname + "index.html");
});

var server = app.listen(8081, function () {
    var host = server.address().address;
    var port = server.address().port;
    console.log("The app is listening at http://%s:%s", host, port);
});
