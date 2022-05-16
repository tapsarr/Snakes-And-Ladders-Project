package Model;

public class Players extends PlayerPiece {
    PlayerPiece player = new PlayerPiece();
    PlayerPiece computer = new PlayerPiece();
    public static Players playersInst = null;

    public Players() {
        this.player = null;
        this.computer = null;
    }

    public void setPlayers(PlayerPiece p, PlayerPiece c) {
        this.player = p;
        this.computer = c;
    }

    public PlayerPiece getComputer() {
        return this.computer;
    }

    public PlayerPiece getPlayer() {
        return this.player;
    }

    public static Players getInstance() {
        if (playersInst == null) {
            playersInst = new Players();
        }
        return playersInst;
    }
}
