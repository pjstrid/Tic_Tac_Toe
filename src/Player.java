public class Player {

    private String name;

    private char playingChar;

    public Player (String name, char playingChar){
        this.name = name;
        this.playingChar = playingChar;
    }

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
