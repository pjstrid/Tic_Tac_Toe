public class UserPlayer extends Player {

    // Variables
    private String name;

    // Final since it's not going to be changed
    private final char playingChar;

    // Constructor
    public UserPlayer(String name, char playingChar) {
        super();
        this.name = name;
        this.playingChar = playingChar;
        this.score = 0;
    }

    // Getter and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getPlayingChar() {
        return playingChar;
    }
}
