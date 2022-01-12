package cullen.middleton;

import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(int c, int x, int y) {
        super(c, x, y);
    }
    
    // TODO: Figure Out How to Share - Rook/Bishop
    public ArrayList<Integer> legalMoves(Board brd) {
        ArrayList<Integer> lm = new ArrayList<Integer>();

        // Up-Right Diag
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

        // Up
        poty = y + 1;
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
        potx = x - 1;
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
        return c == 0 ? "\u2655" : "\u265B";
    }
}