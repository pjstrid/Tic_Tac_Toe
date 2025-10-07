public class Computer extends Player {

    // Variables which both is final since it's not going to be changed
    private final String name;

    private final char playingChar;

    int score;

    // Constructor
    public Computer (){
        super();
        this.name = "Computer";
        this.playingChar = 'O';
        this.score = 0;
    }

    // Getter and setters
    public String getName() {
        return name;
    }

    public char getPlayingChar() {
        return playingChar;
    }

    public int getScore() {
        return score;
    }
}

