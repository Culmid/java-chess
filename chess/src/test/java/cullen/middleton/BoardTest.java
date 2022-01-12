package cullen.middleton;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

public class BoardTest {
    
    @Test
    public void basicToStringTest()
    {
        Board brd = new Board();
        String expected = "♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜\n" +
                          "♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟\n" +
                          "* * * * * * * *\n" +
                          "* * * * * * * *\n" +
                          "* * * * * * * *\n" +
                          "* * * * * * * *\n" +
                          "♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙\n" +
                          "♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖";

        assertEquals(expected, brd.toString());
    }

    @Test
    public void loadBoardTest() {
        Board brd = new Board("data/Board/standard.txt");

        String expected = "♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜\n" +
                          "♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟\n" +
                          "* * * * * * * *\n" +
                          "* * * * * * * *\n" +
                          "* * * * * * * *\n" +
                          "* * * * * * * *\n" +
                          "♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙\n" +
                          "♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖";
        
        assertEquals(expected, brd.toString());
    }

    @Test
    public void getPieceTest() {
        Board brd = new Board();

        // Pawns
        for (int i = 0; i < 8; i++) {
            // W
            Piece p = brd.getPiece(i, 1);
            assertNotNull(p);
            assertTrue(p instanceof Pawn);
            assertEquals(0, p.getC());
            assertEquals(i, p.getX());
            assertEquals(1, p.getY());



            // B
            p = brd.getPiece(i, 6);
            assertNotNull(p);
            assertTrue(p instanceof Pawn);
            assertEquals(1, p.getC());
            assertEquals(i, p.getX());
            assertEquals(6, p.getY());
        }

        // Rooks
        // W
        Piece p = brd.getPiece(0, 0);
        assertNotNull(p);
        assertTrue(p instanceof Rook);
        assertEquals(0, p.getC());
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());

        p = brd.getPiece(7, 0);
        assertNotNull(p);
        assertTrue(p instanceof Rook);
        assertEquals(0, p.getC());
        assertEquals(7, p.getX());
        assertEquals(0, p.getY());

        // B
        p = brd.getPiece(7, 7);
        assertNotNull(p);
        assertTrue(p instanceof Rook);
        assertEquals(1, p.getC());
        assertEquals(7, p.getX());
        assertEquals(7, p.getY());

        p = brd.getPiece(0, 7);
        assertNotNull(p);
        assertTrue(p instanceof Rook);
        assertEquals(1, p.getC());
        assertEquals(0, p.getX());
        assertEquals(7, p.getY());

        // Knights
        // W
        p = brd.getPiece(1, 0);
        assertNotNull(p);
        assertTrue(p instanceof Knight);
        assertEquals(0, p.getC());
        assertEquals(1, p.getX());
        assertEquals(0, p.getY());

        p = brd.getPiece(6, 0);
        assertNotNull(p);
        assertTrue(p instanceof Knight);
        assertEquals(0, p.getC());
        assertEquals(6, p.getX());
        assertEquals(0, p.getY());

        // B
        p = brd.getPiece(1, 7);
        assertNotNull(p);
        assertTrue(p instanceof Knight);
        assertEquals(1, p.getC());
        assertEquals(1, p.getX());
        assertEquals(7, p.getY());

        p = brd.getPiece(6, 7);
        assertNotNull(p);
        assertTrue(p instanceof Knight);
        assertEquals(1, p.getC());
        assertEquals(6, p.getX());
        assertEquals(7, p.getY());

        // Bishops
        // W
        p = brd.getPiece(2, 0);
        assertNotNull(p);
        assertTrue(p instanceof Bishop);
        assertEquals(0, p.getC());
        assertEquals(2, p.getX());
        assertEquals(0, p.getY());

        p = brd.getPiece(5, 0);
        assertNotNull(p);
        assertTrue(p instanceof Bishop);
        assertEquals(0, p.getC());
        assertEquals(5, p.getX());
        assertEquals(0, p.getY());

