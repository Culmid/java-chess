package cullen.middleton;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class PawnTest {

  @Test
  public void middleBoardTestW() {
    Board brd = new Board("data/Pawn/p1.txt");
    Piece b = brd.getPiece(3, 3);
    int[] expected = { 3, 4, 3, 5 };

    assertNotNull(b);
    assertTrue(b instanceof Pawn);
    assertEquals(0, b.getC());
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void bottomLeftTestW() {
    Board brd = new Board("data/Pawn/p2.txt");
    Piece b = brd.getPiece(0, 0);
    int[] expected = { 0, 1, 0, 2 };

    assertNotNull(b);
    assertTrue(b instanceof Pawn);
    assertEquals(0, b.getC());
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void bottomRightTestW() {
    Board brd = new Board("data/Pawn/p3.txt");
    Piece b = brd.getPiece(7, 0);
    int[] expected = { 7, 1, 7, 2 };

    assertNotNull(b);
    assertTrue(b instanceof Pawn);
    assertEquals(0, b.getC());
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void topRightTestW() {
    Board brd = new Board("data/Pawn/p4.txt");
    Piece b = brd.getPiece(7, 7);
    int[] expected = {};

    assertNotNull(b);
    assertTrue(b instanceof Pawn);
    assertEquals(0, b.getC());
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void topLeftTestW() {
    Board brd = new Board("data/Pawn/p5.txt");
    Piece b = brd.getPiece(0, 7);
    int[] expected = {};

    assertNotNull(b);
    assertTrue(b instanceof Pawn);
    assertEquals(0, b.getC());
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void middleBoardTestB() {
    Board brd = new Board("data/Pawn/P1.txt");
    Piece b = brd.getPiece(3, 3);
    int[] expected = { 3, 2, 3, 1 };

    assertNotNull(b);
    assertTrue(b instanceof Pawn);
    assertEquals(1, b.getC());
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void bottomLeftTestB() {
    Board brd = new Board("data/Pawn/P2.txt");
    Piece b = brd.getPiece(0, 0);
    int[] expected = {};

    assertNotNull(b);
    assertTrue(b instanceof Pawn);
    assertEquals(1, b.getC());
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void bottomRightTestB() {
    Board brd = new Board("data/Pawn/P3.txt");
    Piece b = brd.getPiece(7, 0);
    int[] expected = {};

    assertNotNull(b);
    assertTrue(b instanceof Pawn);
    assertEquals(1, b.getC());
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void topRightTestB() {
    Board brd = new Board("data/Pawn/P4.txt");
    Piece b = brd.getPiece(7, 7);
    int[] expected = { 7, 6, 7, 5 };

    assertNotNull(b);
    assertTrue(b instanceof Pawn);
    assertEquals(1, b.getC());
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }

  @Test
  public void topLeftTestB() {
    Board brd = new Board("data/Pawn/P5.txt");
    Piece b = brd.getPiece(0, 7);
    int[] expected = { 0, 6, 0, 5 };

    assertNotNull(b);
    assertTrue(b instanceof Pawn);
    assertEquals(1, b.getC());
    assertEquals(Arrays.toString(expected), b.legalMoves(brd, true).toString());
  }
}
