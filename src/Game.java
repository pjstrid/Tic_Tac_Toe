import java.util.Random;
import java.util.Scanner;

public class Game {

    // Declares the crucial variables
    int turn;

    int roundCount;

    Player activePlayer;

    char[][] currentPlayBoard;

    int gameModeChoice;

    // The gameplay
    public Game(){

        do {
            System.out.println("""
                    -------------------------------
                    ------ WELCOME TO A GAME ------
                    ------  OF TIC TAC TOE!  ------
                    -------------------------------
                    
                    SELECT GAME MODE
                    1. vs. Player
                    2. vs. Computer
                    
                    Your choice:""");

            // The user selects which game mode to play
            gameModeChoice = InputHandler.getInt();

            if (gameModeChoice == 1) {
                playerVsPlayer();
            } else {
                playerVsComputer();
            }

        } while (!finishedPlaying());
    }

                        /// METHODS FOR "vs. PLAYER" GAME MODE

    // The full gameplay of Tic Tac Toe - Player vs Player
    public void playerVsPlayer() {

        System.out.println("""
                            
                            GAME MODE:
                            Player vs Player""");

        // Setts the round count to '1'
        roundCount = 1;

        // Declares two players
        Player playerOne = new UserPlayer("", 'X');
        Player playerTwo = new UserPlayer("", 'O');

        // Creates the two players
        createTwoPlayers(playerOne, playerTwo);

        // Prints the playing char for each player
        printPlayingChars(playerOne, playerTwo);

        // Users agrees and selects the winning score: 3 or 5
        int winningScore = getWinningScore();

        // Loop until someone reaches the winning score
        boolean gameOver = false;

        while (!gameOver) {

            if (playerOne.getScore() < winningScore && playerTwo.getScore() < winningScore) {

                // Creates a new board for this game
                currentPlayBoard = createNewPlayBoard();

                // Setts the turns to '0' in the beginning of the game
                turn = 0;

                // Prints the current score
                printCurrentScore(playerOne, playerTwo);

                // Prints the start of a new round
                printStartOfRound();

                // Loop with turns for each player
                while (turn < 10 && stillPlaying(currentPlayBoard)) {

                    turnsForPlayerVsPlayer(playerOne, playerTwo);
                    printCurrentPlayBoard(currentPlayBoard);

                    if (!stillPlaying(currentPlayBoard)) {
                        roundCount++;
                        break;
                    }
                }
            } else {
                gameOver = true;
            }
        }

        // Prints the end of the game with the final score
        printEndOfGame(playerOne, playerTwo);
    }

    // Method which asks for name and determine the players
    public void createTwoPlayers(Player playerOne, Player playerTwo) {

        // Setts the name for player one
        System.out.println();
        System.out.println("Player one, choose your name:");
        String selectedNamePlayerOne = InputHandler.getString();

        playerOne.setName(selectedNamePlayerOne);

        // Setts the name for player two
        System.out.println("Player two, choose your name:");
        String selectedNamePlayerTwo = InputHandler.getString();

        playerTwo.setName(selectedNamePlayerTwo);
    }

    // Methods which alternate the players turn and makes input into a play on the board
    public void turnsForPlayerVsPlayer(Player playerOne, Player playerTwo) {

        // Alternate turns
        alternateTurns(playerOne, playerTwo);

        // Print each player turn
        System.out.println(activePlayer.getName() +
                " (" + activePlayer.getPlayingChar() + "), your turn");

        // Variable which takes the active players move with an input handler to check if it´s correct
        String activePlayerChoice = InputHandler.getMove();

        // Making the move
        activePlayerMove(activePlayerChoice);
    }


                        /// METHODS FOR "vs. COMPUTER" GAME MODE

    // The full gameplay of Tic Tac Toe - Player vs Computer
    public void playerVsComputer() {

        System.out.println("""
                            
                            GAME MODE:
                            Player vs Computer""");

        // Setts the round count to '1'
        roundCount = 1;

        // Declares one player and one computer opponent
        Player playerOne = new UserPlayer("", 'X');
        Player playerTwo = new Computer();

        // Create the single player
        createSinglePlayer(playerOne);

        // Prints the playing char for each player
        printPlayingChars(playerOne, playerTwo);

        // User selects the winning score: 3 or 5
        int winningScore = getWinningScore();

        // Loop until someone reaches the winning score
        boolean gameOver = false;

        while (!gameOver) {

            if (playerOne.getScore() < winningScore && playerTwo.getScore() < winningScore) {

                // Creates a new board for this game
                currentPlayBoard = createNewPlayBoard();

                // Setts the turns to '0' in the beginning of the game
                turn = 0;

                // Prints the current score
                printCurrentScore(playerOne, playerTwo);

                // Prints the start of a new round
                printStartOfRound();

                // Loop with turns for player and computer
                while (turn < 10 && stillPlaying(currentPlayBoard)) {

                    turnsForPlayerVsComputer(playerOne, playerTwo);
                    printCurrentPlayBoard(currentPlayBoard);

                    if (!stillPlaying(currentPlayBoard)) {
                        roundCount++;
                        break;
                    }
                }
            } else {
                gameOver = true;
            }
        }

        // Prints the end of the game with the final score
        printEndOfGame(playerOne, playerTwo);
    }

