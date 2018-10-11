package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Ship {

	@JsonProperty private List<Square> occupiedSquares;
	private String kind;
	
	public Ship(String kind) {
		this.kind = kind;
		occupiedSquares = new ArrayList<Square>();
	}

	public List<Square> getOccupiedSquares() {
		return occupiedSquares;
	}

	public Boolean setOccupiedSquares(int x, char y, Boolean isVertical)
	{
		switch(this.kind)
		{
			case "MINESWEEPER":
				if(isVertical)
				{
					// Validate location:
					if(x > 9 || x < 1)
						return false;
					if(y > 'J')
						return false;
					occupiedSquares.add(new Square(x, y));
					occupiedSquares.add(new Square(x+1, y));
					return true;
				}
				else
				{
					if(x > 10 || x < 1)
						return false;
					if(y > 'I')
						return false;
					occupiedSquares.add(new Square(x, y));
					occupiedSquares.add(new Square(x,(char)(y+1)));
					return true;
				}
			case "DESTROYER":
				if(isVertical)
				{
					// Validate location:
					if(x > 8 || x < 1)
						return false;
					if(y > 'J')
						return false;
					occupiedSquares.add(new Square(x, y));
					occupiedSquares.add(new Square(x+1, y));
					occupiedSquares.add(new Square(x+2, y));
					return true;
				}
				else
				{
					if(x > 10 || x < 1)
						return false;
					if(y > 'H')
						return false;
					occupiedSquares.add(new Square(x, y));
					occupiedSquares.add(new Square(x,(char)(y+1)));
					occupiedSquares.add(new Square(x, (char)(y+2)));
					return true;
				}
		case "BATTLESHIP":
				if(isVertical)
				{
					// Validate location:
					if(x > 7 || x < 1)
						return false;
					if(y > 'J')
						return false;
					occupiedSquares.add(new Square(x, y));
					occupiedSquares.add(new Square(x+1, y));
					occupiedSquares.add(new Square(x+2, y));
					occupiedSquares.add(new Square(x+3, y));
					return true;
				}
				else
				{
					if(x > 10 || x < 1)
						return false;
					if(y > 'G')
						return false;
					occupiedSquares.add(new Square(x, y));
					occupiedSquares.add(new Square(x,(char)(y+1)));
					occupiedSquares.add(new Square(x, (char)(y+2)));
					occupiedSquares.add(new Square(x, (char)(y+3)));
					return true;
				}
		}
		return false;
	}
}
