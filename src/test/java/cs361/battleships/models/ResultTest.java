package cs361.battleships.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class ResultTest {

    @Test
    public void HitTest(){

    Board b = new Board();
    Ship ship = new Ship("MINESWEEPER");
    b.placeShip(ship,2,'C',false);
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

    }
}