    // Method which asks for name and determine the single player
    public void createSinglePlayer(Player playerOne) {

        // Setts the name for the player
        System.out.println();
        System.out.println("Player, choose your name:");
        String selectedNamePlayerOne = InputHandler.getString();

        playerOne.setName(selectedNamePlayerOne);
    }

    // Methods which alternate the player and the computer turn
    public void turnsForPlayerVsComputer(Player playerOne, Player playerTwo) {

        // Declares the variable which get used when making a move
        String activePlayerChoice;

        // Alternate which player the turns in a round and who starts each round
        alternateTurns(playerOne, playerTwo);

        // Takes an input from the user or a random move from the computer
        if (activePlayer == playerOne){

            System.out.println(activePlayer.getName() +
                    " (" + activePlayer.getPlayingChar() + "), your turn");

            activePlayerChoice = InputHandler.getMove();
        } else {

            activePlayerChoice = computerMove();
            System.out.println(activePlayer.getName() + " chose to play: " + activePlayerChoice);
        }

        // Making the move
        activePlayerMove(activePlayerChoice);
    }

    // Method for a randomised computer move
    public String computerMove() {

        Random random = new Random();
        int randomNumber = random.nextInt(1, 10);

        String computerMove = "";

        if (randomNumber == 1) {
            computerMove = "A1";
        } else if (randomNumber == 2) {
            computerMove = "B1";
        } else if (randomNumber == 3) {
            computerMove = "C1";
        } else if (randomNumber == 4) {
            computerMove = "A2";
        } else if (randomNumber == 5) {
            computerMove = "B2";
        } else if (randomNumber == 6) {
            computerMove = "C2";
        } else if (randomNumber == 7) {
            computerMove = "A3";
        } else if (randomNumber == 8) {
            computerMove = "B3";
        } else if (randomNumber == 9) {
            computerMove = "C3";
        }

        return computerMove;
    }


                        /// METHODS FOR BOTH GAME MODES

    // Method to select and print the winning score
    public int getWinningScore() {

        System.out.println("""
                            
                            SELECT THE WINNING SCORE:
                            First to 3 or 5 points?""");

        int winningScore = InputHandler.getScoreInt();
        System.out.println("You will play first to " + winningScore + " points");
        return winningScore;
    }

    // Method to print each player playing char
    public static void printPlayingChars(Player playerOne, Player playerTwo) {
        System.out.println();
        System.out.println(playerOne.getName() + " plays with: " + playerOne.getPlayingChar());
        System.out.println(playerTwo.getName() + " plays with: " + playerTwo.getPlayingChar());
    }

    // Method to print the start of a new round and the starting board
    public void printStartOfRound() {

        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("----------- ROUND "+ roundCount + " -----------");
        System.out.println("-------------------------------");
        System.out.println("""
                            
                            Place your move on the board by
                            writing a coordinate e.g., A1""");

        printCurrentPlayBoard(currentPlayBoard);
    }

    // Method which alternate which player who starts each round and the turns in a round
    public void alternateTurns(Player playerOne, Player playerTwo) {

        // Player one, starts uneven rounds and player two, starts even rounds
        if (roundCount % 2 == 1) {
            if (turn % 2 == 0) {
                activePlayer = playerOne;
            } else {
                activePlayer = playerTwo;
            }
        } else {
            if (turn % 2 == 0) {
                activePlayer = playerTwo;
            } else {
                activePlayer = playerOne;
            }
        }
    }

