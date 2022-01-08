package cullen.middleton;

public class Pawn extends Piece {

    public Pawn(int x, int y) {
        super(x, y);
    }
    
    public int[] legalMoves() {
        return null;
    }

    public String toString() {
        return "p";
    }
}