package cullen.middleton;

import static org.junit.Assert.*;

import org.junit.Test;

public class BishopTest {

  @Test
  public void allDiagOpenTest() {
    Board brd = new Board("data/Bishop/b1.txt");
    Piece b = brd.getPiece(3, 3);

    assertNotNull(b);
    assertTrue(b instanceof Bishop);
    // assertEquals(expected, brd.toString());
  }
}
