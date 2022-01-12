package cullen.middleton;

import static org.junit.Assert.*;

import org.junit.Test;

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
}
