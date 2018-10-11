package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Board {
	@JsonProperty List<Ship> shipList;
	@JsonProperty List<Result> attkList;

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Board() {
		// TODO Implement
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {
		// TODO Implement
		return false;
	}


	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Result attack(int x, char y) {
		Result result = new Result();
		AtackStatus attk;
		//loop through ship list
		for(Ship existingShip: shipList) {

			//loop through squares that ships occupy
			for(Square sq: existingShip.getOccupiedSquares()) {

				//if x == shipx && y == shipy
				if ( (x == sq.getRow()) && (y == sq.getColumn())){

					//its a hit
					attk = AtackStatus.HIT;
					result.setResult(attk);
					attkList.add(result);
					return result;
				}
				else {

					//it's a miss
					attk = AtackStatus.MISS;
					result.setResult(attk);
					attkList.add(result);
				}
			}

		}
		return result;
	}

	public List<Ship> getShips() {
		//TODO implement
		return null;
	}
	public void setShips(List<Ship> ships) {
		//TODO implement
	}

	public List<Result> getAttacks() {
		return attkList;
	}

	public void setAttacks(List<Result> attacks) {
		for (Result thisAttk : attacks){
			attkList.add(thisAttk);
		}
	}
}
