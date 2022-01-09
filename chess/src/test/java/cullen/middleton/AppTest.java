package cullen.middleton;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {
    
    @Test
    public void basicToStringTest()
    {
        Board brd = new Board();
        String expected = "♜ ♞ ♝ ♚ ♛ ♝ ♞ ♜\n" +
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