        // B
        p = brd.getPiece(2, 7);
        assertNotNull(p);
        assertTrue(p instanceof Bishop);
        assertEquals(1, p.getC());
        assertEquals(2, p.getX());
        assertEquals(7, p.getY());

        p = brd.getPiece(5, 7);
        assertNotNull(p);
        assertTrue(p instanceof Bishop);
        assertEquals(1, p.getC());
        assertEquals(5, p.getX());
        assertEquals(7, p.getY());

        // Queens
        // W
        p = brd.getPiece(3, 0);
        assertNotNull(p);
        assertTrue(p instanceof Queen);
        assertEquals(0, p.getC());
        assertEquals(3, p.getX());
        assertEquals(0, p.getY());


        // B
        p = brd.getPiece(3, 7);
        assertNotNull(p);
        assertTrue(p instanceof Queen);
        assertEquals(1, p.getC());
        assertEquals(3, p.getX());
        assertEquals(7, p.getY());


        // Kings
        // W
        p = brd.getPiece(4, 0);
        assertNotNull(p);
        assertTrue(p instanceof King);
        assertEquals(0, p.getC());
        assertEquals(4, p.getX());
        assertEquals(0, p.getY());

        // B
        p = brd.getPiece(4, 7);
        assertNotNull(p);
        assertTrue(p instanceof King);
        assertEquals(1, p.getC());
        assertEquals(4, p.getX());
        assertEquals(7, p.getY());
    }

    @Test
    public void checkmateTest1() {
        Board brd = new Board("data/Board/checkmate1.txt");

        assertEquals(1, brd.inCheckStaleMate(1));
        assertEquals(-1, brd.inCheckStaleMate(0));
        assertTrue(brd.getPiece(4, 7).legalMoves(brd, true).isEmpty());
    }

    @Test
    public void checkmateTest2() {
        Board brd = new Board("data/Board/checkmate2.txt");

        assertEquals(1, brd.inCheckStaleMate(1));
        assertEquals(-1, brd.inCheckStaleMate(0));
        assertTrue(brd.getPiece(4, 7).legalMoves(brd, true).isEmpty());
    }

    @Test
    public void checkmateTest3() {
        Board brd = new Board("data/Board/checkmate3.txt");

        assertEquals(1, brd.inCheckStaleMate(1));
        assertEquals(-1, brd.inCheckStaleMate(0));
        assertTrue(brd.getPiece(6, 7).legalMoves(brd, true).isEmpty());
    }

    @Test
    public void checkmateTest4() {
        Board brd = new Board("data/Board/checkmate4.txt");

        assertEquals(1, brd.inCheckStaleMate(1));
        assertEquals(-1, brd.inCheckStaleMate(0));
        assertTrue(brd.getPiece(6, 7).legalMoves(brd, true).isEmpty());
    }

    @Test
    public void checkmateTest5() {
        Board brd = new Board("data/Board/checkmate5.txt");

        assertEquals(1, brd.inCheckStaleMate(1));
        assertEquals(-1, brd.inCheckStaleMate(0));
        assertTrue(brd.getPiece(7, 7).legalMoves(brd, true).isEmpty());
    }

    @Test
    public void checkTest1() {
        Board brd = new Board("data/Board/check1.txt");

        assertEquals(-1, brd.inCheckStaleMate(1));
        assertEquals(-1, brd.inCheckStaleMate(0));
       
        assertFalse(brd.inCheck(0));
        assertTrue(brd.inCheck(1));

        int[] expected = { 5, 7, 5, 6, 3, 6, 3, 7 };
        assertEquals(Arrays.toString(expected), brd.getPiece(4, 7).legalMoves(brd, true).toString());
    }

    @Test
    public void checkTest2() {
        Board brd = new Board("data/Board/check2.txt");

        assertEquals(-1, brd.inCheckStaleMate(1));
        assertEquals(-1, brd.inCheckStaleMate(0));

        assertTrue(brd.inCheck(0));
        assertFalse(brd.inCheck(1));

        assertTrue(brd.getPiece(4, 0).legalMoves(brd, true).isEmpty());

        int[] expected = { 7, 3 };
        assertEquals(Arrays.toString(expected), brd.getPiece(7, 0).legalMoves(brd, true).toString());

        int[] exp = { 6, 2 };
        assertEquals(Arrays.toString(exp), brd.getPiece(6, 1).legalMoves(brd, true).toString());
    }

    @Test
    public void checkTest3() {
        Board brd = new Board("data/Board/check3.txt");

        assertEquals(-1, brd.inCheckStaleMate(1));
        assertEquals(-1, brd.inCheckStaleMate(0));

        assertFalse(brd.inCheck(0));
        assertTrue(brd.inCheck(1));

        int[] expected = { 5, 7, 3, 7 };
        assertEquals(Arrays.toString(expected), brd.getPiece(4, 7).legalMoves(brd, true).toString());
    }

    @Test
    public void checkTest4() {
        Board brd = new Board("data/Board/check4.txt");

        assertEquals(-1, brd.inCheckStaleMate(1));
        assertEquals(-1, brd.inCheckStaleMate(0));

        assertTrue(brd.inCheck(0));
        assertFalse(brd.inCheck(1));

        int[] expected = { 3, 1 };
        assertEquals(Arrays.toString(expected), brd.getPiece(4, 0).legalMoves(brd, true).toString());
    }

    @Test
    public void checkTest5() {
        Board brd = new Board("data/Board/check5.txt");

        assertEquals(-1, brd.inCheckStaleMate(1));
        assertEquals(-1, brd.inCheckStaleMate(0));

        assertTrue(brd.inCheck(0));
        assertFalse(brd.inCheck(1));

        int[] expected = { 5, 1 };
        assertEquals(Arrays.toString(expected), brd.getPiece(4, 0).legalMoves(brd, true).toString());
    }

    @Test
    public void stalemateTest1() {
        Board brd = new Board("data/Board/stalemate1.txt");

        assertEquals(0, brd.inCheckStaleMate(1));
        assertEquals(-1, brd.inCheckStaleMate(0));

        assertFalse(brd.inCheck(0));
        assertFalse(brd.inCheck(1));
        assertTrue(brd.getPiece(4, 7).legalMoves(brd, true).isEmpty());
    }

    @Test
    public void stalemateTest2() {
        Board brd = new Board("data/Board/stalemate2.txt");

        assertEquals(0, brd.inCheckStaleMate(1));
        assertEquals(-1, brd.inCheckStaleMate(0));

        assertFalse(brd.inCheck(0));
        assertFalse(brd.inCheck(1));
        assertTrue(brd.getPiece(0, 7).legalMoves(brd, true).isEmpty());
    }

    @Test
    public void stalemateTest3() {
        Board brd = new Board("data/Board/stalemate3.txt");

        assertEquals(0, brd.inCheckStaleMate(1));
        assertEquals(-1, brd.inCheckStaleMate(0));

        assertFalse(brd.inCheck(0));
        assertFalse(brd.inCheck(1));
        assertTrue(brd.getPiece(7, 7).legalMoves(brd, true).isEmpty());
    }

    @Test
    public void stalemateTest4() {
        Board brd = new Board("data/Board/stalemate4.txt");

        assertEquals(-1, brd.inCheckStaleMate(1));
        assertEquals(0, brd.inCheckStaleMate(0));

        assertFalse(brd.inCheck(0));
        assertFalse(brd.inCheck(1));
        assertTrue(brd.getPiece(7, 7).legalMoves(brd, true).isEmpty());
    }

    @Test
    public void stalemateTest5() {
        Board brd = new Board("data/Board/stalemate5.txt");

        assertEquals(-1, brd.inCheckStaleMate(1));
        assertEquals(0, brd.inCheckStaleMate(0));

        assertFalse(brd.inCheck(0));
        assertFalse(brd.inCheck(1));
        assertTrue(brd.getPiece(7, 3).legalMoves(brd, true).isEmpty());
    }
}
