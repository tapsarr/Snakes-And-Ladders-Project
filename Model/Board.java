package Model;

import java.util.Random;

public class Board {

    Difficulty lvl = Difficulty.getInstance();
    Random rand = new Random();

    int[][][] tiles = new int[10][10][3];
    int[][] orderOfTiles = new int[100][2];

    public final String SIMPLE = "Simple Square";
    public final String SNAKE = "Snake Square";
    public final String LADDER = "Ladder Square";
    public final String EXPLOSION = "Explosion Square";
    public final String LOVE = "Love Square";
    public final String EXCHANGE = "Exchange Pawns Square";
    public final String RETHROW = "Rethrow Dice Square";
    public final String LUCKY = "Lucky Square";
    public final String GRAVITY = "Gravity Reversal Square";
    public final String REVERSE = "Reverse Square";
    public final String CREVERSE = "Cancel Reverse Square";
    public final String TURTLE = "Turtle Square";
    public final String CTURTLE = " Cancel Turtle Square";

    public Board() {
        initiateBoard();
    }

    public String getTileString(int i, int j) {
        switch (getTileInt(i, j)) {
            case 1:
                return LADDER;
            case 2:
                return SNAKE;
            case 3:
                return EXPLOSION;
            case 4:
                return LOVE;
            case 5:
                return EXCHANGE;
            case 6:
                return RETHROW;
            case 7:
                return LUCKY;
            case 8:
                return GRAVITY;
            case 9:
                return REVERSE;
            case 10:
                return CREVERSE;
            case 11:
                return TURTLE;
            case 12:
                return CTURTLE;
            default:
                return SIMPLE;
        }

    }
    
    public int getTileInt(int i, int j) {
        return tiles[i][j][1];
    }

    private void initiateBoard() {
        numberTiles();
        if (lvl.getDifficultyInt() == 1) {
            LaddersAndSnakes(20, 10);
            fitGravity(2);
            fitRest(2);
        } else if (lvl.getDifficultyInt() == 3) {
            LaddersAndSnakes(10, 20);
            fitGravity(4);
            fitRest(4);
        } else {
            LaddersAndSnakes(15, 15);
            fitGravity(6);
            fitRest(5);
        }
        fitExchangePawns();

    }

