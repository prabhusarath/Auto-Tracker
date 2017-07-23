var express = require('express');
var path = require('path');
var bodyParser = require('body-parser');

var apps = express();

var index = require('./routes/main');
var data = require('./routes/data');
var warn = require('./routes/warn');


//Views
apps.set('views',path.join(__dirname,'views'));
apps.set('view engine','ejs');
apps.engine('html',require('ejs').renderFile);

//Static
apps.use(express.static(path.join(__dirname,'client')));

//BodyParser
apps.use(bodyParser.json());
apps.use(bodyParser.urlencoded({extended: false}));

apps.use('/main',index);
apps.use('/data',data);
apps.use('/warn',warn);


apps.listen('4500',() => {
    console.log('Server Started in Port 4500 !!');
});
