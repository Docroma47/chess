# Chess game in terminal

## User manual

### To launch the game

![Chess](https://user-images.githubusercontent.com/29877995/83978068-92c0cf80-a90d-11ea-9a01-76655bb58a65.png)

# checkout the game
git clone git@github.com:Docroma47/chess.git

# build
mvn clean install

# run
java -cp target/chess-1.0-SNAPSHOT-jar-with-dependencies.jar org.mom47.chess.App

### Game navigation
Move cursor - up, right, down, left arrows

Select/drop chess piece - enter

Quit - q

Save (game is saved into 'chess.json' file) - s

Reset - r

![Chess_Queen](https://user-images.githubusercontent.com/29877995/84036860-7c1a8700-a9a6-11ea-8d13-497f04579aed.png) ![Chess_Pawn](https://user-images.githubusercontent.com/29877995/84036901-8c326680-a9a6-11ea-995f-4da6fd41c2e5.png)
![Chess_Horse](https://user-images.githubusercontent.com/29877995/84036941-95233800-a9a6-11ea-9e44-81bf546c9445.png)

### Loading saved game
By default game is saved in chess.json file, however a different file can be specified as an argument to the game (see below - game1.json): java -cp target/chess-1.0-SNAPSHOT-jar-with-dependencies.jar org.mom47.chess.App game1.json
