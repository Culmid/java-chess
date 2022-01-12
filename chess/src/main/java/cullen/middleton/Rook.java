package cullen.middleton;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(int c, int x, int y) {
        super(c, x, y);
    }
    
    public Rook(Rook r) {
        super(r);
    }

    public ArrayList<Integer> legalMoves(Board brd, boolean testCheck) {
        ArrayList<Integer> lm = new ArrayList<Integer>();

        // Up
        int poty = y + 1;
        while (poty < 8) {
            Piece p = brd.getPiece(x, poty);

            if (p != null && p.getC() == c) {
                break;
            }

            lm.add(x);
            lm.add(poty++);

            if (p != null) {
                break;
            }
        }

        // Down
        poty = y - 1;
        while (poty > -1) {
            Piece p = brd.getPiece(x, poty);

            if (p != null && p.getC() == c) {
                break;
            }

            lm.add(x);
            lm.add(poty--);

            if (p != null) {
                break;
            }
        }

        // Right
        int potx = x - 1;
        while (potx > -1) {
            Piece p = brd.getPiece(potx, y);

            if (p != null && p.getC() == c) {
                break;
            }

            lm.add(potx--);
            lm.add(y);

            if (p != null) {
                break;
            }
        }

        // Left
        potx = x + 1;
        while (potx < 8) {
            Piece p = brd.getPiece(potx, y);

            if (p != null && p.getC() == c) {
                break;
            }

            lm.add(potx++);
            lm.add(y);

            if (p != null) {
                break;
            }
        }

        return lm;
    }

    public String toString() {
        return c == 0 ? "\u2656" : "\u265C";
    }
}