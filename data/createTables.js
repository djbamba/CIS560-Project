var sqlite3 = require("sqlite3");
var db =  new sqlite3.Database("./db/games.sqlite3");

db.serialize(()=>{

/*Drop table statements*/
    // db.run("DROP TABLE IF EXISTS game");
    // db.run("DROP TABLE IF EXISTS website");
    // db.run("DROP TABLE IF EXISTS score");
    // db.run("DROP TABLE IF EXISTS genre");
    // db.run("DROP TABLE IF EXISTS system");
    // db.run("DROP TABLE IF EXISTS console");
    // db.run("DROP TABLE IF EXISTS handheld");
    // db.run("DROP TABLE IF EXISTS pc");
    // db.run("DROP TABLE IF EXISTS country");
    // db.run("DROP TABLE IF EXISTS company");
    // db.run("DROP TABLE IF EXISTS developer");
    // db.run("DROP TABLE IF EXISTS publisher");


    db.run("CREATE TABLE IF NOT EXISTS game (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), release_date DATE)");
    db.run("CREATE TABLE IF NOT EXISTS website (game_id INTEGER, name VARCHAR(25), url VARCHAR(40), FOREIGN KEY (game_id) REFERENCES game(id))");
    db.run("CREATE TABLE IF NOT EXISTS score (game_id INTEGER, score INTEGER, score_type VARCHAR(10), FOREIGN KEY (game_id) REFERENCES game(id))");
    db.run("CREATE TABLE IF NOT EXISTS genre (game_id INTEGER, genre VARCHAR(20), FOREIGN KEY (game_id) REFERENCES game(id))");

    db.run("CREATE TABLE IF NOT EXISTS system (id INTEGER PRIMARY KEY AUTOINCREMENT, NAME VARCHAR(20))");
    db.run("CREATE TABLE IF NOT EXISTS console (system_id INTEGER, units_sold, FOREIGN KEY (system_id) REFERENCES system(id))");
    db.run("CREATE TABLE IF NOT EXISTS handheld (system_id INTEGER, screen_size VARCHAR(15), FOREIGN KEY (system_id) REFERENCES system(id))");
    db.run("CREATE TABLE IF NOT EXISTS pc (system_id INTEGER, price DOUBLE, FOREIGN KEY (system_id) REFERENCES system(id))");

    db.run("CREATE TABLE IF NOT EXISTS country (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20))");
    db.run("CREATE TABLE IF NOT EXISTS company (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(25), country_id INTEGER, FOREIGN KEY (country_id) REFERENCES country(id))");
    db.run("CREATE TABLE IF NOT EXISTS developer (company_id INTEGER, lead_designer VARCHAR(30), FOREIGN KEY (company_id) REFERENCES company(id))");
    db.run("CREATE TABLE IF NOT EXISTS publisher (company_id INTEGER, content_rating VARCHAR(20), FOREIGN KEY (company_id) REFERENCES company(id))");
});
