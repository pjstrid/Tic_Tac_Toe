public class PlayerVsPlayer {

    // Creates the crucial variables
    int turn;

    int gameCount = 1;

    Player playerOne = new UserPlayer("", 'X');
    Player playerTwo = new UserPlayer("", 'O');

    Player activePlayer;

    char[][] currentPlayBoard;

    // The full gameplay of Tic Tac Toe - Player vs Player
    public PlayerVsPlayer() {

        // Calls method which creates the players
        createPlayers();

        // User select the winning score: 3 or 5
        int winningScore = chooseWinningScore();
        System.out.println("First to: " + winningScore);

        boolean gameOver = false;

        // Loop until someone reaches the winning score
        while (!gameOver) {
            if (playerOne.getScore() < winningScore && playerTwo.getScore() < winningScore) {

                // Creates a new board for this game
                currentPlayBoard = createNewPlayBoard();

                // Setts the turns to zero in the beginning of the game
                turn = 0;

                // Calls method which prints the score
                printScore();

                // Calls method which prints NEW GAME and the starting board
                printStartOfRound();

                // Loop with
                while (turn < 10 && stillPlaying(currentPlayBoard)) {
                    playersTurn(playerOne, playerTwo);
                    printCurrentPlayBoard(currentPlayBoard);
                    if (!stillPlaying(currentPlayBoard)) {
                        gameCount++;
                        break;
                    }
                }
            } else {
                gameOver = true;
            }
        }
        System.out.println();
        System.out.println("GAME OVER!");
        System.out.println("Final score:");
        System.out.println(playerOne.getName() + ": " + playerOne.getScore() + "p");
        System.out.println(playerTwo.getName() + ": " + playerTwo.getScore() + "p");
    }


    // Method which asks for name and determine the players
    void createPlayers() {
        System.out.println();
        System.out.println("Player one, choose your name:");
        String selectedNamePlayerOne = InputHandler.getString();

        playerOne.setName(selectedNamePlayerOne);

        System.out.println("Player two, choose your name:");
        String selectedNamePlayerTwo = InputHandler.getString();

        playerTwo.setName(selectedNamePlayerTwo);

        System.out.println();
        System.out.println(playerOne.getName() + " plays with: " + playerOne.getPlayingChar());
        System.out.println(playerTwo.getName() + " plays with: " + playerTwo.getPlayingChar());
    }

    // Methods which alternate the players turn and makes input into a play on the board
    public void playersTurn(Player playerOne, Player playerTwo) {

        // Alternate which player who starts and the turns in a game
        if (gameCount % 2 == 1) {
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

        System.out.println(activePlayer.getName() +
                " (" + activePlayer.getPlayingChar() + "), your turn");

        // Variable which takes the active players move with an input handler to check if it´s correct
        String activePlayerChoice = InputHandler.getMove();

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

    // Method to print the start of a new each round
    public void printStartOfRound() {

        System.out.println();
        System.out.println("------------------------");
        System.out.println("------- ROUND "+ gameCount + " --------");
        System.out.println("------------------------");
        System.out.println("""
                            
                            Place your move on the board by
                            writing a coordinate e.g., A1""");

        printCurrentPlayBoard(currentPlayBoard);
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
                activePlayer.setScore(activePlayer.getScore()+1);
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
                activePlayer.setScore(activePlayer.getScore()+1);
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
                activePlayer.setScore(activePlayer.getScore()+1);
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
                activePlayer.setScore(activePlayer.getScore()+1);
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

    // Method which prints the score
    public void printScore() {
        System.out.println();
        System.out.println("Score:");
        System.out.println(playerOne.getName() + ": " + playerOne.getScore() + "p");
        System.out.println(playerTwo.getName() + ": " + playerTwo.getScore() + "p");
    }

    // Method which creates the new board for the game
    public char[][] createNewPlayBoard() {
        return PlayBoard.threeTimesThree();
    }

    // Method to select winning score
    public int chooseWinningScore() {
        System.out.println("""
                        
                        Select your winning score:
                        First to 3 or 5?""");
        return InputHandler.getBoardInt();
    }
}
