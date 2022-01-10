package cullen.middleton;

public class Pawn extends Piece {

    int moveCount = 0;

    public Pawn(int c, int x, int y) {
        super(c, x, y);
    }
    
    public int[] legalMoves(Board brd) {
        int[] lm = new int[20];
        int poty = c == 0 ? y + 1 : y - 1;
        int count = 0;

        if (poty < 8 && poty > 0) {
            // Normal Move
            Piece p = brd.getPiece(x, poty);

            if (p == null) {
                lm[count++] = x;
                lm[count++] = poty;
            }

            
            for (int i = -1; i < 2; i += 2) {
                // Normal Capture
                p = brd.getPiece(x + i, poty); // No Check for x in Bounds
                
                if (p != null && p.getC() != c) {
                    lm[count++] = x + i;
                    lm[count++] = poty;
                }

                // En Passant - Dodge
                p = brd.getPiece(x + i, y);

                if (p != null && p.getC() != c && p instanceof Pawn && ((Pawn)p).getMoveCount() == 1) {
                    lm[count++] = x + i;
                    lm[count++] = poty;
                }
            }

            // First Move
            if (moveCount == 0) {
                poty = c == 0 ? y + 2 : y - 2;
                p = brd.getPiece(x, poty);

                if (poty < 8 && poty > 0 && p == null) {
                    lm[count++] = x;
                    lm[count++] = poty;
                }
            }
        }
        
        return lm;
    }

    public String toString() {
        return c == 0 ? "\u2659" : "\u265F"; 
    }

    public int getMoveCount() {
        return moveCount;
    }
}