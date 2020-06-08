# Chess game in terminal

![Chess](https://user-images.githubusercontent.com/29877995/83978068-92c0cf80-a90d-11ea-9a01-76655bb58a65.png)

##User manual
###To launch the game
# checkout the game
git clone git@github.com:Docroma47/chess.git
# build
mvn clean install
# run
java -cp target/chess-1.0-SNAPSHOT-jar-with-dependencies.jar org.mom47.chess.App
###Game navigation
Move cursor - up, right, down, left arrows
Select/drop chess piece - enter
Quit - q
Save (game is saved into 'chess.json' file) - s
Reset - r
### Loading saved game
By default game is saved in chess.json file, however a different file can be specified as an argument to the game (see below - game1.json):
java -cp target/chess-1.0-SNAPSHOT-jar-with-dependencies.jar org.mom47.chess.App game1.json
