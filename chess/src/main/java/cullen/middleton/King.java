package cullen.middleton;

public class King extends Piece {

    public King(int x, int y) {
        super(x, y);
    }
    
    public int[] legalMoves() {
        return null;
    }

    public String toString() {
        // return "\u2654";
        return "k";
    }
}