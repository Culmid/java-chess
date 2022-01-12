package cullen.middleton;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class BoardTest {
    
    @Test
    public void basicToStringTest()
    {
        Scanner sc = new Scanner(System.in);
        Board brd = new Board(sc);
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
