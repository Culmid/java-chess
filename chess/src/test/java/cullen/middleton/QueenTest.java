package cullen.middleton;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class QueenTest {

  @Test
  public void middleBoardTest() {
    Board brd = new Board("data/Queen/q1.txt");
    Piece b = brd.getPiece(3, 3);
    int[] expected = { 4, 4, 5, 5, 6, 6, 7, 7, 2, 2, 1, 1, 0, 0, 2, 4, 1, 5,
                       0, 6, 4, 2, 5, 1, 6, 0, 3, 4, 3, 5, 3, 6, 3, 7, 3, 2,
                       3, 1, 3, 0, 2, 3, 1, 3, 0, 3, 4, 3, 5, 3, 6, 3, 7, 3 };

    assertNotNull(b);
    assertTrue(b instanceof Queen);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void bottomLeftTest() {
    Board brd = new Board("data/Queen/q2.txt");
    Piece b = brd.getPiece(0, 0);
    int[] expected = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 0, 1, 0, 2,
                       0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 1, 0, 2, 0, 3, 0, 4, 0,
                       5, 0, 6, 0, 7, 0 };

    assertNotNull(b);
    assertTrue(b instanceof Queen);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void bottomRightTest() {
    Board brd = new Board("data/Queen/q3.txt");
    Piece b = brd.getPiece(7, 0);
    int[] expected = { 6, 1, 5, 2, 4, 3, 3, 4, 2, 5, 1, 6, 0, 7, 7, 1, 7, 2,
                       7, 3, 7, 4, 7, 5, 7, 6, 7, 7, 6, 0, 5, 0, 4, 0, 3, 0,
                       2, 0, 1, 0, 0, 0 };

    assertNotNull(b);
    assertTrue(b instanceof Queen);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void topRightTest() {
    Board brd = new Board("data/Queen/q4.txt");
    Piece b = brd.getPiece(7, 7);
    int[] expected = { 6, 6, 5, 5, 4, 4, 3, 3, 2, 2, 1, 1, 0, 0, 7, 6, 7, 5,
                       7, 4, 7, 3, 7, 2, 7, 1, 7, 0, 6, 7, 5, 7, 4, 7, 3, 7,
                       2, 7, 1, 7, 0, 7 };

    assertNotNull(b);
    assertTrue(b instanceof Queen);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void topLeftTest() {
    Board brd = new Board("data/Queen/q5.txt");
    Piece b = brd.getPiece(0, 7);
    int[] expected = { 1, 6, 2, 5, 3, 4, 4, 3, 5, 2, 6, 1, 7, 0, 0, 6, 0, 5,
                       0, 4, 0, 3, 0, 2, 0, 1, 0, 0, 1, 7, 2, 7, 3, 7, 4, 7,
                       5, 7, 6, 7, 7, 7 };

    assertNotNull(b);
    assertTrue(b instanceof Queen);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }
}
