package cullen.middleton;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(int c, int x, int y) {
        super(c, x, y);
    }

    public Knight(Knight k) {
        super(k);
    }
    
    public ArrayList<Integer> legalMoves(Board brd, boolean testCheck) {
        ArrayList<Integer> lm = new ArrayList<Integer>();

        int[][] changes = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

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

        if (testCheck) {
            lm = pruneMoves(brd, lm);
        }
        
        return lm;
    }

    public String toString() {
        return c == 0 ? "\u2658" : "\u265E";
    }
}