    private void numberTiles() {
        int k = 1;
        int i;
        int j;

        for (i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                for (j = 0; j < 10; j++) {
                    tiles[i][j][0] = k;
                    tiles[i][j][1] = 0;
                    tiles[i][j][2] = 0;
                    orderOfTiles[k - 1][0] = i;
                    orderOfTiles[k - 1][1] = j;
                    k++;
                }
            } else {
                for (j = 9; j >= 0; j--) {
                    tiles[i][j][0] = k;
                    tiles[i][j][1] = 0;
                    tiles[i][j][2] = 0;
                    orderOfTiles[k - 1][0] = i;
                    orderOfTiles[k - 1][1] = j;
                    k++;
                }
            }
        }

    }

    private void LaddersAndSnakes(int mLadders, int mSnakes) {
        int ladders;
        int snakes;
        if (mLadders > mSnakes) {
            ladders = rand.nextInt(mLadders);
            snakes = ladders - 10;
        } else if (mLadders < mSnakes) {
            snakes = rand.nextInt(mSnakes);
            ladders = snakes - 10;
        } else {
            ladders = rand.nextInt(mLadders);
            snakes = ladders;
        }

        fitLadders(ladders);
        fitSnakes(snakes);

    }

    private void fitRest(int maxTiles) {
        fitExplosion(rand.nextInt(maxTiles));
        fitLove(rand.nextInt(maxTiles));
        fitRethrow(rand.nextInt(maxTiles));
        fitLucky(rand.nextInt(maxTiles));
        fitReverse(rand.nextInt(maxTiles));
        fitTurtle(rand.nextInt(maxTiles));
    }

    private void fitLadders(int ladders) {

        int i;
        int tileLength;
        int tileStart;
        for (i = 0; i < ladders; i++) {
            tileStart = rand.nextInt(89);
            tileLength = rand.nextInt(30);
            while (tileLength > 100 - tileStart) {
                tileLength = rand.nextInt(30);
            }
            if (tiles[orderOfTiles[tileStart][0]][orderOfTiles[tileStart][1]][1] == 0) {
                tiles[orderOfTiles[tileStart][0]][orderOfTiles[tileStart][1]][1] = 1;
                tiles[orderOfTiles[tileStart][0]][orderOfTiles[tileStart][1]][2] = tileLength;
                tiles[orderOfTiles[tileStart + tileLength][0]][orderOfTiles[tileStart + tileLength][1]][1] = 13;
            } else {
                i--;
            }
        }
    }

    private void fitSnakes(int snakes) {
        int i;
        int tileLength;
        int tileStart;
        for (i = 0; i < snakes; i++) {
            tileStart = rand.nextInt(95);
            while (tileStart < 11) {
                tileStart = rand.nextInt(95);
            }
            tileLength = rand.nextInt(20);
            while (tileLength + tileStart < 0) {
                tileLength = rand.nextInt(20);
            }
            if (tiles[orderOfTiles[tileStart][0]][orderOfTiles[tileStart][1]][1] == 0) {
                tiles[orderOfTiles[tileStart][0]][orderOfTiles[tileStart][1]][1] = 2;
                tiles[orderOfTiles[tileStart][0]][orderOfTiles[tileStart][1]][2] = tileLength;
                tiles[orderOfTiles[tileStart + tileLength][0]][orderOfTiles[tileStart + tileLength][1]][1] = 13;
            } else {
                i--;
            }
        }

    }
    
    private void fitExplosion(int expTiles) {
        int tilePos;
        for (int i = 0; i < expTiles; i++) {
            tilePos = rand.nextInt(99);
            if (tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] == 0) {
                tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] = 3;
            } else {
                continue;
            }
        }
    }
    
    private void fitLove(int loveTiles) {
        int tilePos;
        for (int i = 0; i < loveTiles; i++) {
            tilePos = rand.nextInt(99);
            if (tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] == 0) {
                tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] = 4;
            } else {
                continue;
            }
        }
        
    }
    
    private void fitExchangePawns() {
        int tilePos;
        for (int i = 0; i < 2; i++) {
            tilePos = rand.nextInt(99);
            if (tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] == 0) {
                tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] = 5;
            } else {
                continue;
            }
        }
    }

    private void fitRethrow(int rethTiles) {
        int tilePos;
        for (int i = 0; i < rethTiles; i++) {
            tilePos = rand.nextInt(99);
            if (tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] == 0) {
                tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] = 6;
            } else {
                continue;
            }
        }
    }

    private void fitLucky(int luckTiles) {
        int tilePos;
        for (int i = 0; i < luckTiles; i++) {
            tilePos = rand.nextInt(99);
            if (tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] == 0) {
                tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] = 7;
            } else {
                continue;
            }
        }
    }    

    private void fitGravity(int maxGravity) {

        int gravTiles = rand.nextInt(maxGravity);
        int tilePos;
        for (int i = 0; i < gravTiles; i++) {
            tilePos = rand.nextInt(99);
            if (tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] == 0) {
                tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] = 8;
            } else {
                continue;
            }
        }
    }

    private void fitReverse(int reverTiles) {
        int tilePos;
        for (int i = 0; i < reverTiles; i++) {
            tilePos = rand.nextInt(99);
            if (tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] == 0) {
                tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] = 9;
            } else {
                continue;
            }
        }
        for (int i = 0; i < reverTiles; i++) {
            tilePos = rand.nextInt(99);
            if (tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] == 0) {
                tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] = 10;
            } else {
                continue;
            }
        }
    }

    private void fitTurtle(int turtTiles) {
        int tilePos;
        for (int i = 0; i < turtTiles; i++) {
            tilePos = rand.nextInt(99);
            if (tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] == 0) {
                tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] = 11;
            } else {
                continue;
            }
        }
        for (int i = 0; i < turtTiles; i++) {
            tilePos = rand.nextInt(99);
            if (tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] == 0) {
                tiles[orderOfTiles[tilePos][0]][orderOfTiles[tilePos][1]][1] = 12;
            } else {
                continue;
            }
        }
    }

}
