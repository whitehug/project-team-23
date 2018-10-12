package cs361.battleships.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResultTest {

    @Test
    public void HitTest(){

    Board b = new Board();
    Ship ship = new Ship("MINESWEEPER");
    b.placeShip(ship,2,'C',false);
    System.out.println(b.getShips().get(0).getOccupiedSquares().get(0).getColumn());
    Result r = b.attack(2,'C');
    assertEquals(AtackStatus.HIT,r.getResult());
    }

    @Test
    public void MissTest(){
        Board b = new Board();
        Ship ship = new Ship("MINESWEEPER");
        b.placeShip(ship,10,'D',false);
        Result r = b.attack(2,'C');
        assertEquals(AtackStatus.MISS,r.getResult());
    }

    @Test
    public void InvalidTest(){
        Board b = new Board();
        Ship ship = new Ship("MINESWEEPER");
        b.placeShip(ship,10,'D',false);
        Result r = b.attack(12,'C');
        assertEquals(AtackStatus.INVALID,r.getResult());
        Result s = b.attack(8, 'Z');
        assertEquals(AtackStatus.INVALID,s.getResult());

    }

    @Test
    public void SunkTest(){
        Board b = new Board();
        Ship ship = new Ship("MINESWEEPER");
        Ship ship2 = new Ship("MINESWEEPER");
        b.placeShip(ship,10,'D',false);
        b.placeShip(ship2, 5, 'A', false);
        Result r = b.attack(10, 'D');
        Result s = b.attack(10, 'E');
        assertEquals(AtackStatus.HIT, r.getResult());
        assertEquals(AtackStatus.SUNK, s.getResult());

    }


    @Test
    public void SurrenderTest(){
        Board b = new Board();
        Ship ship = new Ship("MINESWEEPER");
        b.placeShip(ship,10,'D',false);
        Result r = b.attack(10, 'D');
        Result s = b.attack(10, 'E');
        assertEquals(AtackStatus.HIT, r.getResult());
        assertEquals(AtackStatus.SURRENDER, s.getResult());
    }
}
