package cullen.middleton;

public class Pawn extends Piece {

    public Pawn(int c, int x, int y) {
        super(c, x, y);
    }
    
    public int[] legalMoves(Board brd) {
        return null;
    }

    public String toString() {
        return c == 0 ? "\u2659" : "\u265F"; 
    }
}