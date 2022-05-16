package Model;

public class PlayerPiece extends Player {

    // colors
    public static final String BLUE = "Blue";
    public static final String RED = "Red";
    public static final String GREEN = "Green";
    public static final String MAGENTA = "Magenta";

    // Types
    public static final String PLAYER = "Player";
    public static final String COMPUTER = "Computer";

    private String color;
    private String type;
    private int pos;
    private int powers;

    public PlayerPiece() {
        this.color = null;
        this.type = null;
        this.pos = 0;
        this.powers = 0;
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
    
    /***
     * 
     * 0: NORMAL MOVEMENT
     * 1: REVERSE MOVEMENT
     * 2: TURTLE
     * 3: DICE 
     * 4: LUCKY
     *     
     * @return
     */
    public int getPower() {
        return this.powers;
    }
    
    /***
     * 
     * NORMAL MOVEMENT -> 0
     * REVERSE MOVEMENT -> 1
     * TURTLE -> 2
     * DICE -> 3
     * LUCKY -> 4
     * 
     * @return
     */
    public void setPower(int p) {
        this.powers = p;
    }

    public void setPlayer(String color, String type) {
        this.color = color;
        this.type = type;
        this.pos = 0;
    }

    public void getPosition(int newPos) {
        this.pos = newPos;
    }

    public void movePlayer(int diceReturn) {
        int newPosition = this.pos + diceReturn;
        this.pos = newPosition;
    }

}