    // Method which makes sure the move is valid
    public void activePlayerMove(String activePlayerChoice) {
        // A switch which places the move in correct box, if that box isn´t already played
        switch (activePlayerChoice) {

            case "A1" -> {
                if (currentPlayBoard[1][1] == ' ') {

                    currentPlayBoard[1][1] = activePlayer.getPlayingChar();
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            }
            case "A2" -> {
                if (currentPlayBoard[2][1] == ' ') {

                    currentPlayBoard[2][1] = activePlayer.getPlayingChar();
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            }
            case "A3" -> {
                if (currentPlayBoard[3][1] == ' ') {

                    currentPlayBoard[3][1] = activePlayer.getPlayingChar();
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            }
            case "B1" -> {
                if (currentPlayBoard[1][2] == ' ') {

                    currentPlayBoard[1][2] = activePlayer.getPlayingChar();
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            }
            case "B2" -> {
                if (currentPlayBoard[2][2] == ' ') {

                    currentPlayBoard[2][2] = activePlayer.getPlayingChar();
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            }
            case "B3" -> {
                if (currentPlayBoard[3][2] == ' ') {

                    currentPlayBoard[3][2] = activePlayer.getPlayingChar();
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            }
            case "C1" -> {
                if (currentPlayBoard[1][3] == ' ') {

                    currentPlayBoard[1][3] = activePlayer.getPlayingChar();
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            }
            case "C2" -> {
                if (currentPlayBoard[2][3] == ' ') {

                    currentPlayBoard[2][3] = activePlayer.getPlayingChar();
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            }
            case "C3" -> {
                if (currentPlayBoard[3][3] == ' ') {

                    currentPlayBoard[3][3] = activePlayer.getPlayingChar();
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            }
            default ->
                    System.out.println("""
                                    Wrong input. Answer with a correct
                                    coordinate e.g., 'A1'""");
        }
    }

    // Method to check for a winning move
    public boolean stillPlaying(char[][] currentPlayBoard) {

        // Horizontal win - 'i' sets to 'one' because the coordinate system is on 'zero'
        for (int i = 1; i < 4; i++) {

            if (currentPlayBoard[i][1] == ' ') {
                continue;
            }

            if (currentPlayBoard[i][1] == currentPlayBoard[i][2] &&
                    currentPlayBoard[i][2] == currentPlayBoard[i][3]) {

                System.out.println("ROUND OVER!");
                System.out.println(activePlayer.getName() + " is the winner!");
                activePlayer.setScore(activePlayer.getScore() + 1);

                return false;
            }
        }

        // Vertical win - 'i' sets to 'one' because the coordinate system is on 'zero'
        for (int i = 1; i < 4; i++) {

            if (currentPlayBoard[1][i] == ' ') {
                continue;
            }

            if (currentPlayBoard[1][i] == currentPlayBoard[2][i] &&
                    currentPlayBoard[2][i] == currentPlayBoard[3][i]) {

                System.out.println("ROUND OVER!");
                System.out.println(activePlayer.getName() + " is the winner!");
                activePlayer.setScore(activePlayer.getScore() + 1);

                return false;
            }
        }

        // Diagonal win - top left to bottom right
        for (int i = 0; i < 3; i++) {

            if (currentPlayBoard[1][1] == ' ') {
                continue;
            }

            if (currentPlayBoard[1][1] == currentPlayBoard[2][2] &&
                    currentPlayBoard[2][2] == currentPlayBoard[3][3]){

                System.out.println("ROUND OVER!");
                System.out.println(activePlayer.getName() + " is the winner!");
                activePlayer.setScore(activePlayer.getScore() + 1);

                return false;
            }
        }

        // Other diagonal win - top right to bottom left
        for (int i = 0; i < 3; i++) {

            if (currentPlayBoard[1][3] == ' ') {
                continue;
            }
            if (currentPlayBoard[1][3] == currentPlayBoard[2][2] &&
                    currentPlayBoard[2][2] == currentPlayBoard[3][1]) {

                System.out.println("ROUND OVER!");
                System.out.println(activePlayer.getName() + " is the winner!");
                activePlayer.setScore(activePlayer.getScore() + 1);

                return false;
            }
        }

        if (turn == 9){
            System.out.println("""
                            ROUND OVER!
                            It's a tie!""");
            return false;
        }
        return true;
    }

    // Method which prints current score
    public void printCurrentScore(Player playerOne, Player playerTwo) {

        System.out.println();
        System.out.println("Score:");
        System.out.println(playerOne.getName() + ": " + playerOne.getScore() + " points");
        System.out.println(playerTwo.getName() + ": " + playerTwo.getScore() + " points");
    }

    // Method which print the end of the game and the final score
    public void printEndOfGame(Player playerOne, Player playerTwo) {
        System.out.println("""
                            ---------------------
                            ---------------------
                            GAME OVER!
                            
                            Final score:""");
        System.out.println(playerOne.getName() + ": " + playerOne.getScore() + "p");
        System.out.println(playerTwo.getName() + ": " + playerTwo.getScore() + "p");
        System.out.println("---------------------");
        System.out.println("---------------------");
    }

    // Method which creates a 3x3-board for the game
    public char[][] createNewPlayBoard() {
        return new char[][]{
                {'*', 'A', 'B', 'C'},
                {'1', ' ', ' ', ' '},
                {'2', ' ', ' ', ' '},
                {'3', ' ', ' ', ' '}
        };
    }


    // Method which prints the current board
    public void printCurrentPlayBoard(char[][] currentPlayBoard) {

        System.out.println();
        for (int i = 0; i < 4; i++) {

            System.out.print("|");
            for (int j = 0; j < 4; j++) {

                System.out.print(currentPlayBoard[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Method for a new game or not
    private static boolean finishedPlaying() {
        System.out.println();
        System.out.println("""
                            NEW GAME?
                            1. YES
                            2. NO
                            
                            Your choice:""");

        Scanner in = new Scanner(System.in);
        int newGame = InputHandler.getInt();

        if (newGame == 1) {
            // Program restarts
            return false;

        } else if (newGame == 2) {

            // Program ends
            System.out.println();
            System.out.println("""
                                -------------------------------
                                ---- THANK YOU FOR PLAYING ----
                                ---------- GOOD BYE! ----------
                                -------------------------------""");
            return true;
        } else {

            System.out.println("Wrong input. Try again");
            in.nextLine();
        }

        return false;
    }
}