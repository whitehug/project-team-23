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
					if(x > 9)
						return false;
					if(y > 'J')
						return false;
					occupiedSquares.add(new Square(x, y));
					occupiedSquares.add(new Square(x-1, y));
					return true;
				}
				else
				{
					if(x > 10)
						return false;
					if(y > 'I')
						return false;
					occupiedSquares.add(new Square(x, y));
					occupiedSquares.add(new Square(x,(char)(y+1)));
					return true;
				}
		}
		return false;
	}
}
