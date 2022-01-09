package cullen.middleton;

public class Rook extends Piece {

    public Rook(int c, int x, int y) {
        super(c, x, y);
    }
    
    public int[] legalMoves(Board brd) {
        return null;
    }

    public String toString() {
        return "r";
    }
}