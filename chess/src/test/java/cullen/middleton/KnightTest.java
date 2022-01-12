package cullen.middleton;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class KnightTest {

  @Test
  public void middleBoardTest() {
    Board brd = new Board("data/Knight/k1.txt");
    Piece b = brd.getPiece(3, 3);
    int[] expected = { 4, 5, 5, 4, 5, 2, 4, 1, 2, 1, 1, 2, 1, 4, 2, 5 };

    assertNotNull(b);
    assertTrue(b instanceof Knight);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void bottomLeftTest() {
    Board brd = new Board("data/Knight/k2.txt");
    Piece b = brd.getPiece(0, 0);
    int[] expected = { 1, 2, 2, 1 };

    assertNotNull(b);
    assertTrue(b instanceof Knight);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void bottomRightTest() {
    Board brd = new Board("data/Knight/k3.txt");
    Piece b = brd.getPiece(7, 0);
    int[] expected = { 5, 1, 6, 2 };

    assertNotNull(b);
    assertTrue(b instanceof Knight);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void topRightTest() {
    Board brd = new Board("data/Knight/k4.txt");
    Piece b = brd.getPiece(7, 7);
    int[] expected = { 6, 5, 5, 6 };

    assertNotNull(b);
    assertTrue(b instanceof Knight);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void topLeftTest() {
    Board brd = new Board("data/Knight/k5.txt");
    Piece b = brd.getPiece(0, 7);
    int[] expected = { 2, 6, 1, 5 };

    assertNotNull(b);
    assertTrue(b instanceof Knight);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }
}
