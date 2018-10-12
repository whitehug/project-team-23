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
		attkList = new ArrayList<Result>();

	}


	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {
		if (ship.setOccupiedSquares(x, y, isVertical))
		{
			for(Ship existingShip: shipList)
			{
				for(Square sq: existingShip.getOccupiedSquares())
				{
					for(Square sq2: ship.getOccupiedSquares())
					{
						if(sq.getColumn() == sq2.getColumn() && sq.getRow() == sq2.getRow())
						{
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
		List<Square> squaresToRemove = new ArrayList<Square>();

		if (((x >= 1) && (x <= 10)) && ((y >= 'A') && (y <= 'J'))) {
			//loop through ship list
			//it's a miss unless it hits.
			attk = AtackStatus.MISS;
			result.setResult(attk);
			result.setLocation(new Square(x, y));
			for (Ship existingShip : shipList) {
				//loop through squares that ships occupy
				for (Square sq : existingShip.getOccupiedSquares()) {

					//if x == shipx && y == shipy
					if ((x == sq.getRow()) && (y == sq.getColumn())) {
						result.setShip(existingShip);
						squaresToRemove.add(sq);

						//its a hit
						attk = AtackStatus.HIT;
						result.setResult(attk);
						break;
						//but is messing up the code at the moment
					}
				}

				existingShip.getOccupiedSquares().removeAll(squaresToRemove);
			}
			attkList.add(result);
		}
		else{
			attk = AtackStatus.INVALID;
			result.setResult(attk);
			attkList.add(result);
		}
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
