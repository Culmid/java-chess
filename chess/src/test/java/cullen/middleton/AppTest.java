package cullen.middleton;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {
    
    @Test
    public void basicToStringTest()
    {
        Board brd = new Board("test.txt");
        // String expected = "♜ ♞ ♝ ♚ ♛ ♝ ♞ ♜\n" +
        //                   "♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟\n" +
        //                   "* * * * * * * *\n" +
        //                   "* * * * * * * *\n" +
        //                   "* * * * * * * *\n" +
        //                   "* * * * * * * *\n" +
        //                   "♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙\n" +
        //                   "♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖";

        // brd.exportBoard("test.txt");
        System.out.println(brd.toString());
        // assertEquals(expected, brd.toString());
    }
}
