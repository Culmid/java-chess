package cullen.middleton;

import java.util.Arrays;

public abstract class Piece {
    protected int x, y; // Check
    protected int c;

    public Piece(int c, int x, int y) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    abstract int[] legalMoves(Board brd);

    public void makeMove(Board brd, int x, int y) {
        if (brd.getPiece(x, y) != null) { // Assume Correct Colour for Capture
            brd.removePiece(x, y);
        }

        this.x = x;
        this.y = y;
    }

    public boolean isLegalMove(Board brd, int x, int y) {
        int[] lm = legalMoves(brd);

        for (int i = 0; i < lm.length; i += 2) {
            if (x == lm[i] && y == lm[i + 1]) {
                return true;
            }
        }

        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getC() {
        return c;
    }

    public abstract String toString();
}