package cullen.middleton;

public class Rook extends Piece {

    public Rook(int x, int y) {
        super(x, y);
    }
    
    public int[] legalMoves() {
        return null;
    }

    public String toString() {
        return "r";
    }
}