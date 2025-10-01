public class Game {

    Game() {
        run();
    }

    public void run() {
        System.out.println("Your playing field:");
        PlayingFields.printThreeTimesThree();

       char [][] currentPlayingField = createNewPlayingField();
       System.out.println("Place your next move");
       String playersChoice = InputHandler.getString().toUpperCase();

       if (playersChoice.equals("A1")) {
           currentPlayingField[1][1] = 'X';
       }

        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.print("|");
            for (int j = 0; j < 4; j++) {
                System.out.print(currentPlayingField[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }

    }

    public char[][] createNewPlayingField() {
        return PlayingFields.threeTimesThree();
    }

}
