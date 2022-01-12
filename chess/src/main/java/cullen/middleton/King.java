package cullen.middleton;

import java.util.ArrayList;

public class King extends Piece {

    private int moveCount = 0;

    public King(int c, int x, int y) {
        super(c, x, y);
    }

    public King(King k) {
        super(k);

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
                    lm.add(potx);
                    lm.add(poty);
                }
            }
        }
        
        // TODO: Fix for Interruption / Shorten
        if (moveCount == 0) {
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

    public void makeMove(Board brd, int x, int y) {
        // Castling - Assume Legal and Rook in Place
        if (x - this.x == 2) { // King Side
            brd.getPiece(x + 1, y).makeMove(brd, this.x + 1, y);
        }
        if (x - this.x == -2) { // Queen Side
            brd.getPiece(x - 2, y).makeMove(brd, this.x - 1, y);
        }

        super.makeMove(brd, x, y);
        moveCount++;
    }

    public String toString() {
        return c == 0 ? "\u2654" : "\u265A";
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
}