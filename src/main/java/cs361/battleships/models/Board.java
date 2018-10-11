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
		shipList = new ArrayList<Ship>();

	}


	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {
		System.out.println("PLACING SHIP AT: " + x + " " + y);
		if (ship.setOccupiedSquares(x, y, isVertical))
		{
			for(Ship existingShip: shipList)
			{
				for(Square sq: existingShip.getOccupiedSquares())
				{
					System.out.println("Part of ship located at: " + sq.getColumn() + ", " + sq.getRow());
					for(Square sq2: ship.getOccupiedSquares())
					{
						if(sq.getColumn() == sq2.getColumn() && sq.getRow() == sq2.getRow())
						{
							System.out.println("COLLISION AT " + sq.getColumn() + ", " + sq.getRow());
							return false;
						}
					}

				}
			}
			shipList.add(ship);
			return true;
		}
		else
		{
			return false;
		}

	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Result attack(int x, char y) {
		Result result = new Result();
		AtackStatus attk;

		if (((x >= 1) && (x <= 10)) && ((y >= 'A') && (y <= 'J'))) {
			System.out.println("ATTACKING: " + x + " " + y);
			//loop through ship list
			for (Ship existingShip : shipList) {
				//loop through squares that ships occupy
				for (Square sq : existingShip.getOccupiedSquares()) {

					//if x == shipx && y == shipy
					if ((x == sq.getRow()) && (y == sq.getColumn())) {
						result.setShip(existingShip);
						existingShip.getOccupiedSquares().remove(sq);

						//its a hit
						attk = AtackStatus.HIT;
						result.setResult(attk);
						//attkList.add(attkList);  //meant to add to a list of attacks that have been made
						//but is messing up the code at the moment
					} else {

						//it's a miss
						attk = AtackStatus.MISS;
						result.setResult(attk);
						//attkList.add(attkList);
					}
				}

			}
		}
		else{
			attk = AtackStatus.INVALID;
			result.setResult(attk);
			//attkList.add(a)
		}
		System.out.println(result.getResult());
		return result;
	}

	public List<Ship> getShips() {
		return shipList;
	}
	public void setShips(List<Ship> ships) {
		shipList = ships;
	}

	public List<Result> getAttacks() {
		return attkList;
	}

	public void setAttacks(List<Result> attacks) {

	}
}
