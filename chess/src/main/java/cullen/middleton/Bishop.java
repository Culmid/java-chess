package cullen.middleton;

import java.util.ArrayList;

public class Bishop extends Piece {
    
    public Bishop(int c, int x, int y) {
        super(c, x, y);
    }
    
    public ArrayList<Integer> legalMoves(Board brd) {
        ArrayList<Integer> lm = new ArrayList<Integer>();

        // Top-Right Diag
        int potx = x + 1;
        int poty = y + 1;

        while (potx < 8 && poty < 8) {
            Piece p = brd.getPiece(potx, poty);

            if (p != null && p.getC() == c) {
                break;
            }

            lm.add(potx++);
            lm.add(poty++);

            if (p != null) {
                break;
            }
        }

        // Bottom-Left Diag
        potx = x - 1;
        poty = y - 1;

        while (potx > -1 && poty > -1) {
            Piece p = brd.getPiece(potx, poty);

            if (p != null && p.getC() == c) {
                break;
            }

            lm.add(potx--);
            lm.add(poty--);

            if (p != null) {
                break;
            }
        }

        // Top-Left Diag
        potx = x - 1;
        poty = y + 1;

        while (potx > -1 && poty < 8) {
            Piece p = brd.getPiece(potx, poty);

            if (p != null && p.getC() == c) {
                break;
            }

            lm.add(potx--);
            lm.add(poty++);

            if (p != null) {
                break;
            }
        }

        // Bottom-Right Diag
        potx = x + 1;
        poty = y - 1;

        while (potx < 8 && poty > -1) {
            Piece p = brd.getPiece(potx, poty);

            if (p != null && p.getC() == c) {
                break;
            }

            lm.add(potx++);
            lm.add(poty--);

            if (p != null) {
                break;
            }
        }

        return lm;
    }

    public String toString() {
        return c == 0 ? "\u2657" : "\u265D";
    }
}