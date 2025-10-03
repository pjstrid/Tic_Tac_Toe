public class Game {

    // Creates the crucial variables
    int turn;
    Player playerOne = new Player("", 'X');
    Player playerTwo = new Player("", 'O');
    Player activePlayer;
    char[][] currentPlayBoard;

    // The full gameplay
    public Game() {

        System.out.println("Welcome to a game of Tic Tac Toe!");

        // Calls method which creates the players
        createPlayers();

        while (true) {

            // Creates a new playing field for this game
            currentPlayBoard = createNewPlayBoard();
            // Setts the turns to zero in the beginning of the game
            turn = 0;

            // Calls method which prints NEW GAME and
            // the starting playing field with instructions
            printStartOfGame();

            while (turn != 9 && isPlaying(currentPlayBoard)) {
                if (!isPlaying(currentPlayBoard)){
                    break;
                }
                playersTurn(playerOne, playerTwo);
                printCurrentPlayingField(currentPlayBoard);
            }

//            printCurrentPlayingField(currentPlayBoard);
        }
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

        // Alternate the turns
        if (turn % 2 == 0) {
            activePlayer = playerOne;
        } else {
            activePlayer = playerTwo;
        }

        System.out.println(activePlayer.getName() + " (" + activePlayer.getPlayingChar() + "), your turn");

        // Takes input and make it to upper case if it's not, to match the cases in the switch
        String activePlayerChoice = InputHandler.getMove().toUpperCase();

        // Places the move in correct box and checks if that box is already played
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
            default -> {
                System.out.println("""
                                    Wrong input. Answer with a correct
                                    coordinate e.g., 'A1'""");
            }
        }
    }

    // Method to print the start of a new game
    public void printStartOfGame() {
        System.out.println();
        System.out.println("""
                            ------------------------
                            ------- NEW GAME -------
                            ------------------------
                            
                            Place your move on the board by
                            writing a coordinate e.g., A1""");
        printCurrentPlayingField(currentPlayBoard);
    }

    public boolean isPlaying(char[][] currentPlayingField) {

        // Horizontal win - index sets to one because the coordinate system is on zero
        for (int i = 1; i < 3; i++) {
            if (currentPlayingField[i][1] == ' ') {
                continue;
            }
            if (currentPlayingField[i][1] == currentPlayingField[i][2] &&
                    currentPlayingField[i][2] == currentPlayingField[i][3]) {

                System.out.println("GAME OVER!");
                System.out.println(activePlayer.getName() + " is the winner!");
                return false;
            }
        }

        // Vertical win - index sets to one because the coordinate system is on zero
        for (int i = 1; i < 3; i++) {
            if (currentPlayingField[1][i] == ' ') {
                continue;
            }
            if (currentPlayingField[1][i] == currentPlayingField[2][i] &&
                    currentPlayingField[2][i] == currentPlayingField[3][i]) {

                System.out.println("GAME OVER!");
                System.out.println(activePlayer.getName() + " is the winner!");
                return false;
            }
        }

        // Diagonal win
        for (int i = 0; i < 3; i++) {
            if (currentPlayingField[1][1] == ' '){
                continue;
            }
            if (currentPlayingField[1][1] == currentPlayingField[2][2] &&
                    currentPlayingField[2][2] == currentPlayingField[3][3]){

                System.out.println("GAME OVER!");
                System.out.println(activePlayer.getName() + " is the winner!");
                return false;
            }
        }

        // Other diagonal win
        for (int i = 0; i < 3; i++) {
            if (currentPlayingField[1][3] == ' '){
                continue;
            }
            if (currentPlayingField[1][3] == currentPlayingField[2][2] &&
                    currentPlayingField[2][2] == currentPlayingField[3][1]){

                System.out.println("GAME OVER!");
                System.out.println(activePlayer.getName() + " is the winner!");
                return false;
            }
        }

        if (turn == 9){
            System.out.println("""
                            
                            GAME OVER!
                            It's a tie!""");

            return false;
        }
        return true;
    }

    public void printCurrentPlayingField(char[][] currentPlayingField) {
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.print("|");
            for (int j = 0; j < 4; j++) {
                System.out.print(currentPlayingField[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println();
    }

    public char[][] createNewPlayBoard() {
        return PlayBoard.threeTimesThree();
    }
}