package cullen.middleton;

public class Knight extends Piece {

    public Knight(int c, int x, int y) {
        super(c, x, y);
    }
    
    public int[] legalMoves(Board brd) {
        return null;
    }

    public String toString() {
        return c == 0 ? "\u2658" : "\u265E";
    }
}