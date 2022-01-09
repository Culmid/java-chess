package cullen.middleton;

import java.util.Arrays;

public class Bishop extends Piece {
    
    public Bishop(int c, int x, int y) {
        super(c, x, y);
    }
    
    public int[] legalMoves(Board brd) {
        int[] lm = new int[20];

        // Up-Right Diag
        int potx = x + 1;
        int poty = y + 1;
        int count = 0;

        while (potx < 8 && poty < 8) {
            // if (brd.getPiece(c, x, y)) {

            // }
            lm[count++] = potx++;
            lm[count++] = poty++;
        }

        System.out.println(Arrays.toString(lm));

        return lm;
    }

    public String toString() {
        return "b";
    }
}