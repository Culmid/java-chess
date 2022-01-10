package cullen.middleton;

public class Knight extends Piece {

    public Knight(int c, int x, int y) {
        super(c, x, y);
    }
    
    public int[] legalMoves(Board brd) {
        int[] lm = new int[20];

        int[][] changes = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        int count = 0;

        for (int i = 0; i < 8; i++) {
            int potx = x + changes[i][0];
            int poty = y + changes[i][1];

            if (potx > -1 && potx < 8 && poty > -1 && poty < 8) {
                Piece p = brd.getPiece(potx, poty);

                if (p != null && p.getC() != c || p == null) {
                    lm[count++] = potx;
                    lm[count++] = poty;
                }
            }
        }
        
        return lm;
    }

    public String toString() {
        return c == 0 ? "\u2658" : "\u265E";
    }
}