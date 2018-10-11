package cs361.battleships.models;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BoardTest {

    @Test
    public void testInvalidPlacement() {
        Board board = new Board();
        // Off the edge
        assertFalse(board.placeShip(new Ship("MINESWEEPER"), 11, 'C', true));
        // On top of another ship
        board.placeShip(new Ship("MINESWEEPER"), 5, 'C',false);
        assertFalse(board.placeShip(new Ship("MINESWEEPER"), 5, 'C', false));

    }
    @Test
    public void testValidPlacement() {
        Board board = new Board();
        assertTrue(board.placeShip(new Ship("MINESWEEPER"),5, 'C', false ));
        assertTrue(board.placeShip(new Ship("BATTLESHIP"), 1, 'A', true));
        assertTrue(board.placeShip(new Ship("DESTROYER"), 5, 'A', true));
        assertTrue(board.placeShip(new Ship("MINESWEEPER"), 10, 'E', false));

    }


}
