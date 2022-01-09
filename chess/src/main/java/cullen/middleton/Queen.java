package cullen.middleton;

public class Queen extends Piece {

    public Queen(int c, int x, int y) {
        super(c, x, y);
    }
    
    public int[] legalMoves(Board brd) {
        return null;
    }

    public String toString() {
        return c == 0 ? "\u2655" : "\u265B";
    }
}