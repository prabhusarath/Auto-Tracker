var express = require('express');
var router = express.Router();
var mysql = require('mysql');

var db = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'root'
});

db.connect( (err) => {
    if(err){
        throw err;
    }
    console.log('Connected to DB main');
});

// router.get('/',function (req,res,next){
//         res.render('index.html');
//     });


router.get('/',function (req,res,next){
    console.log('^^^^');
    let sql = 'select * from vehicle_db.data';
    db.query(sql , (err,data) => {
        if(err){
            throw err;
        } else {
            res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
            res.json(data);
        }
    });
});


router.get('/:id',function (req,res,next) {

    let gets = {"Vin": req.params.id};

    db.query(' select * from vehicle_db.data where ? ', gets, (err, data) => {
        if (err) {
            throw err;
        } else {
            res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
            res.json(data);
        }
    });
});


module.exports = router;