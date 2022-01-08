package cullen.middleton;

public class Queen extends Piece {

    public Queen(int x, int y) {
        super(x, y);
    }
    
    public int[] legalMoves() {
        return null;
    }

    public String toString() {
        return "q";
    }
}