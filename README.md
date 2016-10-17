# CIS-560/561 Project
### Authors:
*Allan Jay Cabanatuan, Arun Paramanathan, Daniel Bamba, Zachary Terwort*
#### App Description:
A node.js application that displays information on video games. The application tracks sites where the video game is sold, platform, score/rating, genre, publishers and developers. A search function that allows users to search for specific games will also be implemented.

#### Backend Description:
 * Each video game has:
    * A list of websites where you can buy the game.
    * A score/rating.
    * A list of platforms the game is supported on.
    * A list of genres the game belongs to.
    * A publisher and developer.

* A game could have a critic score, user score, both, or no score.
* The platform a game is supported on could be a Console, Handheld, or PC.
* A game can belong to one or multiple genres.
* A publisher and developer are both companies. Companies have:
    * A country in which they are located.

###### Packages used:
* sqlite3
* cheerio
* requests
* express
