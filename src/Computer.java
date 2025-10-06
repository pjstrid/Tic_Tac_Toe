public class Computer extends Player{

    private String name;

    private char playingChar;

    int score;

    public Computer (){
        super();
        this.name = "Computer";
        this.playingChar = 'O';
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public char getPlayingChar() {
        return playingChar;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

