package cullen.middleton;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class BishopTest {

  @Test
  public void allDiagOpenTest() {
    Board brd = new Board("data/Bishop/b1.txt");
    Piece b = brd.getPiece(3, 3);
    int[] expected = {4, 4, 5, 5, 6, 6, 7, 7, 2, 2, 1, 1, 0,
                      0, 2, 4, 1, 5, 0, 6, 4, 2, 5, 1, 6, 0};
    
    assertNotNull(b);
    assertTrue(b instanceof Bishop);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void topRightDiagTest() {
    Board brd = new Board("data/Bishop/b2.txt");
    Piece b = brd.getPiece(0, 0);
    int[] expected = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7};

    assertNotNull(b);
    assertTrue(b instanceof Bishop);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void topLeftDiagTest() {
    Board brd = new Board("data/Bishop/b3.txt");
    Piece b = brd.getPiece(7, 0);
    int[] expected = {6, 1, 5, 2, 4, 3, 3, 4, 2, 5, 1, 6, 0, 7};
    assertNotNull(b);
    assertTrue(b instanceof Bishop);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void bottomLeftTest() {
    Board brd = new Board("data/Bishop/b4.txt");
    Piece b = brd.getPiece(7, 7);
    int[] expected = {6, 6, 5, 5, 4, 4, 3, 3, 2, 2, 1, 1, 0, 0};

    assertNotNull(b);
    assertTrue(b instanceof Bishop);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void bottomRightTest() {
    Board brd = new Board("data/Bishop/b5.txt");
    Piece b = brd.getPiece(0, 7);
    int[] expected = {1, 6, 2, 5, 3, 4, 4, 3, 5, 2, 6, 1, 7, 0};

    assertNotNull(b);
    assertTrue(b instanceof Bishop);
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }
}
