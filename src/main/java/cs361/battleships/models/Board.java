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
		List<Square> squaresToRemove = new ArrayList<Square>();


		if (((x >= 1) && (x <= 10)) && ((y >= 'A') && (y <= 'J'))) {
			System.out.println("ATTACKING: " + x + " " + y);
			//loop through ship list
			//it's a miss unless it hits.
			attk = AtackStatus.MISS;
			result.setResult(attk);
			result.setLocation(new Square(x, y));
			for (Ship existingShip : shipList) {
				//loop through squares that ships occupy
				for (Square sq : existingShip.getOccupiedSquares()) {

					//if x == shipx && y == shipy
					System.out.println("attack: " + x + ", " + y + " :: " + sq.getRow() + ", " + sq.getColumn());
					if ((x == sq.getRow()) && (y == sq.getColumn())) {
						result.setShip(existingShip);
						squaresToRemove.add(sq);

						//System.out.println("Ship occupied squares count: " + existingShip.getOccupiedSquares().size());
						if(existingShip.getOccupiedSquares().size() == 1) {

							//if occupied squares length is 0,
							attk = AtackStatus.SUNK;
							result.setResult(attk);
							break;

						} else {
							//its a hit
							attk = AtackStatus.HIT;
							result.setResult(attk);
							break;
							//but is messing up the code at the moment
						}
					}
				}

				existingShip.getOccupiedSquares().removeAll(squaresToRemove);
				//System.out.println("Ship occupied squares count: " + existingShip.getOccupiedSquares().size());
			}

			int counter = 1;
			for(Ship existingShip : shipList) {
				if(existingShip.getOccupiedSquares().size() == 0) {
					if(counter == shipList.size()) {
						System.out.println("Blah");
						attk = AtackStatus.SURRENDER;
						result.setResult(attk);
						break;
					} else {
						counter++;
						continue;
					}
				} else {
					break;
				}
			}
			attkList.add(result);
		}
		else{
			attk = AtackStatus.INVALID;
			result.setResult(attk);
			attkList.add(result);
		}
		System.out.println(attkList);
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
