"use strict"; //just states that we're using strict mode in ES5, which helps w/ debugging since it throws errors which would otherwise be silent.

//setting the port to 8080
const PORT = 8080;
//all of our requirements (packages/libraries).
var http = require('http'),
    express = require('express'),
    ejs = require('ejs'),
    app = express();


//telling express that our template/view engine will be ejs.
app.set('view engine', 'ejs');
//telling express where our pages/partials (really only required if our directory wasn't named 'views').
app.set('views', './views');

//telling express that our static content is in the 'public' directory. This is where all client-side css/js will go.
app.use(express.static(__dirname+'/public'));

//requiring (importing/including) our index controller that's located in the 'controllers' directory.
var index = require('./controllers/index.js');
//telling express that when a user requests '/' (root directory) we use the function 'home' that's defined within our 'index' class/controller to serve that request.
//all it does now is renders the index.ejs page that's located in 'views/pages/index.ejs'
app.get('/', index.home);

//telling express to listen our port (8080) for requests.
//the '()=>{ }' is a callback that prints that we're listening on port:8080 once it's set up and listening.
app.listen(PORT, ()=> {
    console.log("listening on port: %d",PORT);
});
