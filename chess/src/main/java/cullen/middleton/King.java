package cullen.middleton;

public class King extends Piece {

    public King(int c, int x, int y) {
        super(c, x, y);
    }
    
    public int[] legalMoves(Board brd) {
        return null;
    }

    public String toString() {
        // return "\u2654";
        return "k";
    }
}