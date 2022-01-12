package cullen.middleton;

import java.util.ArrayList;

public class King extends Piece {

    private boolean castled = false;
    private int moveCount = 0;

    public King(int c, int x, int y) {
        super(c, x, y);
    }

    public King(King k) {
        super(k);

        castled = k.getCastled();
        moveCount = k.getMoveCount();
    }
    
    public ArrayList<Integer> legalMoves(Board brd, boolean testCheck) {
        ArrayList<Integer> lm = new ArrayList<Integer>();

        int[][] changes = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

        for (int i = 0; i < 8; i++) {
            int potx = x + changes[i][0];
            int poty = y + changes[i][1];
            
            if (potx > -1 && potx < 8 && poty > -1 && poty < 8) {
                Piece p = brd.getPiece(potx, poty);

                if (p != null && p.getC() != c || p == null) {
                    // TODO: Fix for Protected Pieces
                    lm.add(potx);
                    lm.add(poty);
                }
            }
        }
        
        // TODO: Fix for Interruption / Shorten
        if (!castled && moveCount == 0) {
            // King Side
            boolean flag = true;
            for (int i = 1; i < 3; i++) {
                if (brd.getPiece(x + i, y) != null) {
                    flag = false;
                    break;
                }
            }

            if (flag && brd.getPiece(x + 3, y) instanceof Rook && brd.getPiece(x + 3, y).getC() == c) {
                lm.add(x + 2);
                lm.add(y);
            }

            // Queen Side
            flag = true;
            for (int i = 1; i < 4; i++) {
                if (brd.getPiece(x - i, y) != null) {
                    flag = false;
                    break;
                }
            }

            if (flag && brd.getPiece(x - 4, y) instanceof Rook && brd.getPiece(x - 4, y).getC() == c) {
                lm.add(x - 2);
                lm.add(y);
            }
        }

        if (testCheck) {
            lm = pruneMoves(brd, lm);
        }

        return lm;
    }

    public String toString() {
        return c == 0 ? "\u2654" : "\u265A";
    }

    public boolean getCastled() {
        return castled;
    }

    public int getMoveCount() {
        return moveCount;
    }
}