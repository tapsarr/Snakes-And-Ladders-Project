package Model;

public class PlayerPiece extends Player {
    
    //colors
    public static final String BLUE = "Blue";
    public static final String RED = "Red";    
    public static final String GREEN = "Green";
    public static final String MAGENTA = "Magenta";

    //Types
    public static final String PLAYER = "Player One";
    public static final String COMPUTER = "Computer";

    private String color;
    private String type;
    private int pos;

    public PlayerPiece(String color, String type) {
        this.color = color;
        this.type = type;
        this.pos = 0;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public String getType() {
        return this.type;
    }

    public int getPosition() {
        return this.pos;
    }


    public void movePlayer(int diceReturn) {
        int newPosition = this.pos + diceReturn;
        this.pos = newPosition;
    }

}
