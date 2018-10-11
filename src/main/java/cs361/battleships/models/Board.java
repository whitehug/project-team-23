package cs361.battleships.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Ship> shipList;

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
		//TODO Implement
		return null;
	}

	public List<Ship> getShips() {
		return shipList;
	}

	public void setShips(List<Ship> ships) {
		shipList = ships;
	}

	public List<Result> getAttacks() {
		//TODO implement
		return null;
	}

	public void setAttacks(List<Result> attacks) {
		//TODO implement
	}
}
