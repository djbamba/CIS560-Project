"use strict";

class Index {
    home(req,res){
        res.render("pages/index")
    }
}
// exporting this class allows us to use it like: "var index = require('path/to/controllers/index.js')", look for it in app.js.
module.exports = exports = new Index();
