package cullen.middleton;

public class King extends Piece {

    public King(int c, int x, int y) {
        super(c, x, y);
    }
    
    public int[] legalMoves(Board brd) {
        return null;
    }

    public String toString() {
        return c == 0 ? "\u2654" : "\u265A";
    }
}