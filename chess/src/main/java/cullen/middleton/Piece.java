package cullen.middleton;

import java.util.ArrayList;

public abstract class Piece {
    protected int x, y; // Check
    protected int c;

    public Piece(int c, int x, int y) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public Piece(Piece p) {
        x = p.getX();
        y = p.getY();
        c = p.getC();
    }

    abstract ArrayList<Integer> legalMoves(Board brd, boolean testCheck);

    public void makeMove(Board brd, int x, int y) {
        if (brd.getPiece(x, y) != null) { // Assume Correct Colour for Capture
            brd.removePiece(x, y);
        }

        this.x = x;
        this.y = y;
    }

    public boolean isLegalMove(Board brd, int x, int y, boolean testCheck) {
        ArrayList<Integer> lm = legalMoves(brd, testCheck);

        for (int i = 0; i < lm.size(); i += 2) {
            if (x == lm.get(i) && y == lm.get(i + 1)) {
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }


        if (!(o instanceof Piece)) {
            return false;
        }

        Piece p = (Piece) o;

        return x == p.getX() && y == p.getY() && c == p.getC();
    }

    public ArrayList<Integer> pruneMoves(Board brd, ArrayList<Integer> lm) {
        ArrayList<Integer> lmNew = new ArrayList<Integer>();
        for (int i = 0; i < lm.size(); i += 2) {
            if (!brd.testMoveCheck(this, lm.get(i), lm.get(i + 1))) {
                lmNew.add(lm.get(i));
                lmNew.add(lm.get(i + 1));
            }
        }

        return lmNew;
    }
}