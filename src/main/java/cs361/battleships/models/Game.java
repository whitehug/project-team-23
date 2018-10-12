package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static cs361.battleships.models.AtackStatus.*;

public class Game {

    @JsonProperty private Board playersBoard = new Board();
    @JsonProperty private Board opponentsBoard = new Board();

    /*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
    public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {

        boolean successful = playersBoard.placeShip(ship, x, y, isVertical);

        if (!successful) {
            System.out.println("FAILED PLACEMENT!");
            return false;
        }

        boolean opponentPlacedSuccessfully;
        do {
            System.out.println("Placing ship for AI");
            // AI places random ships, so it might try and place overlapping ships
            // let it try until it gets it right
            Ship AIShip = new Ship(ship.getKind());
            opponentPlacedSuccessfully = opponentsBoard.placeShip(AIShip, randRow(), randCol(), randVertical());
        } while (!opponentPlacedSuccessfully);
        System.out.println(playersBoard.getShips());

        return true;
    }

    /*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
    public boolean attack(int x, char  y) {
        Result playerAttack = opponentsBoard.attack(x, y);
        if (playerAttack.getResult() == INVALID) {
            return false;
        }
        Result opponentAttackResult;
        do {
            System.out.println("Attacking for opponent");
            // AI does random attacks, so it might attack the same spot twice
            // let it try until it gets it right
            opponentAttackResult = playersBoard.attack(randRow(), randCol());
        } while(opponentAttackResult.getResult() == INVALID);

        return true;
    }

    private char randCol() {
        Random r = new Random();
        return (char)((r.nextInt(9)+1) + 'A');
    }

    private int randRow() {
        Random r = new Random();
        return r.nextInt(9)+1;
    }

    private boolean randVertical() {
        Random r = new Random();
        if(r.nextInt(1) == 1)
            return true;
        return false;
    }
}
