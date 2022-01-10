package cullen.middleton;

public class Rook extends Piece {

    public Rook(int c, int x, int y) {
        super(c, x, y);
    }
    
    public int[] legalMoves(Board brd) {
        int[] lm = new int[20];
        int count = 0;

        // Up
        int poty = y + 1;
        while (poty < 8) {
            Piece p = brd.getPiece(x, poty);

            if (p != null && p.getC() == c) {
                break;
            }

            lm[count++] = x;
            lm[count++] = poty++;

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

            lm[count++] = x;
            lm[count++] = poty--;

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

            lm[count++] = potx--;
            lm[count++] = y;

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

            lm[count++] = potx++;
            lm[count++] = y;

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