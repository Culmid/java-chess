package cullen.middleton;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class KingTest {

  @Test
  public void middleBoardTest() {
    Board brd = new Board("data/King/k1.txt");
    Piece b = brd.getPiece(3, 3);
    int[] expected = {3, 4, 4, 4, 4, 3, 4, 2, 3, 2, 2, 2, 2, 3, 2, 4};

    assertNotNull(b);
    assertTrue(b instanceof King);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void bottomLeftTest() {
    Board brd = new Board("data/King/k2.txt");
    Piece b = brd.getPiece(0, 0);
    int[] expected = {0, 1, 1, 1, 1, 0};

    assertNotNull(b);
    assertTrue(b instanceof King);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void bottomRightTest() {
    Board brd = new Board("data/King/k3.txt");
    Piece b = brd.getPiece(7, 0);
    int[] expected = {7, 1, 6, 0, 6, 1};
    
    assertNotNull(b);
    assertTrue(b instanceof King);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void topRightTest() {
    Board brd = new Board("data/King/k4.txt");
    Piece b = brd.getPiece(7, 7);
    int[] expected = {7, 6, 6, 6, 6, 7};

    assertNotNull(b);
    assertTrue(b instanceof King);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void topLeftTest() {
    Board brd = new Board("data/King/k5.txt");
    Piece b = brd.getPiece(0, 7);
    int[] expected = {1, 7, 1, 6, 0, 6};

    assertNotNull(b);
    assertTrue(b instanceof King);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }
}
